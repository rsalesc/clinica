package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class RgContemEspaco extends Exception {

	public RgContemEspaco(){
		super("RG contendo espaços em sua composição!");
	}
	
}
