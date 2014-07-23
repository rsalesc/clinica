package gerenciadorclinica.extras;

public class Estado {

	private char UFselecionado;
	public final static String[] UFpossiveis = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
												 "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
												 "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	public Estado(char UF){
		this.UFselecionado = UF;
	}

	@Override
	public String toString() {
		return Estado.UFpossiveis[UFselecionado];
	}
	
	
}
