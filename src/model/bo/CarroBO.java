package model.bo;

import model.dao.CarroDAO;
import model.entity.Carro;

public class CarroBO {
	
	CarroDAO carroDAO = new CarroDAO();

	public Carro cadastrarCarro(Carro carro) {
		return carroDAO.cadastrar(carro);
		
	}

	public Carro consultarCarro(Carro carro) {
		return carroDAO.consultar(carro);
		
	}

	public boolean alterarCliente(Carro carro) {
		return carroDAO.alterar(carro);
		
	}

	public boolean deletarCliente(int id) {
		return carroDAO.deletar(id);
		
	}

}
