package model.bo;

import model.dao.LoginDAO;
import model.entity.Login;

public class LoginBO {
	
	public boolean consultarNomeLogin(String nomeLogin, String senha) {
		boolean logar = false;
		Login login = new Login();
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.consultarNomeLogin(nomeLogin);
		if (login.getLogin() != nomeLogin) {
			logar = true;
		}
		if (login.getSenha() != senha) {
			
		}
		
		return false;
	}

}
