package gerenciadorclinica;

import gerenciadorclinica.extras.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
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
		Class.forName("org.sqlite.jdbc");
		connection = DriverManager.getConnection(connString);	
	}


	public void desconecta() throws SQLException {
		if(connection != null){
			connection.close();
			connection = null;
		}
	}
	
	public static Statement resolvePreparedStatement(PreparedStatement stm, Object[] set) throws SQLException{
		for(int i = 1; i <= set.length; i++){
			if(set[i] instanceof String){
				stm.setString(i, (String)set[i]);
			}else if(set[i] instanceof java.sql.Date){
				stm.setDate(i, (java.sql.Date)set[i]);
			}else if(set[i] instanceof Integer){
				stm.setInt(i,  ((Integer)set[i]).intValue());
			}else if(set[i] instanceof Byte){
				stm.setByte(i, ((Byte)set[i]).byteValue());
			}else{
				throw new SQLException("Tipo invalido");
			}
		}
		return stm;
	}
	
	public Statement geraInsertStatement(String tabela, LinkedHashMap<String, Object> map) throws SQLException {
		String concatKeys = Utils.join(",", map.keySet().toArray());
		String concatParams = Utils.join(",", "?", map.size());
		return DB.resolvePreparedStatement(connection.prepareStatement("insert into " + tabela + " (" + concatKeys + ") values (" + concatParams + ")"), map.values().toArray());
	}
	
	public DB clone(){
		return new DB(connString);
	}
	
	public static java.sql.Date convertDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
}
