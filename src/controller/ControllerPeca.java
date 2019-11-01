package controller;

import model.bo.PecaBO;

public class ControllerPeca {
	
	public String cadastrarPeca() {
		PecaBO pecaBO = new PecaBO();
		return pecaBO.cadastrarPecaBO();
	}
	
	public String consultarPeca() {
		PecaBO pecaBO = new PecaBO();
		return pecaBO.consultarPecaBO();
	}
	
	public String alterarPeca() {
		PecaBO pecaBO = new PecaBO();
		return pecaBO.alterarPecaBO();
	}
	
	public String deletarPeca() {
		PecaBO pecaBO = new PecaBO();
		return pecaBO.deletarPecaBO();
	}
}
