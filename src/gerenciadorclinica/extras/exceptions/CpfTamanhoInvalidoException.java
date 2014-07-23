package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class CpfTamanhoInvalidoException extends CpfInvalidoException {

	public CpfTamanhoInvalidoException(String msg){
		super(msg);
	}
	
	public CpfTamanhoInvalidoException() {
		this("CPF de tamanho inválido.");
	}

}
