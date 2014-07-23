package gerenciadorclinica.extras;

@SuppressWarnings("serial")
public class CpfContemLetra extends Exception {

	public CpfContemLetra(){
		super("CPF contendo letras ou outros caracteres em sua composição!");
	}
	
}
