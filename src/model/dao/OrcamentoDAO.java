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

import model.entity.Carro;
import model.entity.Mecanico;
import model.entity.Orcamento;
import model.entity.Peca;
import model.entity.Servico;
import model.entity.Situacao;

public class OrcamentoDAO implements BaseDAO<Orcamento> {

	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	
	@Override
	public Orcamento cadastrar(Orcamento orcamento) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ORCAMENTO (IDCARRO, DESCRICAO, DATAINICIO, IDSITUACAO, NUORCAMENTO ) "
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setInt(1, orcamento.getCarro().getIdCarro());
			stmt.setString(2, orcamento.getDescricao());
			stmt.setDate(3, Date.valueOf(orcamento.getDataInicio()));
			stmt.setInt(4, orcamento.getSituacao().getIdSituacao());
			stmt.setInt(5, orcamento.getNumeroOrcamento());
						
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
	public boolean deletar(int nuExclusao) {
		Connection conexao = Banco.getConnection();
		Statement statement = Banco.getStatement(conexao);
		String sql = " DELETE FROM ORCAMENTO WHERE NUORCAMENTO = " + nuExclusao;

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
		String sql = " SELECT * FROM ORCAMENTO";

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
			System.out.println("Erro ao consultar orcamento cadastrados ");
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
			double valPecas = rs.getDouble("VALORPECAS");
			double valMaoObra = rs.getDouble("VALORMAOOBRA");
			
			Date dataInicioBanco = rs.getDate("DATAINICIO");
			
			orc = new Orcamento();
			
			orc.setIdOrcamento(id);
			orc.setNumeroOrcamento(numeroOrcamento);
			orc.setDescricao(descricao);
			
			if(dataInicioBanco != null) {
				LocalDate dataInicio = (LocalDate.parse((CharSequence) dataInicioBanco.toString(), formatador));
				orc.setDataInicio(dataInicio);
			}
			
			Date dataFinalBanco = rs.getDate("DATAFINAL");
			
			if (dataFinalBanco != null) {
				LocalDate dataFinal = (LocalDate.parse((CharSequence) dataFinalBanco.toString(), formatador));
				orc.setDataFinal(dataFinal);
			}
				
			int idMecanico = rs.getInt("IDMECANICO");
			
			if (idMecanico != 0) {
				MecanicoDAO mecDAO = new MecanicoDAO();
				Mecanico mecanicoDoOrcamento = mecDAO.consultarPorId(idMecanico);
				orc.setMecanico(mecanicoDoOrcamento);
			}
			
			int idCarro = rs.getInt("IDCARRO");
			
			if (idCarro != 0) {
				CarroDAO carDAO = new CarroDAO();
				Carro carroDoOrcamento = carDAO.consultarPorId(idCarro);
				orc.setCarro(carroDoOrcamento);
			}
			
			int idSituacao = rs.getInt("IDSITUACAO");
				SituacaoDAO sitDAO = new SituacaoDAO();
				Situacao situacaoDoOrcamento = sitDAO.consultarPorId(idSituacao);
				orc.setSituacao(situacaoDoOrcamento);
			
					
			int idServico = rs.getInt("IDSERVICO");	
			
			if (idServico != 0) {
				ServicoDAO serDAO = new ServicoDAO();
				Servico servicoDoOrcamento = serDAO.consultarPorId(idServico);
				orc.setServico(servicoDoOrcamento);
			}
			
			
			orc.setValorPeca(valPecas);
			orc.setValorMaoObra(valMaoObra);
	
		} catch (SQLException e) {
			System.out.println("Erro ao construir orcamento do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return orc;
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " INNER JOIN CLIENTE AS C ON"
				+ " CR.IDCLIENTE = C.IDCLIENTE"
				+ " WHERE C.NOME LIKE '%" + filtroNome + "%'";

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
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " WHERE CR.MARCA = '" + filtroCarro + "'";

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
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " WHERE O.IDSITUACAO = " + filtroSituacao;

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

	public ArrayList<Orcamento> consultarPorNomeMarca(String filtroNome, String marca) {
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " INNER JOIN CLIENTE AS C ON"
				+ " CR.IDCLIENTE = C.IDCLIENTE"
				+ " WHERE C.NOME LIKE '%" + filtroNome + "%' AND CR.MARCA = '" + marca + "'";

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

	public ArrayList<Orcamento> consultarPorNomeSituacao(String filtroNome, int filtroSituacao) {
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " INNER JOIN CLIENTE AS C ON"
				+ " CR.IDCLIENTE = C.IDCLIENTE"
				+ " WHERE C.NOME LIKE '%" + filtroNome + "%' AND O.IDSITUACAO = " + filtroSituacao;

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

	public ArrayList<Orcamento> consultarPorMarcaSituacao(String marca, int filtroSituacao) {
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " WHERE CR.MARCA = '" + marca + "' AND O.IDSITUACAO = " + filtroSituacao;

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

	public ArrayList<Orcamento> consultarPorTodosFiltros(String filtroNome, String marca, int filtroSituacao) {
		String sql = " SELECT * FROM ORCAMENTO AS O"
				+ " INNER JOIN CARRO AS CR ON"
				+ " O.IDCARRO = CR.IDCARRO"
				+ " INNER JOIN CLIENTE AS C ON"
				+ " CR.IDCLIENTE = C.IDCLIENTE"
				+ " WHERE C.NOME LIKE '%" + filtroNome + "%' AND CR.MARCA = '" + marca + "' AND O.IDSITUACAO = " + filtroSituacao;

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
