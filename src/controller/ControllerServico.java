package controller;

import model.bo.ServicoBO;
import model.entity.Servico;

public class ControllerServico {
	
ServicoBO servicoBO = new ServicoBO();
	
	public String consultarServico(Servico servico) {
		String msg = null;		
		servicoBO.consultarServico(servico);
		return msg;
	}

}
