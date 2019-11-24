package model.entity;

public class Situacao {
	
	private int idSituacao;
	private String deSituacao;
	
	public Situacao(int idSituacao, String deSituacao) {
		super();
		this.idSituacao = idSituacao;
		this.deSituacao = deSituacao;
	}

	public Situacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(int idSituacao) {
		this.idSituacao = idSituacao;
	}

	public String getDeSituacao() {
		return deSituacao;
	}

	public void setDeSituacao(String deSituacao) {
		this.deSituacao = deSituacao;
	}
	
	

}
