package gerenciadorclinica.usuario;


public class UsuarioSecretario extends Usuario {

	public UsuarioSecretario(String username) {
		super(username, 0);
	}
	
	public int getLevel(){
		return 0;
	}
}
