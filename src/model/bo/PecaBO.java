package model.bo;

import model.dao.PecaDAO;

public class PecaBO {

	public String cadastrarPecaBO() {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.cadastrarPeca();
	}

	public String consultarPecaBO() {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.consultarPeca();
	}

	public String alterarPecaBO() {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.alterarPeca();
	}

	public String deletarPecaBO() {
		PecaDAO pecaDAO = new PecaDAO();
		return pecaDAO.deletarPeca();
	}

}
