package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Mecanico;
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

	public Situacao consultarPorId(int idSituacao) {
		Situacao s = null;

		String sql = " SELECT * FROM SITUACAO WHERE IDSITUACAO=? ";

		PreparedStatement stmt;
		try {
			stmt = Banco.getConnection().prepareStatement(sql);
			stmt.setInt(1, idSituacao);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = this.construirSituacaoDoResultSet(rs);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar situacao por id. Erro: " + e.getMessage());
		}

		return s;
	}

	private Situacao construirSituacaoDoResultSet(ResultSet resultadoConsulta) {
		Situacao s = null;

		try {
			s = new Situacao();
			s.setIdSituacao(resultadoConsulta.getInt("idSituacao"));
			s.setDeSituacao(resultadoConsulta.getString("DeSituacao"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}
	
}
