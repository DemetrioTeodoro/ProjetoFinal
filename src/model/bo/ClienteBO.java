package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.entity.Cliente;


public class ClienteBO {
	
	ClienteDAO clienteDAO = new ClienteDAO();
	Cliente objCliente = null;

	public Cliente cadastrarCliente(Cliente cliente) {
		consultarClientePorCpf(cliente.getCpf());
		if (objCliente.getIdCliente() == 0) {
			objCliente =  clienteDAO.cadastrar(cliente);
		}
		
		return objCliente;	
	}

	public Cliente consultarCliente(Cliente cliente) {
		return clienteDAO.consultar(cliente);
	}

	public boolean alterarCliente(Cliente cliente) {
		return clienteDAO.alterar(cliente);
	}

	public boolean deletarCliente(int id) {
		return clienteDAO.deletar(id);
	}

	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> clientes = clienteDAO.listarTodos();
		return clientes;
	}
	
	public Cliente consultarClientePorCpf(String cpf) {
		objCliente = clienteDAO.consultarPorCpf(cpf);
		return objCliente;
	}
}
