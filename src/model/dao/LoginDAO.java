package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Login;

public class LoginDAO {
	
	public Login consultarNomeLogin(String nomeLogin) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM LOGIN"
				+ " WHERE LOGIN = '" + nomeLogin + "'";
		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		Login login = new Login();
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				login = construirLoginDoResultSet(resultadoDaConsulta);
				
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar carro por Placa cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return login;
	}
	
	
	private Login construirLoginDoResultSet(ResultSet rs) {
		Login login = null;
		
		  
		try {
			int id = rs.getInt("IDUSUARIO");
			String nomelogin = rs.getString("LOGIN");
			String senha = rs.getString("SENHA");
			String tipo = rs.getString("TIPO");
				
			
			login = new Login();
			login.setIdUsuario(id);
			login.setLogin(nomelogin);
			login.setSenha(senha);
			login.setTipo(tipo);
			
	
		} catch (SQLException e) {
			System.out.println("Erro ao construir orcamento do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return login;
	}

}
