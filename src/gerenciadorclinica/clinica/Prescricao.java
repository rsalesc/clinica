package gerenciadorclinica.clinica;
import gerenciadorclinica.Entrada;;

public class Prescricao extends Entrada{

	private String prescricao;
	private String observacao;
	
	public Prescricao(String prescricao, int ID) {
		super(ID);
		this.prescricao = prescricao;
		this.observacao = "";
	}

	public Prescricao(String prescricao, String observacao, int ID) {
		super(ID);
		this.prescricao = prescricao;
		this.observacao = observacao;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String toString(){
		return ("Prescricao: " + prescricao + " Observações: " + observacao);
	}
	
}
