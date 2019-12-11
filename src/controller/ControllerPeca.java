package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.bo.PecaBO;
import model.entity.Peca;
import model.utils.GeradorPlanilhas;



public class ControllerPeca {
	
	
	Peca peca = new Peca();
	
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
		pecaBO.consultarPecaCodigo(codigo);
		return peca;
	}

	public String validarCamposPeca(String nomePeca, double valorCompra, double valorVenda,
			int quantidade, LocalDate dataEntrada) {
		String msg = "";
		
		if (nomePeca.isEmpty() || nomePeca.trim().length() < 3) {
			msg += " Nome da peça deve possuir mais de 3 letras! ";
		}
		
		if (valorCompra == 0.00 || valorCompra == 0 || valorCompra == 00|| valorCompra == 00.00) {
			msg += " Valor da compra da peça incorreto! ";
		}
		if (valorVenda == 0.00 || valorVenda == 0 || valorVenda == 00 || valorVenda == 00.00) {
			msg += " Valor da venda da peça incorreto! ";
		}
		if (quantidade == 0 || quantidade == 00 || quantidade == 000 || quantidade == 0000) {
			msg += " Quantidade deve ser maior que zero! ";
		}
		return msg;
	}


}
