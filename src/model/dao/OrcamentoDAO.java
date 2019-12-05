package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.entity.Mecanico;
import model.entity.Orcamento;
import model.entity.Peca;

public class OrcamentoDAO implements BaseDAO<Orcamento> {

	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	
	@Override
	public Orcamento cadastrar(Orcamento orcamento) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ORCAMENTO (IDCARRO, DESCRICAO, DATAINICIO, IDSITUACAO ) "
				+ "VALUES (?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setInt(1, orcamento.getCarro().getIdCarro());
			stmt.setString(2, orcamento.getDescricao());
			stmt.setDate(3, Date.valueOf(orcamento.getDataInicio()));
			stmt.setInt(4, orcamento.getSituacao().getIdSituacao());
						
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				orcamento.setIdOrcamento(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir novo Orçamento.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return orcamento;	
		
		}

	@Override
	public Orcamento consultar(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		Connection conexao = Banco.getConnection();
		Statement statement = Banco.getStatement(conexao);
		String sql = " DELETE FROM ORCAMENTO WHERE IDORCAMENTO = " + id;

		int quantidadeRegistrosExcluidos = 0;
		try {
			quantidadeRegistrosExcluidos = statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir orcamento.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(statement);
			Banco.closeConnection(conexao);
		}

		return quantidadeRegistrosExcluidos > 0;
	}

	public ArrayList<Orcamento> listarTodos() {
		String sql = " SELECT O.IDORCAMENTO, CL.NOME, C.MODELO, O.DATAINICIO, (O.VALORPECAS + O.VALORMAOOBRA) AS VALTOTAL, S.DESITUACAO"
				+ " FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS C ON"
				+ " O.IDCARRO = C.IDCARRO"
				+ " INNER JOIN CLIENTE AS CL ON"
				+ " C.IDCLIENTE = CL.IDCLIENTE"
				+ " INNER JOIN SITUACAO AS S ON"
				+ " O.IDSITUACAO = S.IDSITUACAO";

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Orcamento orcamentoBuscado = construirDoResultSet(resultadoDaConsulta);
				orcamentos.add(orcamentoBuscado);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar pecas cadastradas ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return orcamentos;
	}
	
	private Orcamento construirDoResultSet(ResultSet rs) {
		Orcamento orc = null;
		

		try {
			int id = rs.getInt("IDORCAMENTO");
			int numeroOrcamento = rs.getInt("NUORCAMENTO");
			String descricao = rs.getString("DESCRICAO");
			double ValPecas = rs.getDouble("VALORPECAS");
			double ValMaoObra = rs.getDouble("VALORMAOOBRA");
			
			Date dataInicioBanco = rs.getDate("DATAINICIO");
			
			orc = new Orcamento();
			
			if(dataInicioBanco != null) {
				LocalDate dataInicio = (LocalDate.parse((CharSequence) dataInicioBanco.toString(), formatador));
				orc.setDataInicio(dataInicio);
			}
			
			LocalDate dataFinal = (LocalDate.parse((CharSequence) rs.getDate("DATAFINAL").toString(), formatador));
			
			int idMecanico = rs.getInt("IDMECANICO");
			Mecanico mecanico = new Mecanico();
			MecanicoDAO mecDAO = new MecanicoDAO();
			Mecanico mecanicoDoOrcamento = mecDAO.consultarPorId(mecanico.getIdMecanico());
			
			int idCarro = rs.getInt("IDCARRO");
			int idSituacao = rs.getInt("IDSITUACAO");
			int idServico = rs.getInt("IDSERVICO");
				
			orc.setIdOrcamento(id);
			orc.setNumeroOrcamento(numeroOrcamento);
			orc.setDescricao(descricao);
			orc.setValorPeca(ValPecas);
			orc.setValorMaoObra(ValMaoObra);
			orc.setDataFinal(dataFinal);
			orc.setIdMecanico(idMecanico);
			orc.setIdCarro(idCarro);
			orc.setIdSituacao(idSituacao);
			orc.setIdServico(idServico);
	
		} catch (SQLException e) {
			System.out.println("Erro ao construir orcamento do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return orc;
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		String sql = " SELECT O.IDORCAMENTO, CL.NOME, C.MODELO, O.DATAINICIO, (O.VALORPECAS + O.VALORMAOOBRA) AS VALTOTAL, S.DESITUACAO"
				+ " FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS C ON"
				+ " O.IDCARRO = C.IDCARRO"
				+ " INNER JOIN CLIENTE AS CL ON"
				+ " C.IDCLIENTE = CL.IDCLIENTE"
				+ " INNER JOIN SITUACAO AS S ON"
				+ " O.IDSITUACAO = S.IDSITUACAO"
				+ " WHERE CL.NOME LIKE '%" + filtroNome + "%'";

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Orcamento orcamentoBuscado = construirDoResultSet(resultadoDaConsulta);
				orcamentos.add(orcamentoBuscado);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar orcamento cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcCarro(String filtroCarro) {
		String sql = " SELECT O.IDORCAMENTO, CL.NOME, C.MODELO, O.DATAINICIO, (O.VALORPECAS + O.VALORMAOOBRA) AS VALTOTAL, S.DESITUACAO"
				+ " FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS C ON"
				+ " O.IDCARRO = C.IDCARRO"
				+ " INNER JOIN CLIENTE AS CL ON"
				+ " C.IDCLIENTE = CL.IDCLIENTE"
				+ " INNER JOIN SITUACAO AS S ON"
				+ " O.IDSITUACAO = S.IDSITUACAO"
				+ " WHERE C.MODELO = '" + filtroCarro + "'";

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Orcamento orcamentoBuscado = construirDoResultSet(resultadoDaConsulta);
				orcamentos.add(orcamentoBuscado);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar orcamento cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcSituacao(int filtroSituacao) {
		String sql = " SELECT O.IDORCAMENTO, CL.NOME, C.MODELO, O.DATAINICIO, (O.VALORPECAS + O.VALORMAOOBRA) AS VALTOTAL, S.DESITUACAO"
				+ " FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS C ON"
				+ " O.IDCARRO = C.IDCARRO"
				+ " INNER JOIN CLIENTE AS CL ON"
				+ " C.IDCLIENTE = CL.IDCLIENTE"
				+ " INNER JOIN SITUACAO AS S ON"
				+ " O.IDSITUACAO = S.IDSITUACAO"
				+ " WHERE S.IDSITUACAO = " + filtroSituacao;

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Orcamento orcamentoBuscado = construirDoResultSet(resultadoDaConsulta);
				orcamentos.add(orcamentoBuscado);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar orcamento cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return orcamentos;
	}

	

}
