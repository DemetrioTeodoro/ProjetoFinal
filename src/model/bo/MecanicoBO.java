package model.bo;

import java.util.ArrayList;

import model.dao.MecanicoDAO;

public class MecanicoBO {
	
	MecanicoDAO mecanicoDAO = new MecanicoDAO();

	public ArrayList<String> consultarMecanico() {
		return mecanicoDAO.consultar();
		
	}

}
