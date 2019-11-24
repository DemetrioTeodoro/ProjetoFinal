package model.entity;

public class Servico {
	
	private int idServico;
	private String deServico;
	
	public Servico(int idServico, String deServico) {
		super();
		this.idServico = idServico;
		this.deServico = deServico;
	}

	public Servico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getDeServico() {
		return deServico;
	}

	public void setDeServico(String deServico) {
		this.deServico = deServico;
	}
	
	

}
