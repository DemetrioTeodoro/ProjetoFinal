package controller;

import model.bo.PecaBO;
import model.entity.Peca;

public class ControllerPeca {
	
	public String cadastrarPeca(Peca peca) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		pecaBO.cadastrarPecaBO(peca);
		return msg;
	}
	
	public String consultarPeca(Peca peca) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		pecaBO.consultarPecaBO(peca);
		return msg;
	}
	
	public String alterarPeca(Peca peca) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		pecaBO.alterarPecaBO(peca);
		return msg;
	}
	
	public String deletarPeca(int id) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		pecaBO.deletarPecaBO(id);
		return msg;
	}
}
