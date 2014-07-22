package gerenciadorclinica.clinica;
import gerenciadorclinica.Entrada;

public class Exame extends Entrada {

	private String exame;
	private Paciente paciente;
	private String observacao;
	
	public Exame(Paciente paciente, String exame) {
		super();
		this.exame = exame;
		this.paciente = paciente;
		this.observacao = "";
	}
	
	public Exame(Paciente paciente, String exame, int ID) {
		super(ID);
		this.exame = exame;
		this.paciente = paciente;
		this.observacao = "";
	}
	
	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void solicitarExame(){}
	
	public void vincularResultadoExame(){ }

}
