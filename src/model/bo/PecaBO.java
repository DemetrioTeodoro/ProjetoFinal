package model.bo;

import model.dao.PecaDAO;
import model.entity.Peca;

public class PecaBO {

	public Peca cadastrarPecaBO(Peca peca) {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.cadastrar(peca);
	}

	public Peca consultarPecaBO(Peca peca) {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.consultar(peca);
	}

	public boolean alterarPecaBO(Peca peca) {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.alterar(peca);
	}

	public int deletarPecaBO(int id) {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.deletar(id);
	}

}
