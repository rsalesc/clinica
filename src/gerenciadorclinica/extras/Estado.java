package gerenciadorclinica.extras;

public class Estado {
	
	private byte selecionado;
	public final static String[] UFpossiveis = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
												 "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
												 "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	public Estado(byte UF){
		this.selecionado = UF;
	}

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Estado)) return false;
		if(obj == this) return true;
		return (((Estado)obj).getSelecionado() == this.selecionado);
	}
	
	@Override
	public String toString() {
		return Estado.UFpossiveis[selecionado];
	}
	
	public byte getSelecionado(){
		return selecionado;
	}
	
}
