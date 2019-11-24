package model.bo;

import model.dao.ServicoDAO;
import model.entity.Servico;

public class ServicoBO {
	
	ServicoDAO servicoDAO = new ServicoDAO();

	public Servico consultarServico(Servico servico) {
		return servicoDAO.consultar(servico);
		// TODO Auto-generated method stub
		
	}

}
