package controller;

import model.bo.CarroBO;
import model.entity.Carro;

public class ControllerCarro {

	
CarroBO carroBO = new CarroBO();

	
	public Carro cadastrarCarro(Carro carro) {			
		carroBO.cadastrarCarro(carro);
		return carro;
	}
	
	
	public Carro consultarCarro(Carro carro) {
		carroBO.consultarCarro(carro);
		return carro;
	}
	
	public Carro alterarCarro(Carro carro) {
		carroBO.alterarCliente(carro);
		return carro;
	}
	
	public String deletarCarrro(int id) {
		String msg = null;
		carroBO.deletarCliente(id);
		return msg;
	}
	
}
