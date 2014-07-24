package gerenciadorclinica.extras;

public class Genero {

	public enum GeneroEnum{
		MASCULINO((byte)0), FEMININO((byte)1);
		private byte value;
		
		private GeneroEnum(byte gen){
			this.setValue(gen);
		}
		
		public byte getValue() {
			return value;
		}

		public void setValue(byte gen) {
			this.value = gen;
		}
		
	}
	
	private GeneroEnum genero;
	
	public Genero(GeneroEnum genero) {
		this.genero = genero;
	}
	
	public Genero(byte genero){
		setGenero(genero);
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setValue(byte genero){
		setGenero(genero);
	}
	
	public byte getValue(){
		return genero.getValue();
	}
	
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	
	public void setGenero(byte genero){
		this.genero = GeneroEnum.values()[genero];
	}

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Genero)) return false;
		if(obj == this) return true;
		return ((Genero)obj).getValue() == getValue();
	}
	
	@Override
	public String toString() {
		if (this.genero == GeneroEnum.MASCULINO)
			return "Masculino";
		return "Feminino";
	}

	
}
