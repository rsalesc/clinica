package gerenciadorclinica.usuario;


public class UsuarioMedico extends Usuario {

	public UsuarioMedico(String username) {
		super(username, 1);
	}
	
	public int getLevel(){
		return 1;
	}

}
