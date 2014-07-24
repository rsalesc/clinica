package gerenciadorclinica.clinica;
import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.LinkedHashMap;

public class Consulta extends Entrada{
	private Date dataMarcada;
	private Paciente paciente;
	private String observacao;
	
	private final static String TABELA = "consultas";
	
	public Consulta(Date dataMarcada, Paciente paciente, String observacao, int ID) {
		super(ID);
		this.dataMarcada = dataMarcada;
		this.paciente = paciente;
		this.observacao = observacao;
	}
	
	public Consulta(Date dataMarcada, Paciente paciente, String observacao) {
		super();
		this.dataMarcada = dataMarcada;
		this.paciente = paciente;
		this.observacao = observacao;
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
	
	public void salvar(DB db) throws Exception {
		db.checkConnection();
		
		PreparedStatement stm = null;
		
		if (paciente.getID() == 0)
			throw new Exception("ID inválido");
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("dataMarcada", dataMarcada);
		map.put("paciente", paciente.getID());
		map.put("observacao", observacao);
		
		if(isNovaEntrada()){
			stm = db.geraInsertStatement(Consulta.TABELA, map);
			stm.executeUpdate();
			this.setID(db.getUltimoInsertID(Consulta.TABELA));
		}
		else{
			
		}
	}
	
}
