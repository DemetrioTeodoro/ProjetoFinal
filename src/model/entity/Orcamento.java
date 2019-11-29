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
	private Cliente cliente;
	private int situacao;
	private Servico servico;
	private int idOrcamento;
	private int idCliente;
	private String deSituacao;
	private String NmCliente;
	private String ModeloCarro;
	

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int i) {
		this.situacao = i;
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDeSituacao() {
		return deSituacao;
	}

	public void setDeSituacao(String deSituacao) {
		this.deSituacao = deSituacao;
	}

	public String getNmCliente() {
		return NmCliente;
	}

	public void setNmCliente(String nmCliente) {
		NmCliente = nmCliente;
	}

	public String getModeloCarro() {
		return ModeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		ModeloCarro = modeloCarro;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
