package gerenciadorclinica.usuario;


public class UsuarioMedico extends Usuario {

	public UsuarioMedico(int Id) {
		super(Id);
	}
	
	public UsuarioMedico(String username, int Id) {
		super(username, 1, Id);
	}
	
	public UsuarioMedico(String username) {
		super(username, 1);
	}
	
	public int getLevel(){
		return 1;
	}

}
