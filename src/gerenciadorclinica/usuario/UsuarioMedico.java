package gerenciadorclinica.usuario;


public class UsuarioMedico extends Usuario {

	public UsuarioMedico(int id) {
		super(id);
	}
	
	public UsuarioMedico(int id, String username) {
		super(id, username);
	}
	
	public int getLevel(){
		return 1;
	}

}
