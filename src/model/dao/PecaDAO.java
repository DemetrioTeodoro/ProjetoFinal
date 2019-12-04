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

import model.entity.Peca;


public class PecaDAO implements BaseDAO<Peca> {
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public Peca cadastrar(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO PECA (NOMEPECA, CODIGO ) "
				+ "VALUES (?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, peca.getNomePeca()); 
			stmt.setString(2, peca.getCodigo());
			
			
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				peca.setIdPeca(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir nova Peça.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return peca;	
		
		}
	

	@Override
	public Peca consultar(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT ITEM_PECA.IDPECA, IDORCAMENTO, PECA.NOMEPECA, PECA.CODIGO ,QUANTIDADE, VALORCOMPRA, VALORVENDA, ITEM_PECA.DATAENTRADA, ITEM_PECA.DATASAIDA "
				+ " FROM ITEM_PECA "
				+ " INNER JOIN PECA ON "
				+ " ITEM_PECA.IDPECA = PECA.IDPECA "
				+ " WHERE ITEM_PECA.IDPECA = ? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		Peca pecs = new Peca();
		
		try {
			
			stmt.setInt(1, peca.getIdPeca());
			
			pecs.setNomePeca(rs.getString("NOMEPECA")); 
			pecs.setCodigo(rs.getString("CODIGO"));
			pecs.setIdPeca(rs.getInt("IDPECA"));
			pecs.setQuantidade(rs.getInt("QUANTIDADE"));
			pecs.setValCompra(rs.getDouble("VALORCOMPRA"));
			pecs.setValVenda(rs.getDouble("VALORVENDA"));
			pecs.setDataEntrada(LocalDate.parse((CharSequence) rs.getDate("DATAENTRADA"), formatador));
			pecs.setDataSaida(LocalDate.parse((CharSequence) rs.getDate("DATASAIDA"), formatador));
					
			stmt.execute();
					
		}catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peça.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		

		return pecs;
	}

	@Override
	public boolean alterar(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE ITEM_PECA SET IDPECA = ?, QUANTIDADE = ?, VALORCOMPRA = ?, VALORVENDA = ?, DATAENTRADA = ?,DATASAIDA = ?"
				+ " WHERE IDPECA = ? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn);
		ResultSet rs = null;
		boolean resultado = false;
			//Atualiza Item Peça
				
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					
					stmt.setInt(1, peca.getIdPeca());
					stmt.setInt(2, peca.getQuantidade());
					stmt.setDouble(3, peca.getValCompra());
					stmt.setDouble(4, peca.getValVenda());
					stmt.setDate(4, Date.valueOf(peca.getDataEntrada()));
					stmt.setDate(4, Date.valueOf(peca.getDataSaida()));
					stmt.setInt(5, peca.getIdPeca());
					
					stmt.executeUpdate();
					
					if (stmt.executeUpdate() != 0) {
						
						resultado = true;
						
					}
				
			
					
		 }catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peça.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		

		return resultado;
	}

