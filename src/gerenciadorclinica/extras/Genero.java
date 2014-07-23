package gerenciadorclinica.extras;

public class Genero {

	private byte genero;
	
	public Genero(byte genero) {
		this.genero = genero;
	}

	public byte getGenero() {
		return genero;
	}

	public void setGenero(byte genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		if (this.genero == 0)
			return "Masculino";
		return "Feminino";
	}

	
}
