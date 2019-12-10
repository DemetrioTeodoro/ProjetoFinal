package model.bo;

import java.util.ArrayList;
import java.util.Random;

import model.dao.OrcamentoDAO;
import model.entity.Orcamento;
import model.entity.Peca;

public class OrcamentoBO {

	OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
	
	public Orcamento cadastrarOrcamentoBO(Orcamento orcamento) {
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();		
		orcamentoDAO.cadastrar(orcamento);
			
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
	
	public int codigosAleatorios() {
		Random random = new Random();
		int codigosRandom = random.nextInt(100);
		return codigosRandom;
	}

}
