package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class EmailInvalidoException extends Exception {
	public EmailInvalidoException(String msg){
		super(msg);
	}
	
	public EmailInvalidoException(){
		this("E-mail de formato inválido.");
	}
}
