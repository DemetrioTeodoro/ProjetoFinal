package model.entity;

import java.util.Date;

public class Orcamento {
	
	private int numeroOrcamento;
	private String descricao;
	private double valorPeca;
	private double valorMaoObra;
	private Date dataInicio;
	private Date dataFinal;
	private Mecanico[] mecanicos;
	private Carro[] carros;
	private Situacao[] situacoes;
	private Servico[] servicos;
	
	public Orcamento(int numeroOrcamento, String descricao, double valorPeca, double valorMaoObra, Date dataInicio,
			Date dataFinal, Mecanico[] mecanicos, Carro[] carros, Situacao[] situacoes, Servico[] servicos) {
		super();
		this.numeroOrcamento = numeroOrcamento;
		this.descricao = descricao;
		this.valorPeca = valorPeca;
		this.valorMaoObra = valorMaoObra;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.mecanicos = mecanicos;
		this.carros = carros;
		this.situacoes = situacoes;
		this.servicos = servicos;
	}

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Mecanico[] getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(Mecanico[] mecanicos) {
		this.mecanicos = mecanicos;
	}

	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}

	public Situacao[] getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(Situacao[] situacoes) {
		this.situacoes = situacoes;
	}

	public Servico[] getServicos() {
		return servicos;
	}

	public void setServicos(Servico[] servicos) {
		this.servicos = servicos;
	}
	
}
