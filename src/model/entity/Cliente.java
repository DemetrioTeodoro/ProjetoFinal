package model.entity;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private Carro carro;
	private int idCliente;
	private int idCarro;
	
	public Cliente(String nome, String cpf, String telefone, Carro carro) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.carro = carro;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	
	
	
}
