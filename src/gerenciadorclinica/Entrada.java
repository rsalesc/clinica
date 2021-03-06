package gerenciadorclinica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Entrada{

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

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public boolean isNovaEntrada(){
		return (getID() == 0);
	}
	
	public void preencheEntrada(DB db, ResultSet rs) throws SQLException{
		setID(rs.getInt("id"));
		setDataCriacao(DB.unixToDate(rs.getLong("dataCriacao")));
	}
	
}
