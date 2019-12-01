package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;


public class ControllerCliente {
	
	ClienteBO clienteBO = new ClienteBO();
	
	public String cadastrarCliente(Cliente cliente) {
		String msg = null;		
		clienteBO.cadastrarCliente(cliente);
		return msg;
	}
	
	
	public String consultarCliente(Cliente cliente) {
		String msg = null;
		clienteBO.consultarCliente(cliente);
		return msg;
	}
	
	public String alterarPeca(Cliente cliente) {
		String msg = null;
		clienteBO.alterarCliente(cliente);
		return msg;
	}
	
	public String deletarPeca(int id) {
		String msg = null;
		clienteBO.deletarCliente(id);
		return msg;
	}


	public String validarCampos(String nome, String cpf, String telefone) {
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
