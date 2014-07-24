package gerenciadorclinica;

import gerenciadorclinica.extras.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.tools.JavaCompiler;

public class DB implements Cloneable {
	
	private String connString;
	private Connection connection;
	
	
	public DB(String connString){
		this.connString = connString;
	}
	
	public String getConnString() {
		return connString;
	}

	public void setConnString(String connString) {
		this.connString = connString;
	}

	public Connection getConnection() {
		return connection;
	}

	public boolean isConnected(){
		try {
			return (connection != null && !connection.isClosed());
		} catch (SQLException e) {
			return false;
		}
	}
	
	public void checkConnection() throws SQLException{
		if(!isConnected())
			throw new SQLException("Not connected to database");
	}
	
	public void conecta() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection(connString);	
	}


	public void desconecta() throws SQLException {
		if(connection != null){
			connection.close();
			connection = null;
		}
	}
	
	public static PreparedStatement resolvePreparedStatement(PreparedStatement stm, Object[] set) throws SQLException{
		for(int i = 0; i < set.length; i++){
			if(set[i] instanceof String){
				stm.setString(i+1, (String)set[i]);
			}else if(set[i] instanceof Date){
				stm.setLong(i+1, ((Date)set[i]).getTime()/1000L);
			}else if(set[i] instanceof Integer){
				stm.setInt(i+1,  ((Integer)set[i]).intValue());
			}else if(set[i] instanceof Byte){
				stm.setByte(i+1, ((Byte)set[i]).byteValue());
			}else{
				throw new SQLException("Tipo invalido");
			}
		}
		return stm;
	}
	
	public PreparedStatement geraInsertStatement(String tabela, LinkedHashMap<String, Object> map) throws SQLException {
		checkConnection();
		String concatKeys = Utils.join(",", map.keySet().toArray());
		String concatParams = Utils.join(",", "?", map.size());
		return DB.resolvePreparedStatement(connection.prepareStatement("insert into " + tabela + " (" + concatKeys + ") values (" + concatParams + ")"), map.values().toArray());
	}
	
	public PreparedStatement geraSelectStatement(String tabela) throws SQLException{
		checkConnection();
		return connection.prepareStatement("select * from " + tabela);
	}
	
	public PreparedStatement geraUpdateStatement(String tabela, LinkedHashMap<String, Object> map, String where) throws SQLException {
		String concatSet = Utils.join(" = ?, ", map.keySet().toArray());
		if(concatSet.length() == 0)
			throw new SQLException("Parâmetros inválidos.");
		concatSet += " = ?";
		String query = "update " + tabela + " SET " + concatSet + " WHERE " + where;
		return DB.resolvePreparedStatement(connection.prepareStatement(query), map.values().toArray());
	}
	
	public int getUltimoInsertID(String tabela) throws SQLException{
		checkConnection();
		ResultSet rs = connection.createStatement().executeQuery("SELECT last_insert_rowid() FROM " + tabela);
		if(rs.next())
			return rs.getInt(1);
		throw new SQLException();
	}
	
	public DB clone(){
		return new DB(connString);
	}
	
	public static java.sql.Date convertDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
}
