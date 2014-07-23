package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class CpfInvalidoException extends Exception {
	
	public CpfInvalidoException(String msg){
		super(msg);
	}
	
	public CpfInvalidoException(){
		this("Formato de CPF inválido.");
	}
	
}
