package model.entity;

import java.time.LocalDate;

public class Orcamento {
	
	private int numeroOrcamento;
	private String descricao;
	private double valorPeca;
	private double valorMaoObra;
	private double valorTotal;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private Mecanico mecanico;
	private Situacao situacao;
	private Servico servico;
	private int idOrcamento;
	private Carro carro;
	private Cliente cliente;


	public Orcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroOrcamento() {
		return numeroOrcamento;
	}


	public void setNumeroOrcamento(int numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValorPeca() {
		return valorPeca;
	}


	public void setValorPeca(double valorPeca) {
		this.valorPeca = valorPeca;
	}


	public double getValorMaoObra() {
		return valorMaoObra;
	}


	public void setValorMaoObra(double valorMaoObra) {
		this.valorMaoObra = valorMaoObra;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}


	public Mecanico getMecanico() {
		return mecanico;
	}


	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public int getIdOrcamento() {
		return idOrcamento;
	}


	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}


	public Carro getCarro() {
		return carro;
	}


	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
}
