package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Mecanico;

public class MecanicoDAO implements BaseDAOCombos<Mecanico>{

	@Override
	public ArrayList<String> consultar() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		ArrayList<String> mecanicos = new ArrayList<String>();
		
		String sql = " SELECT DISTINCT(NOME) FROM MECANICO ";
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mecanicos.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Mecânicos.");
			System.out.println("Erro: " + e.getMessage());
		}
		return mecanicos;
	}

}
