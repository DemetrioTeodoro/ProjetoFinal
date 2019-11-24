package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ControllerCliente {
	
	public String cadastrarCliente(Cliente cliente) {
		String msg = null;
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarCliente(cliente);
		return msg;
	}
	

}
