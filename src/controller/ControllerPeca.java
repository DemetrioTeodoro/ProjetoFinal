package controller;

import java.util.ArrayList;

import model.bo.PecaBO;
import model.entity.Peca;
import model.utils.GeradorPlanilhas;

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
	
	public String excluirPeca(int id) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		pecaBO.excluirPeca(id);
		return msg;
	}

	public ArrayList<Peca> listarPecas() {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		return pecaBO.listarPecas();
		
	}

	public void gerarRelatorio(ArrayList<Peca> pecas, String caminhoEscolhido) {
		GeradorPlanilhas gerador = new GeradorPlanilhas();
		gerador.gerarPlanilhasPeca(pecas, caminhoEscolhido);
	}

	public ArrayList<Peca> consultarPecaNome(String nomePeca) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		return pecaBO.consultarPecaNome(nomePeca);
	}

	public Peca consultarPecaCodigo(String codigo) {
		String msg = null;
		PecaBO pecaBO = new PecaBO();
		return pecaBO.consultarPecaCodigo(codigo);
	}


}
