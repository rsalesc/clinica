package gerenciadorclinica.clinica;
import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class Exame extends Entrada {

	private String exame;
	private Paciente paciente;
	private String observacao;
	
	private final static String TABELA = "exames";
	
	public Exame(int ID){
		super(ID);
	}
	
	public Exame(Paciente paciente, String exame, String observacao) {
		super();
		this.exame = exame;
		this.paciente = paciente;
		this.observacao = observacao;
	}
	
	public Exame(Paciente paciente, String exame, String observacao, int ID) {
		super(ID);
		this.exame = exame;
		this.paciente = paciente;
		this.observacao = observacao;
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
			throw new Exception("ID inválido.");
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("exame", exame);
		map.put("pacienteId", paciente.getID());
		map.put("observacao", observacao);
		
		if(isNovaEntrada()){
			stm = db.geraInsertStatement(Exame.TABELA, map);
			stm.executeUpdate();
			this.setID(db.getUltimoInsertID(Exame.TABELA));
		}
		else{
			map.remove("pacienteId");
			stm = db.geraUpdateStatement(Exame.TABELA, map, "id = " + getID());
			if(stm.executeUpdate() == 0)
				throw new SQLException("[Problema no banco de dados] A entrada não pôde ser atualizada.");
		}
		stm.close();
	}
	
	public void carregar(DB db) throws Exception {
		
	}
	
	public void vincularResultadoExame(){ }

}
