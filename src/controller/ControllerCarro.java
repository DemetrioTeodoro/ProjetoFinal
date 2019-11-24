package controller;

import model.bo.CarroBO;
import model.entity.Carro;

public class ControllerCarro {

	
CarroBO carroBO = new CarroBO();
	
	public String cadastrarCarro(Carro carro) {
		String msg = null;		
		carroBO.cadastrarCarro(carro);
		return msg;
	}
	
	
	public String consultarCarro(Carro carro) {
		String msg = null;
		carroBO.consultarCarro(carro);
		return msg;
	}
	
	public String alterarCarro(Carro carro) {
		String msg = null;
		carroBO.alterarCliente(carro);
		return msg;
	}
	
	public String deletarCarrro(int id) {
		String msg = null;
		carroBO.deletarCliente(id);
		return msg;
	}
	
}
