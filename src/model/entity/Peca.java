package model.entity;

import java.time.LocalDate;
import java.util.Date;

public class Peca {
	
	private String nomePeca;
	private String codigo;
	private double valorCompra;
	private double valorVenda;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private int quantidade;
	private int idPeca;
	private int idItempeca;  

	
	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

//Construtor para a Tabela de Peca - Consulta
	public Peca(String codigo2, String nome, double valorCompra2, double valorVenda2, LocalDate dataEntrada2,
			LocalDate dataSaida2, int quantidade2) {
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

	public double getValCompra() {
		return valorCompra;
	}

	public void setValCompra(double valCompra) {
		this.valorCompra = valCompra;
	}

	public double getValVenda() {
		return valorVenda;
	}

	public void setValVenda(double valVenda) {
		this.valorVenda = valVenda;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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

	@Override
	public String toString() {
		return  nomePeca;
	}
	
	

}
