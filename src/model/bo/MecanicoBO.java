package model.bo;

import model.dao.MecanicoDAO;
import model.entity.Mecanico;

public class MecanicoBO {
	
	MecanicoDAO mecanicoDAO = new MecanicoDAO();

	public Mecanico consultarMecanico(Mecanico mecanico) {
		return mecanicoDAO.consultar(mecanico);
		
	}

}
