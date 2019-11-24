package controller;

import model.bo.MecanicoBO;
import model.entity.Mecanico;

public class ControllerMecanico {
	
MecanicoBO mecanicoBO = new MecanicoBO();
	
	public String consultarMecanico(Mecanico mecanico) {
		String msg = null;		
		mecanicoBO.consultarMecanico(mecanico);
		return msg;
	}
	

}
