package model.bo;

import java.util.ArrayList;
import java.util.Random;


import model.dao.OrcamentoDAO;
import model.entity.Carro;
import model.entity.Orcamento;



public class OrcamentoBO {

	OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
	ArrayList<Orcamento> objOrcamento;
	
	public Orcamento cadastrarOrcamentoBO(Orcamento orcamento) {
		orcamento.setNumeroOrcamento(codigosAleatorios());
		orcamentoDAO.cadastrar(orcamento);
			
		return orcamento;
	}
	
	public Orcamento consultarOrcamentoBO(Orcamento orcamento) {
		return orcamentoDAO.consultar(orcamento);
	}
	
	public boolean alterarOrcamentoBO(Orcamento orcamento) {
		return orcamentoDAO.alterar(orcamento);
	}
	
	public boolean deletarOrcamentoBO(String nuExclusao) {
		int numero = Integer.parseInt(nuExclusao);
		return orcamentoDAO.deletar(numero);
	}

	public ArrayList<Orcamento> listarOrcamentos(String filtroNome, Carro filtroCarro, int filtroSituacao) {
		if (filtroNome.equals("") && filtroCarro == null && filtroSituacao == -1) {
			objOrcamento = orcamentoDAO.listarTodos();
		}
		if (!filtroNome.equals("") && filtroCarro == null && filtroSituacao == -1) {
			objOrcamento = orcamentoDAO.consultarOrcNome(filtroNome);
		}
		if (filtroNome.equals("") && filtroCarro != null && filtroSituacao == -1) {
			objOrcamento = orcamentoDAO.consultarOrcCarro(filtroCarro.getMarca());
		}
		if (filtroNome.equals("") && filtroCarro == null && filtroSituacao != -1) {
			objOrcamento = orcamentoDAO.consultarOrcSituacao(filtroSituacao);
		}
		if (!filtroNome.equals("") && filtroCarro != null && filtroSituacao == -1) {
			objOrcamento = orcamentoDAO.consultarPorNomeMarca(filtroNome, filtroCarro.getMarca());
		}
		if (!filtroNome.equals("") && filtroCarro == null && filtroSituacao != -1) {
			objOrcamento = orcamentoDAO.consultarPorNomeSituacao(filtroNome, filtroSituacao);
		}
		if (filtroNome.equals("") && filtroCarro != null && filtroSituacao != -1) {
			objOrcamento = orcamentoDAO.consultarPorMarcaSituacao(filtroCarro.getMarca(), filtroSituacao);
		}
		if (!filtroNome.equals("") && filtroCarro != null && filtroSituacao != -1) {
			objOrcamento = orcamentoDAO.consultarPorTodosFiltros(filtroNome, filtroCarro.getMarca(), filtroSituacao);
		}
		
		return objOrcamento;
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
