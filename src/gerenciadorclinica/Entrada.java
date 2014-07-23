package gerenciadorclinica;
import java.util.Date;

public class Entrada {

	private int ID;
	private Date dataCriacao;
	
	public Entrada(int id) {
		this.ID = id;
		this.dataCriacao = new Date();
	}
	
	public Entrada() {
		this(0);
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDatacriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
