package controller;

import model.bo.SituacaoBO;
import model.entity.Situacao;

public class ControllerSituacao {
	
SituacaoBO situacaoBO = new SituacaoBO();
	
	public String consultarSituacao(Situacao situacao) {
		String msg = null;		
		situacaoBO.consultarSituacao(situacao);
		return msg;
	}

}
