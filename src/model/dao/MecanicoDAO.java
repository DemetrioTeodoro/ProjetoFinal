package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public Mecanico consultarPorId(int idMecanico) {
		Mecanico m = null;

		String sql = " SELECT * FROM MECANICO WHERE IDMECANICO=? ";

		PreparedStatement stmt;
		try {
			stmt = Banco.getConnection().prepareStatement(sql);
			stmt.setInt(1, idMecanico);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m = this.construirMecanicoDoResultSet(rs);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar mecanico por id. Erro: " + e.getMessage());
		}

		return m;
	}

	private Mecanico construirMecanicoDoResultSet(ResultSet resultadoConsulta) {
		Mecanico m = null;

		try {
			m = new Mecanico();
			m.setIdMecanico(resultadoConsulta.getInt("idMecanico"));
			m.setNome(resultadoConsulta.getString("nome"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}
}
