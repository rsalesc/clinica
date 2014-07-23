package gerenciadorclinica.extras.exceptions;

@SuppressWarnings("serial")
public class TelefoneContemLetra extends Exception {

	public TelefoneContemLetra(){
		super("Telefone contendo letras ou outros caracteres em sua composição!");
	}
	
}
