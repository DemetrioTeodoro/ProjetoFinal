package model.entity;

public class Carro {
	
	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private int ano;
	private int idCarro;
	private int idCliente;

	

	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMarca() {
		return marca;
	}

	public String setMarca(String marca) {
		return this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String setModelo(String modelo) {
		return this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public String setPlaca(String placa) {
		return this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public String setCor(String cor) {
		return this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public int setAno(int ano) {
		return this.ano = ano;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return  marca;
	}

	


	

	
	
}
