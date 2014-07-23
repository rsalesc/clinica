package gerenciadorclinica.clinica;
import gerenciadorclinica.Entrada;
import java.util.Date;

public class Consulta extends Entrada{
	private Date dataMarcada;
	private Paciente paciente;
	private String observacao;
	
	public Consulta(Date dataMarcada, Paciente paciente, int ID) {
		super(ID);
		this.dataMarcada = dataMarcada;
		this.paciente = paciente;
		this.observacao = "";
	}
	
	public Consulta(Date dataMarcada, Paciente paciente) {
		super();
		this.dataMarcada = dataMarcada;
		this.paciente = paciente;
		this.observacao = "";
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Date getdataMarcada() {
		return dataMarcada;
	}

	public void setdataMarcada(Date dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void marcarConsulta(){}
	
	public void desmarcarConsulta(){}
	
	// public final static Consulta[] pesquisarConsultas(String paciente);
	
}
