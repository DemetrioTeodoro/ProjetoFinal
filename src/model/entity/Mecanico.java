package model.entity;

public class Mecanico {
	
	private String nome;
	private int idMecanico;

	public Mecanico(String nome, int id) {
		super();
		this.nome = nome;
		this.idMecanico = id;
	}

	public Mecanico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdMecanico() {
		return idMecanico;
	}

	public void setIdMecanico(int idMecanico) {
		this.idMecanico = idMecanico;
	}
	
	

}
