package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class RgContemLetra extends Exception {

	public RgContemLetra(){
		super("RG contendo letras ou outros caracteres em sua composição!");
	}
	
}
