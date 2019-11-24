package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.entity.Cliente;


public class ClienteBO {
	
	ClienteDAO clienteDAO = new ClienteDAO();

	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteDAO.cadastrar(cliente);
		
	}

	public Cliente consultarCliente(Cliente cliente) {
		return clienteDAO.consultar(cliente);
	}

	public boolean alterarCliente(Cliente cliente) {
		return clienteDAO.alterar(cliente);
	}

	public int deletarCliente(int id) {
		return clienteDAO.deletar(id);
	}

	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> clientes = clienteDAO.listarTodos();
		return clientes;
	}
	
}
