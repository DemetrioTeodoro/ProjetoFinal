package model.entity;


public class Peca {
	
	private String nomePeca;
	private String codigo;
	private double valCompra;
	private double valVenda;
	private String dataEntrada;
	private String dataSaida;
	private int quantida;
	private int idPeca;
	private int idItempeca;
	
	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Peca(String nomePeca, String codigo, double valCompra, double valVenda, String dataEntrada, int quantida) {
		super();
		this.nomePeca = nomePeca;
		this.codigo = codigo;
		this.valCompra = valCompra;
		this.valVenda = valVenda;
		this.dataEntrada = dataEntrada;
		this.quantida = quantida;
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

	public double getValCompra() {
		return valCompra;
	}

	public void setValCompra(double valCompra) {
		this.valCompra = valCompra;
	}

	public double getValVenda() {
		return valVenda;
	}

	public void setValVenda(double valVenda) {
		this.valVenda = valVenda;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getQuantida() {
		return quantida;
	}

	public void setQuantida(int quantida) {
		this.quantida = quantida;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public int getIdItempeca() {
		return idItempeca;
	}

	public void setIdItempeca(int idItempeca) {
		this.idItempeca = idItempeca;
	}
	
	
	
	
	
	

}
