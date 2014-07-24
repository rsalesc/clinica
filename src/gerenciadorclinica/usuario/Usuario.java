package gerenciadorclinica.usuario;

import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Usuario extends Entrada {

	private final static String TABELA = "usuarios";
	
	private String username;
	@SuppressWarnings("unused")
	private int level;
	
	public Usuario(String username, int level) {
		this.username = username;
		this.level = level;
	}
	
	public void salvar(){}
	
	public void carregar(DB db) throws SQLException {
		PreparedStatement stm = null;
		
		String query = "select id from " + Usuario.TABELA + " WHERE username = ?";
		stm = db.getConnection().prepareStatement(query);
		stm.setString(1,  username);
		
		ResultSet rs = stm.executeQuery();
		if(!rs.next())
			throw new SQLException("[Erro ao carregar] Usuario ou senha incorretos.");
		
		
		
	}
	
	public abstract int getLevel();

}
