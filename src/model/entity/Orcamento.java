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
	private int idMecanico;
	private int idSituacao;
	private int idServico;
	private int idOrcamento;
	private int idCarro;


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


	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}


	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getIdMecanico() {
		return idMecanico;
	}

	public void setIdMecanico(int idMecanico) {
		this.idMecanico = idMecanico;
	}

	public int getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(int idSituacao) {
		this.idSituacao = idSituacao;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	
	
	
}
