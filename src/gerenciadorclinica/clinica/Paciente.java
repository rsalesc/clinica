package gerenciadorclinica.clinica;
import gerenciadorclinica.Entrada;
import gerenciadorclinica.extras.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Paciente extends Entrada{

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
	
	public Paciente(String nome, Genero genero, Date dataNascimento, String cpf, String rg, String endereco, String cidade, Estado estado,
			String telefone, String email, int id, String bairro) {
			super(id);
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
			this.observacao = "";
			this.bairro = bairro;
		}

	public Paciente(String nome, Genero genero, Date dataNascimento, String rg, String endereco, String cidade, Estado estado,
				String telefone, String email, int ID, String bairro){
		this(nome, genero, dataNascimento, "",rg, endereco, cidade, estado, telefone, email, ID, bairro);
	}

	public Paciente(String nome, Genero genero, Date dataNascimento,String rg, String endereco, String cidade, Estado estado, 
					String telefone, int ID, String bairro){
		this(nome, genero, dataNascimento, "", rg, endereco, cidade, estado, telefone, "", ID, bairro);
	}
	
	public Paciente(String nome, Genero genero, Date dataNascimento, String cpf, String rg, String endereco, String cidade, Estado estado,
					String telefone, String email, String bairro) {
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
		this.observacao = "";
		this.bairro = bairro;
	}

	public Paciente(String nome, Genero genero, Date dataNascimento, String rg, String endereco, String cidade, Estado estado,
					String telefone, String email, String bairro){
		this(nome, genero, dataNascimento, "",rg, endereco, cidade, estado, telefone, email, bairro);
	}
	
	public Paciente(String nome, Genero genero, Date dataNascimento,String rg, String endereco, String cidade, Estado estado, 
					String telefone, String bairro){
		this(nome, genero, dataNascimento, "", rg, endereco, cidade, estado, telefone, "", bairro);
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

	public Date getDatanascimento() {
		return dataNascimento;
	}

	public void setDatanascimento(Date dataNascimento) {
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
}
