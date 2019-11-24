package model.bo;

import model.dao.SituacaoDAO;
import model.entity.Situacao;

public class SituacaoBO {
	
	SituacaoDAO situacaoDAO = new SituacaoDAO();

	public Situacao consultarSituacao(Situacao situacao) {
		return situacaoDAO.consultar(situacao);
		
	}

}
