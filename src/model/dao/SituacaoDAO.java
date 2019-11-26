package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Situacao;

public class SituacaoDAO implements BaseDAOCombos<Situacao>{

	@Override
	public ArrayList<String> consultar() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		ArrayList<String> situacoes = new ArrayList<String>();
		
		String sql = " SELECT DISTINCT(DESITUACAO) FROM SITUACAO ";
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				situacoes.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Situação.");
			System.out.println("Erro: " + e.getMessage());
		}
		return situacoes;
	}
	
	
	
}
