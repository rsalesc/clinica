package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class RgTamanhoInvalidoException extends RgInvalidoException {

	public RgTamanhoInvalidoException(String msg){
		super(msg);
	}
	
	public RgTamanhoInvalidoException(){
		this("RG de tamanho inválido.");
	}

}
