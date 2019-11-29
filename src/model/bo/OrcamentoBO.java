package model.bo;

import java.util.ArrayList;

import model.dao.OrcamentoDAO;
import model.entity.Orcamento;
import model.entity.Peca;

public class OrcamentoBO {

	OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
	
	public Orcamento cadastrarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		orcamentoDAO.cadastrarCliente(orcamento);
		if (orcamento.getCliente().getIdCliente() != 0) {
			orcamentoDAO.cadastrarCarro(orcamento);
			if (orcamento.getCliente().getCarro().getIdCarro() !=0) {
				orcamentoDAO.cadastrar(orcamento);
			}
			
		}
		return orcamento;
	}
	
	public Orcamento consultarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.consultar(orcamento);
	}
	
	public boolean alterarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.alterar(orcamento);
	}
	
	public boolean deletarOrcamentoBO(int id) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		return orcamentoDAO.deletar(id);
	}

	public ArrayList<Orcamento> listarOrcamentos() {
		ArrayList<Orcamento> orcamentos = orcamentoDAO.listarTodos();
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		ArrayList<Orcamento> orcamentos = orcamentoDAO.consultarOrcNome(filtroNome);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcCarro(String filtroCarro) {
		ArrayList<Orcamento> orcamentos = orcamentoDAO.consultarOrcCarro(filtroCarro);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcSituacao(int filtroSituacao) {
		ArrayList<Orcamento> orcamentos = orcamentoDAO.consultarOrcSituacao(filtroSituacao);
		return orcamentos;
	}

}
