package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class UsuarioInvalidoException extends Exception {

	public UsuarioInvalidoException(String msg){
		super(msg);
	}
	
	public UsuarioInvalidoException(){
		this("Usuario incorreto.");
	}
	
}
