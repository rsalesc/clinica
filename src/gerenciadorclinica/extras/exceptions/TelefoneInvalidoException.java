package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class TelefoneInvalidoException extends Exception {
	
	public TelefoneInvalidoException(String msg){
		super(msg);
	}

	public TelefoneInvalidoException(){
		this("Telefone de formato inválido.");
	}
	
}
