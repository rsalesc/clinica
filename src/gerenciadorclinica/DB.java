package gerenciadorclinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB implements Cloneable {
	
	String connString;
	Connection connection;
	Statement statement;
	
	
	public DB(String connString){
		this.connString = connString;
	}


	public void conecta() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.jdbc");
		connection = DriverManager.getConnection(connString);	
	}


	public void desconecta() throws SQLException {
		if(connection != null)
			connection.close();
	}
	
	public DB clone(){
		return new DB(connString);
	}
	
}
