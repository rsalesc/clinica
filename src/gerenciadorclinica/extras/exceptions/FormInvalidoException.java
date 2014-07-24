package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class FormInvalidoException extends Exception {
	
	public FormInvalidoException(String msg){
		super(msg);
	}
	
	public FormInvalidoException(){
		this("Formul�rio preenchido de forma inv�lida.");
	}
}
