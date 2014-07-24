package gerenciadorclinica.clinica;
import gerenciadorclinica.DB;
import gerenciadorclinica.Entrada;
import gerenciadorclinica.IPersistente;
import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class Paciente extends Entrada implements IPersistente{
	
	public final static String TABELA = "pacientes";
	
	private String nome;
	private Genero genero;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String endereco;
	private String cidade;
	private Estado estado;
	private String telefone;
	private String email;
	private String observacao;
	private String bairro;
	
	public Paciente(int ID, String nome, Genero genero, Date dataNascimento, String cpf, String rg, String endereco, String cidade, Estado estado,
			String telefone, String email, String observacao, String bairro) {
			super(ID);
			this.nome = nome;
			this.genero = genero;
			this.dataNascimento = dataNascimento;
			this.cpf = cpf;
			this.rg = rg;
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
			this.estado = estado;
			this.cidade = cidade;
			this.observacao = observacao;
			this.bairro = bairro;
		}
	
	public Paciente(String nome, Genero genero, Date dataNascimento, String cpf, String rg, String endereco, String cidade, Estado estado,
					String telefone, String email, String observacao, String bairro) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.estado = estado;
		this.cidade = cidade;
		this.observacao = observacao;
		this.bairro = bairro;
	}
	
	public Paciente(int ID){
		super(ID);
	}

		
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
	
	public String getBairro(){
		return this.bairro;
	}
	
	public int getIdade(){
		Calendar calendarToday = Calendar.getInstance();
		Calendar calendarNascimento = Calendar.getInstance();
		calendarToday.setTime(new Date());
		calendarNascimento.setTime(dataNascimento);
		int idade = calendarToday.get(Calendar.YEAR) - calendarNascimento.get(Calendar.YEAR);
		if(calendarToday.get(Calendar.DAY_OF_YEAR) < calendarNascimento.get(Calendar.DAY_OF_YEAR) && idade > 0)
			idade--;
		return idade;
	}

	@SuppressWarnings("resource")
	@Override
	public void salvar(DB db) throws SQLException, NullPointerException {
		db.checkConnection();
		
		if(genero == null || estado == null)
			throw new NullPointerException();
		
		PreparedStatement stm = null;
		
		// Checa se não é uma entrada "repetida"
		{
			String query = "select id from " + Paciente.TABELA + " WHERE ((cpf <> '' AND cpf = ?) OR rg = ?)";
			if(!isNovaEntrada()){
				query += " AND id <> " + getID();
			}
			stm = db.getConnection().prepareStatement(query);
			stm.setString(1,  cpf);
			stm.setString(2,  rg);
			if(stm.executeQuery().next())
				throw new SQLException("CPF ou RG já cadastrado.");
			
			stm.close();	
		}
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("nome", nome);
		map.put("genero", new Byte(genero.getGenero().getValue()));
		map.put("dataNascimento", dataNascimento);
		map.put("cpf", cpf);
		map.put("rg", rg);
		map.put("endereco", endereco);
		map.put("cidade", cidade);
		map.put("estado", new Byte(estado.getSelecionado()));
		map.put("telefone", telefone);
		map.put("email", email);
		map.put("observacao", observacao);
		map.put("bairro", bairro);
		
		if(isNovaEntrada()){
			stm = db.geraInsertStatement(Paciente.TABELA, map);
			stm.executeUpdate();
			this.setID(db.getUltimoInsertID(Paciente.TABELA));
		}else{
			stm = db.geraUpdateStatement(Paciente.TABELA, map, "id = " + getID());
			if(stm.executeUpdate() == 0)
				throw new SQLException("[Erro ao atualizar] A entrada não encontrada.");
		}
		stm.close();
	}

	@Override
	public void carregar(DB db) throws SQLException {
		PreparedStatement stm = db.geraSelectStatement(Paciente.TABELA, "id = " + getID());
		ResultSet rs = stm.executeQuery();
		if(!rs.next())
			throw new SQLException("[Erro ao carregar] Entrada não encontrada.");
		
		preencheEntrada(db, rs);		
	}
	
	@Override
	public void remover(DB db) throws SQLException{
		if(db.getConnection().createStatement().executeUpdate("delete from " + TABELA + " WHERE id = " + getID()) == 0)
			throw new SQLException("[Erro ao remover] Entrada não encontrada.");
		
		db.getConnection().createStatement().executeUpdate("delete from " + Consulta.TABELA + " WHERE pacienteId = " + getID());
		db.getConnection().createStatement().executeUpdate("delete from " + Exame.TABELA + " WHERE pacienteId = " + getID());
	}
	
	@Override
	public void preencheEntrada(DB db, ResultSet rs) throws SQLException{
		this.nome = rs.getString("nome");
		this.genero = new Genero(rs.getByte("genero"));
		this.dataNascimento = DB.unixToDate(rs.getLong("dataNascimento"));
		this.cpf = rs.getString("cpf");
		this.rg = rs.getString("rg");
		this.endereco = rs.getString("endereco");
		this.telefone = rs.getString("telefone");
		this.email = rs.getString("email");
		this.estado = new Estado(rs.getByte("estado"));
		this.cidade = rs.getString("cidade");
		this.observacao = rs.getString("observacao");
		this.bairro = rs.getString("bairro");
	}
	
	public static ArrayList<Paciente> listar(DB db) throws SQLException{
		PreparedStatement stm = db.geraSelectStatement(Paciente.TABELA);
		ResultSet rs = stm.executeQuery();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		while(rs.next()){
			Paciente p = new Paciente(rs.getInt("id"));
			p.preencheEntrada(db, rs);
			pacientes.add(p);
		}
		
		return pacientes;
	}
}
