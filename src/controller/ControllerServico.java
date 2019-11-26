package controller;

import java.util.ArrayList;

import model.bo.ServicoBO;

public class ControllerServico {
	
	public ArrayList<String> consultarServico() {
		ServicoBO servicoBO = new ServicoBO();
		return servicoBO.consultarServico();
	}

}
