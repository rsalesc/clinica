package gerenciadorclinica.usuario;


public class UsuarioSecretario extends Usuario {

	public UsuarioSecretario(int Id) {
		super(Id);
	}
	
	public UsuarioSecretario(String username, int Id) {
		super(username, 0, Id);
	}
	
	public UsuarioSecretario(String username) {
		super(username, 0);
	}
	
	public int getLevel(){
		return 0;
	}
}
