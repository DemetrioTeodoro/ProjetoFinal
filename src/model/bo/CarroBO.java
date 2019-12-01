package model.bo;

import model.dao.CarroDAO;
import model.entity.Carro;

public class CarroBO {
	
	CarroDAO carroDAO = new CarroDAO();
	Carro objCarro = null;

	public Carro cadastrarCarro(Carro carro) {
		consultarPorPlaca(carro.getPlaca());
		if (objCarro == null) {
			objCarro = carroDAO.cadastrar(carro);
			
		}
		return objCarro;
		
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
	
	public Carro consultarPorPlaca(String placa) {	
		objCarro = carroDAO.consultarPorPlaca(placa);
	return objCarro;
	}
	
}
