package controller;

import model.bo.OrcamentoBO;

public class ControllerOrcamento {
	
	public String cadastrarOrcamento() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.cadastrarOrcamentoBO();
	}
	
	public String consultarOrcamento() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.consultarOrcamentoBO();
	}
	
	public String alterarOrcamento() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.alterarOrcamentoBO();
	}
	
	public String deletarOrcamento() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.deletarOrcamentoBO();
	}

}
