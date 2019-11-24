package controller;

import model.bo.CarroBO;
import model.bo.ClienteBO;
import model.bo.OrcamentoBO;
import model.entity.Orcamento;

public class ControllerOrcamento {
	
	
	
	
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

}
