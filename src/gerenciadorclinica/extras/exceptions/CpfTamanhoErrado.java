package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class CpfTamanhoErrado extends Exception {


	public CpfTamanhoErrado() {
		super("CPF de tamanho incorreto!");
	}

}
