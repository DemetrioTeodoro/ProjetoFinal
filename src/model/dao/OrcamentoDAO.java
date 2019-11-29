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
			stmt.setInt(1, orcamento.getCliente().getCarro().getIdCarro());
			stmt.setString(2, orcamento.getDescricao());
			stmt.setDate(3, Date.valueOf(orcamento.getDataInicio()));
			stmt.setInt(4, orcamento.getSituacao());
						
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				orcamento.getCliente().getCarro().setIdCarro(idGerado);
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

	public Orcamento cadastrarCarro(Orcamento orcamento) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CARRO (MARCA, ANO, COR, MODELO, PLACA, IDCLIENTE ) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, orcamento.getCliente().getCarro().getMarca()); 
			stmt.setString(2, orcamento.getCliente().getCarro().getAno());
			stmt.setString(3, orcamento.getCliente().getCarro().getCor());
			stmt.setString(4, orcamento.getCliente().getCarro().getModelo());
			stmt.setString(5, orcamento.getCliente().getCarro().getPlaca());
			stmt.setInt(6, orcamento.getCliente().getIdCliente());
			
			
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				orcamento.getCliente().getCarro().setIdCarro(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir novo Carro.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return orcamento;	
		
		}

	public Orcamento cadastrarCliente(Orcamento orcamento) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CLIENTE (NOME, CPF, TELEFONE) "
				+ "VALUES (?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, orcamento.getCliente().getNome());
			stmt.setString(2, orcamento.getCliente().getCpf());
			stmt.setString(3, orcamento.getCliente().getTelefone());
			

			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				orcamento.getCliente().setIdCliente(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir novo Cliente.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return orcamento;	
		
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
			String nome = rs.getString("NOME");
			String modelo = rs.getString("MODELO");
			LocalDate dataInicio = (LocalDate.parse((CharSequence) rs.getDate("DATAINICIO").toString(), formatador));
			
			double valorTotal = 0;
			
			if (rs.getDouble("VALTOTAL") != 0) {
				valorTotal = rs.getDouble("VALTOTAL");
			}
			
			String situacao = rs.getString("DESITUACAO");		
			
			orc = new Orcamento();
			orc.setIdOrcamento(id);
			orc.setNmCliente(nome);
			orc.setModeloCarro(modelo);
			orc.setDataInicio(dataInicio);
			orc.setValorTotal(valorTotal);
			orc.setDeSituacao(situacao);
	
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
