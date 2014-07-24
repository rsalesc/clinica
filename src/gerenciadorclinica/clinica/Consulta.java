package gerenciadorclinica.clinica;
import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;

public class Consulta extends Entrada{
	private Date dataMarcada;
	private Paciente paciente;
	private String observacao;
	
	private final static String TABELA = "consultas";
	
	public Consulta(int ID){
		super(ID);
	}
	
	public Consulta(int ID, Date dataMarcada, Paciente paciente, String observacao) {
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
			throw new Exception("ID inválido.");
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("dataMarcada", dataMarcada);
		map.put("pacienteId", paciente.getID());
		map.put("observacao", observacao);
		
		if(isNovaEntrada()){
			stm = db.geraInsertStatement(Consulta.TABELA, map);
			stm.executeUpdate();
			this.setID(db.getUltimoInsertID(Consulta.TABELA));
		}
		else{
			map.remove("pacienteId");
			stm = db.geraUpdateStatement(Consulta.TABELA, map, "id = " + getID());
			if(stm.executeUpdate() == 0)
				throw new SQLException("[Problema no banco de dados] A entrada não pôde ser atualizada.");
		}
		stm.close();
	}
	
	public void carregar(DB db) throws Exception {
		PreparedStatement stm = db.geraSelectStatement(Consulta.TABELA, "id = " + getID());
		ResultSet rs = stm.executeQuery();
		if(!rs.next())
			throw new SQLException("[Erro ao carregar] Entrada não encontrada.");
		
		setDataCriacao(DB.unixToDate(rs.getLong("dataCriacao")));
		this.paciente = new Paciente(rs.getByte("pacienteId"));
		this.paciente.carregar(db);
		this.dataMarcada = DB.unixToDate(rs.getLong("dataMarcada"));
		this.observacao = rs.getString("observacao");
	}
	
}