	@Override
	public boolean deletar(int id) {
		Connection conexao = Banco.getConnection();
		Statement statement = Banco.getStatement(conexao);
		String sql = " DELETE FROM ITEM_PECA WHERE IDPECA = " + id;

		int quantidadeRegistrosExcluidos = 0;
		try {
			quantidadeRegistrosExcluidos = statement.executeUpdate(sql);
			
			if (quantidadeRegistrosExcluidos > 0) {
				sql = " DELETE FROM PECA WHERE IDPECA = " + id;
				quantidadeRegistrosExcluidos = quantidadeRegistrosExcluidos + statement.executeUpdate(sql);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir peça.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(statement);
			Banco.closeConnection(conexao);
		}

		return quantidadeRegistrosExcluidos > 1;
	}


	public ArrayList<Peca> listarTodos() {
		String sql = " SELECT P.CODIGO, P.NOMEPECA, I.VALORVENDA, I.VALORCOMPRA, I.DATAENTRADA, I.DATASAIDA, I.QUANTIDADE, I.IDPECA"
				+ " FROM PECA AS P"
				+ " INNER JOIN ITEM_PECA AS I ON"
				+ " P.IDPECA = I.IDPECA";

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Peca pecaBuscada = construirDoResultSet(resultadoDaConsulta);
				pecas.add(pecaBuscada);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar pecas cadastradas ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return pecas;
	}

	private Peca construirDoResultSet(ResultSet rs) {
		Peca pc = null;
		
		try {
			String codigo = rs.getString("CODIGO");
			String nome = rs.getString("NOMEPECA");
			double valorCompra = rs.getDouble("VALORCOMPRA");
			double valorVenda = rs.getDouble("VALORVENDA");
			LocalDate dataEntrada = (LocalDate.parse((CharSequence) rs.getDate("DATAENTRADA").toString(), formatador));
			LocalDate dataSaida = (LocalDate.parse((CharSequence) rs.getDate("DATASAIDA").toString(), formatador));
			int quantidade = rs.getInt("QUANTIDADE");
			int id = rs.getInt("IDPECA");
			
			pc = new Peca();
			pc.setCodigo(codigo);
			pc.setNomePeca(nome);
			pc.setValCompra(valorCompra);
			pc.setValVenda(valorVenda);
			pc.setDataEntrada(dataEntrada);
			pc.setDataSaida(dataSaida);
			pc.setQuantidade(quantidade);
			pc.setIdPeca(id);
					
			
		} catch (SQLException e) {
			System.out.println("Erro ao construir peca do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return pc;
	}


	public Peca cadastrarItemPeca(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ITEM_PECA (IDPECA, QUANTIDADE, VALORCOMPRA, VALORVENDA, DATAENTRADA, DATASAIDA) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setInt(1, peca.getIdPeca());
			stmt.setInt(2, peca.getQuantidade()); 
			stmt.setDouble(3, peca.getValCompra());
			stmt.setDouble(4, peca.getValVenda());
			stmt.setDate(5, Date.valueOf(peca.getDataEntrada()));
			stmt.setDate(6, Date.valueOf(peca.getDataSaida()));
			
			
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				peca.setIdItempeca(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir nova Peça.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return peca;	
		
		}


	public ArrayList<Peca> consultarPecaNome(String nomePeca) {
		String sql = " SELECT P.CODIGO, P.NOMEPECA, I.VALORVENDA, I.VALORCOMPRA, I.DATAENTRADA, I.DATASAIDA, I.QUANTIDADE, I.IDPECA"
				+ " FROM PECA AS P"
				+ " INNER JOIN ITEM_PECA AS I ON"
				+ " P.IDPECA = I.IDPECA"
				+ " WHERE P.NOMEPECA LIKE '%" + nomePeca + "%'";
		
		

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		
		try {

			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				Peca pecaBuscada = construirDoResultSet(resultadoDaConsulta);
				pecas.add(pecaBuscada);
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar pecas cadastradas ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return pecas;
	}


	public Peca consultarPecaCodigo(String codigo) {
		String sql = " SELECT P.CODIGO, P.NOMEPECA, I.VALORVENDA, I.VALORCOMPRA, I.DATAENTRADA, I.DATASAIDA, I.QUANTIDADE, I.IDPECA"
				+ " FROM PECA AS P"
				+ " INNER JOIN ITEM_PECA AS I ON"
				+ " P.IDPECA = I.IDPECA"
				+ " WHERE P.CODIGO = " + codigo;
		
		

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		Peca peca = new Peca();
		
		try {

			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				peca = construirDoResultSet(resultadoDaConsulta);
				
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar peca cadastradas ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return peca;
	}


	public String excluirPeca(String codigo) {
		Connection conexao = Banco.getConnection();
		Statement statement = Banco.getStatement(conexao);
		String sql = " DELETE FROM ITEM_PECA WHERE CODIGO = " + codigo;

		int quantidadeRegistrosExcluidos = 0;
		try {
			quantidadeRegistrosExcluidos = statement.executeUpdate(sql);
			
			if (quantidadeRegistrosExcluidos > 0) {
				sql = " DELETE FROM PECA WHERE CODIGO = " + codigo;
				quantidadeRegistrosExcluidos = quantidadeRegistrosExcluidos + statement.executeUpdate(sql);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir peça.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(statement);
			Banco.closeConnection(conexao);
		}

		return null;
	}
}
