package model.bo;

import java.util.ArrayList;

import model.dao.ServicoDAO;

public class ServicoBO {
	
	public ArrayList<String> consultarServico() {
		ServicoDAO servicoDAO = new ServicoDAO();
		return servicoDAO.consultar();
	}

}
