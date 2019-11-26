package model.bo;

import java.util.ArrayList;

import model.dao.SituacaoDAO;

public class SituacaoBO {
	
	public ArrayList<String> consultarSituacao() {
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		return situacaoDAO.consultar();
	}

}
