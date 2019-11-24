package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Peca;


public class PecaDAO implements BaseDAO<Peca> {

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
			
			//Adiciona Item Peï¿½a
				sql = "INSERT INTO ITEM_PECA (IDPECA, QUANTIDADE, VALORCOMPRA, VALORVENDA, DATAENTRADA, DATASAIDA ) "
						+ "VALUES (?,?,?,?,?,?)";
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					stmt.setInt(1, peca.getIdPeca());
					stmt.setInt(2, peca.getQuantida()); 
					stmt.setDouble(3, peca.getValCompra());
					stmt.setDouble(4, peca.getValVenda());
					stmt.setDate(5, (Date) peca.getDataEntrada());
					stmt.setDate(6, (Date) peca.getDataSaida());
					
					stmt.execute();
				
			
				
			}finally {
				generatedKeys = stmt.getGeneratedKeys();
				if(generatedKeys.next()) {
					idGerado = generatedKeys.getInt(1);
					peca.setIdItempeca(idGerado); 
				}
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);
				Banco.closeResultSet(generatedKeys);
			}
					
		} }catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peï¿½a.");
			System.out.println("Erro: " + e.getMessage());
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
			pecs.setQuantida(rs.getInt("QUANTIDADE"));
			pecs.setValCompra(rs.getDouble("VALORCOMPRA"));
			pecs.setValVenda(rs.getDouble("VALORVENDA"));
			pecs.setDataEntrada(rs.getDate("DATAENTRADA"));
			pecs.setDataSaida(rs.getDate("DATASAIDA"));
					
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
					stmt.setInt(2, peca.getQuantida());
					stmt.setDouble(3, peca.getValCompra());
					stmt.setDouble(4, peca.getValVenda());
					stmt.setDate(4, (Date) peca.getDataEntrada());
					stmt.setDate(4, (Date) peca.getDataSaida());
					stmt.setInt(5, peca.getIdPeca());
					
					stmt.executeUpdate();
					
					if (stmt.executeUpdate() != 0) {
						
						resultado = true;
						
					}
				
			
					
		 }catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peï¿½a.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		

		return resultado;
	}

	@Override
	public int deletar(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE * FROM ITEM_PECA WHERE IDPECA = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn);
		ResultSet rs = null;
		Peca peca = new Peca();
		boolean resultado = false;
		int resposta = 0;
		
			//Consulta Item Peça
				
				
		try { 
					
				resultado = stmt.execute(sql);
					
				if (resultado != false) {
						resposta = 1;
				}else {
						resposta = 0;
				}
					
			
					
		}catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peça.");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		

		return resposta;
	}


	public ArrayList<Peca> listarTodos() {
		String sql = " SELECT P.CODIGO, P.NOME, I.VALORVENDA, I.VALORCOMPRA, I.DATAENTRADA, I.DATASAIDA, I.QUANTIDADE"
				+ " FROM PECA"
				+ "INNER JOIN ITEM_PECA ON"
				+ "P.IDPECA = I.IDPECA";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Peca> pecas = new ArrayList<Peca>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				Peca p = new Peca();

				// Obtendo valores pelo NOME DA COLUNA
				p.setCodigo(result.getString("P.CODIGO"));
				p.setNomePeca(result.getString("P.NOME"));
				p.setValVenda(result.getDouble("I.VALORVENDA"));
				p.setValCompra(result.getDouble("I.VALORCOMPRA"));
				p.setDataEntrada(result.getDate("I.DATAENTRADA"));
				p.setDataSaida(result.getDate("I.DATASAIDA"));
				p.setQuantida(result.getInt("I.QUANTIDADE"));
				pecas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pecas;

	
	}
}
