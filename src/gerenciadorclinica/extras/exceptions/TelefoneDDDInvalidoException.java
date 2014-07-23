package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class TelefoneDDDInvalidoException extends TelefoneInvalidoException {

	public TelefoneDDDInvalidoException(String msg){
		super(msg);
	}
	
	public TelefoneDDDInvalidoException(){
		this("Telefone com DDD inválido.");
	}
	
}
