package gerenciadorclinica.clinica;
import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.util.LinkedHashMap;

public class Exame extends Entrada {

	private String exame;
	private Paciente paciente;
	private String observacao;
	
	private final static String TABELA = "exames";
	
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

	public void salvar(DB db) throws Exception {
		db.checkConnection();
		
		PreparedStatement stm = null;
		
		if (paciente.getID() == 0)
			throw new Exception("ID inválido");
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("exame", exame);
		map.put("paciente", paciente.getID());
		map.put("observacao", observacao);
		
		if(isNovaEntrada()){
			stm = db.geraInsertStatement(Exame.TABELA, map);
			stm.executeUpdate();
			this.setID(db.getUltimoInsertID(Exame.TABELA));
		}
		else{
			
		}
	}
	
	public void solicitarExame(){}
	
	public void vincularResultadoExame(){ }

}
