package controller;

import java.util.ArrayList;

import model.bo.CarroBO;
import model.bo.ClienteBO;
import model.bo.OrcamentoBO;
import model.entity.Orcamento;

public class ControllerOrcamento {
	
	ArrayList<Orcamento> orcamentos;
	ControllerCliente controllerCliente = new ControllerCliente();
	
	
	public String cadastrarOrcamento(Orcamento orcamento) {
		String msg = null;
		
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.cadastrarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String consultarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.consultarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String alterarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.alterarOrcamentoBO(orcamento);
		return msg; 
	}
	
	public String deletarOrcamento(int id) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();  
		orcamentoBO.deletarOrcamentoBO(id);
		return msg;
	}

	public ArrayList<Orcamento> listarOrcamentos() {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.listarOrcamentos();
		
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcNome(filtroNome);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcCarro(String filtroCarro) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcCarro(filtroCarro);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcSituacao(int filtroSituacao) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcSituacao(filtroSituacao);
		return orcamentos;
	}
	
	public String validarCamposCarro(String marca, int ano, String cor, String modelo, String placa) {
		String mensagem = "";

		if (marca.isEmpty() || marca.trim().length() < 3) {
			mensagem += " A marca deve possuir pelo menos 3 letras! \n";
		}

		if (ano > 2021 || ano < 1884) {
			mensagem += " O ano do carro não está correto! \n";
		}

		if (cor.isEmpty()) {
			mensagem += " Por favor, informe a cor! \n";
		}
		
		if (modelo.isEmpty()) {
			mensagem += " Por favor, informe o modelo do carro! \n";
		}
		
		if (placa.isEmpty() || placa.trim().length() != 7) {
			mensagem += " Por favor, informe a placa corretamente! \n";
		}
		
		return mensagem;
	}
	
	public String validarCamposCliente(String nome, String cpf, String telefone) {
		String mensagem = "";

		if (nome.isEmpty() || nome.trim().length() < 3) {
			mensagem += " O nome deve possuir pelo menos 3 letras! \n";
		}

		if (cpf.isEmpty() || cpf.trim().length() != 11) {
			mensagem += " O CPF deve possuir 11 exatamente digitos! \n";
		}

		if (telefone.isEmpty() || telefone.trim().length() < 11) {
			mensagem += "O telefone deve possuir pelo menos 11 numeros! \n";
		}
		
		return mensagem;
	}

}
