package gerenciadorclinica.usuario;

import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractUsuario extends Entrada {

	private final static String TABELA = "usuarios";
	
	private String usuario;
	private String nome;
	
	public AbstractUsuario(int Id) {
		super(Id);
	}
	
	public AbstractUsuario(int Id, String usuario) {
		super(Id);
		this.usuario = usuario;
	}
	
	public void salvar(){}
	
	public static AbstractUsuario getUsuarioAutenticado(DB db, String usuario, String senha) throws SQLException {
		PreparedStatement stm = null;
		
		String query = "select * from " + AbstractUsuario.TABELA + " WHERE usuario = ? and senha = ?";
		stm = db.getConnection().prepareStatement(query);
		stm.setString(1,  usuario);
		stm.setString(2, usuario);
		
		ResultSet rs = stm.executeQuery();
		if(!stm.executeQuery().next())
			return null;
		
		int id = rs.getInt("id");
		int level = rs.getInt("nivel");
		
		AbstractUsuario u = (level == 1) ? new UsuarioMedico(id, usuario) : new UsuarioSecretario(id, usuario); 
		u.setNome(rs.getString("nome"));
		u.setDataCriacao(DB.unixToDate(rs.getLong("dataCriacao")));
		
		return u;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public abstract int getLevel();

}
