package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;


public class ControllerCliente {
	
	ClienteBO clienteBO = new ClienteBO();
	
	public Cliente cadastrarCliente(Cliente cliente) {	
		clienteBO.cadastrarCliente(cliente);
		return cliente;
	}
	
	
	public Cliente consultarCliente(Cliente cliente) {
		clienteBO.consultarCliente(cliente);
		return cliente;
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		clienteBO.alterarCliente(cliente);
		return cliente;
	}
	
	public String deletarCliente(int id) {
		String msg = null;
		clienteBO.deletarCliente(id);
		return msg;
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
