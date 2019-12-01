package controller;

import java.util.ArrayList;

import model.bo.CarroBO;
import model.bo.ClienteBO;
import model.bo.OrcamentoBO;
import model.entity.Orcamento;

public class ControllerOrcamento {
	
	ArrayList<Orcamento> orcamentos;
	ControllerCliente controllerCliente = new ControllerCliente();
	
	
	public String cadastrarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.cadastrarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String consultarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.consultarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String alterarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.alterarOrcamentoBO(orcamento);
		return msg; 
	}
	
	public String deletarOrcamento(int id) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();  
		orcamentoBO.deletarOrcamentoBO(id);
		return msg;
	}

	public ArrayList<Orcamento> listarOrcamentos() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.listarOrcamentos();
		
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcNome(filtroNome);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcCarro(String filtroCarro) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcCarro(filtroCarro);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcSituacao(int filtroSituacao) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcSituacao(filtroSituacao);
		return orcamentos;
	}

}
