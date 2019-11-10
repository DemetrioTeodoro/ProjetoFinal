package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.PecaDAO;
import model.entity.Peca;


public class PecaBO {
	
	PecaDAO pecaDAO = new PecaDAO();

	public Peca cadastrarPecaBO(Peca peca) {
		return pecaDAO.cadastrar(peca);
	}

	public Peca consultarPecaBO(Peca peca) {
		return pecaDAO.consultar(peca);
	}

	public boolean alterarPecaBO(Peca peca) {
		return pecaDAO.alterar(peca);
	}

	public int deletarPecaBO(int id) {
		return pecaDAO.deletar(id);
	}

	public List<Peca> listarPecas() {
		ArrayList<Peca> pecas = pecaDAO.listarTodos();
		return pecas;
	}

}
