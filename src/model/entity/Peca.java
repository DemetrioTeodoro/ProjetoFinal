package model.entity;

public class Peca {
	
	private String nomePeca;
	private String codigo;
	
	public Peca(String nomePeca, String codigo) {
		super();
		this.nomePeca = nomePeca;
		this.codigo = codigo;
	}

	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
