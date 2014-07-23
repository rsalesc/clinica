package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class TelefoneContemEspaco extends Exception {

	public TelefoneContemEspaco(){
		super("Telefone contendo espaços em sua composição!");
	}
	
}
