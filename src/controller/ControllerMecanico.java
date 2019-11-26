package controller;

import java.util.ArrayList;

import model.bo.MecanicoBO;

public class ControllerMecanico {
	
	public ArrayList<String> consultarMecanico() {
		MecanicoBO mecanicoBO = new MecanicoBO();
		return mecanicoBO.consultarMecanico();
	}
	

}
