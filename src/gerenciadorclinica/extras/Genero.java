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

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		if (this.genero.getValue() == 0)
			return "Masculino";
		return "Feminino";
	}

	
}
