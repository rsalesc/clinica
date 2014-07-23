package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class CpfContemEspaco extends Exception {

	public CpfContemEspaco(){
		super("CPF contemdo espaços");
	}
	
}
