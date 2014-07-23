package gerenciadorclinica.extras;

@SuppressWarnings("serial")
public class CpfTamanhoErrado extends Exception {


	public CpfTamanhoErrado() {
		super("CPF de tamanho incorreto!");
	}

}
