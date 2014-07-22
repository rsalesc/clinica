package gerenciadorclinica.clinica;
import gerenciadorclinica.Entrada;
import java.util.Date;

public class Consulta extends Entrada{
	private Date datamarcada;
	private Paciente paciente;
	private String observacao;
	
	public Consulta(Date datamarcada, Paciente paciente, int ID) {
		super(ID);
		this.datamarcada = datamarcada;
		this.paciente = paciente;
		this.observacao = "";
	}
	
	public Consulta(Date datamarcada, Paciente paciente) {
		super();
		this.datamarcada = datamarcada;
		this.paciente = paciente;
		this.observacao = "";
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Date getDatamarcada() {
		return datamarcada;
	}

	public void setDatamarcada(Date datamarcada) {
		this.datamarcada = datamarcada;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void marcarConsulta(){}
	
	public void desmarcarConsulta(){}
	
	public final static Consulta[] pesquisarConsultas(String paciente);
	
}
