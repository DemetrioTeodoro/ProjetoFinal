package controller;

import java.util.List;

import model.bo.CarroBO;
import model.bo.PecaBO;
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
	
	public List<Carro> listarTodos() {
		String msg = null;
		CarroBO carroBO = new CarroBO();
		return carroBO.listarTodos();
	}

	public String validarCamposCarro(String marca, int ano, String cor, String modelo, String placa) {
		String mensagem = "";

		if (marca.isEmpty() || marca.trim().length() < 3) {
			mensagem += " A marca deve possuir pelo menos 3 letras! \n";
		}

		if (ano == 0000 || (ano > 2021 || ano < 1884)) {
			mensagem += " O ano do carro não está correto! \n";
		}

		if (cor.isEmpty()) {
			mensagem += " Por favor, informe a cor! \n";
		}
		
		if (modelo.isEmpty()) {
			mensagem += " Por favor, informe o modelo do carro! \n";
		}
		
		if (placa.isEmpty()) {
			mensagem += " Por favor, informe a placa corretamente! \n";
		}
		
		return mensagem;
	}


	

	
}
