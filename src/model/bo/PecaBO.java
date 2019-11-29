package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.PecaDAO;
import model.entity.Peca;


public class PecaBO {
	
	Peca peca = new Peca();	
	PecaDAO pecaDAO = new PecaDAO();

	public Peca cadastrarPecaBO(Peca peca) {
		 pecaDAO.cadastrar(peca);
		 if (peca.getIdPeca() != 0) {
			 pecaDAO.cadastrarItemPeca(peca);
			
		}
		 return peca;
	}

	public Peca consultarPecaBO(Peca peca) {
		return pecaDAO.consultar(peca);
	}

	public boolean alterarPecaBO(Peca peca) {
		return pecaDAO.alterar(peca);
	}

	public boolean excluirPeca(int id) {
		return pecaDAO.deletar(id);
	}

	public ArrayList<Peca> listarPecas() {
		ArrayList<Peca> pecas = pecaDAO.listarTodos();
		return pecas;
	}

	public ArrayList<Peca> consultarPecaNome(String nomePeca) {
		ArrayList<Peca> pecas = pecaDAO.consultarPecaNome(nomePeca);
		return pecas;
	}

	public Peca consultarPecaCodigo(String codigo) {
		 peca = pecaDAO.consultarPecaCodigo(codigo);
		 if (peca.getIdPeca() != 0) {
			excluirPeca(peca.getIdPeca());
		}
		 return peca;
	}

}
