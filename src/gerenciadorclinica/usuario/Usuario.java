package gerenciadorclinica.usuario;

import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;
import gerenciadorclinica.extras.exceptions.UsuarioInvalidoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Usuario extends Entrada {

	private final static String TABELA = "usuarios";
	
	private String usuario;
	@SuppressWarnings("unused")
	private int level;
	
	public Usuario(String usuario, int level, int Id) {
		super(Id);
		this.usuario = usuario;
		this.level = level;
	}
	
	public Usuario(String usuario, int level){
		super();
		this.usuario = usuario;
		this.level= level;
	}
	
	public Usuario(int Id){
		super(Id);
	}
	
	public void salvar(){}
	
	public static Usuario getUsuarioAutenticado(DB db, String usuario, String senha) throws UsuarioInvalidoException, SQLException {
		PreparedStatement stm = null;
		
		String query = "select id from " + Usuario.TABELA + " WHERE usuario = ? and senha = ?";
		stm = db.getConnection().prepareStatement(query);
		stm.setString(1,  usuario);
		stm.setString(2, usuario);
		
		ResultSet rs = stm.executeQuery();
		if(!stm.executeQuery().next())
			throw new UsuarioInvalidoException();
		
		rs.getString("usuario");
		rs.getString("senha");
		int level = rs.getInt("nivel");
		
		return (level == 1) ? new UsuarioMedico(usuario) : new UsuarioSecretario(usuario);
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public abstract int getLevel();

}
