package model.bo;

import model.dao.OrcamentoDAO;

public class OrcamentoBO {

	public String cadastrarOrcamentoBO() {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.cadastrarOrcamento();
	}
	
	public String consultarOrcamentoBO() {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.consultarOrcamento();
	}
	
	public String alterarOrcamentoBO() {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.alterarOrcamento();
	}
	
	public String deletarOrcamentoBO() {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.deletarOrcamento();
	}

}
