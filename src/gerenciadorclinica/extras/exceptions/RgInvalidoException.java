package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class RgInvalidoException extends Exception {

	public RgInvalidoException(String msg){
		super(msg);
	}
	
	public RgInvalidoException(){
		this("RG de formato inválido.");
	}
	
}
