package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Servico;
import model.entity.Situacao;

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

	public Servico consultarPorId(int idServico) {
		Servico s = null;

		String sql = " SELECT * FROM SERVICO WHERE IDSERVICO=? ";

		PreparedStatement stmt;
		try {
			stmt = Banco.getConnection().prepareStatement(sql);
			stmt.setInt(1, idServico);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = this.construirServicoDoResultSet(rs);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar servico por id. Erro: " + e.getMessage());
		}

		return s;
	}

	private Servico construirServicoDoResultSet(ResultSet resultadoConsulta) {
		Servico s = null;

		try {
			s = new Servico();
			s.setIdServico(resultadoConsulta.getInt("idServico"));
			s.setDeServico(resultadoConsulta.getString("DeServico"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}

}
