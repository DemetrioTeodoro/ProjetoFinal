package model.bo;

import model.dao.OrcamentoDAO;
import model.entity.Orcamento;

public class OrcamentoBO {

	public Orcamento cadastrarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.cadastrar(orcamento);
	}
	
	public Orcamento consultarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.consultar(orcamento);
	}
	
	public boolean alterarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.alterar(orcamento);
	}
	
	public int deletarOrcamentoBO(int id) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.deletar(id);
	}

}
