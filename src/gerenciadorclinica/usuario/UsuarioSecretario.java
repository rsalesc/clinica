package gerenciadorclinica.usuario;


public class UsuarioSecretario extends Usuario {

	public UsuarioSecretario(int id) {
		super(id);
	}
	
	public UsuarioSecretario(int id, String username) {
		super(id, username);
	}
	
	public int getLevel(){
		return 0;
	}
}
