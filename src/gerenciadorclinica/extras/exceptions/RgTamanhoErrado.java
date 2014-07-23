package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class RgTamanhoErrado extends Exception {

	public RgTamanhoErrado(){
		super("RG de tamanho incorreto!");
	}

}
