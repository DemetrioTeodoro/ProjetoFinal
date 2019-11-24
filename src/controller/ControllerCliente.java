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
	

}
