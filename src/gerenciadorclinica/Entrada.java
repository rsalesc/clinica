package gerenciadorclinica;
import java.util.Date;

public class Entrada {

	private int ID;
	private Date datacriacao;
	
	public Entrada(int id) {
		this.ID = id;
		this.datacriacao = new Date();
	}
	
	public Entrada() {
		this(0);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}
	
}
