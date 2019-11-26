package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Servico;

public class ServicoDAO implements BaseDAOCombos<Servico> {

	@Override
	public ArrayList<String> consultar() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		ArrayList<String> servicos = new ArrayList<String>();
		
		String sql = " SELECT DISTINCT(DESERVICO) FROM SERVICO ";
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				servicos.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Serviços.");
			System.out.println("Erro: " + e.getMessage());
		}
		return servicos;
	}

}
