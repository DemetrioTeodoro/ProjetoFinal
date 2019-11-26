package controller;

import java.util.ArrayList;

import model.bo.SituacaoBO;

public class ControllerSituacao {
	
	public ArrayList<String> consultarSituacao() {
		SituacaoBO situacaoBO = new SituacaoBO();
		return situacaoBO.consultarSituacao();
	}

}
