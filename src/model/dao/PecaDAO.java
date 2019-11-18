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
			
			
			stmt.execute(sql);
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				peca.setIdPeca(idGerado);
			
			//Adiciona Item Pe�a
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
					
					stmt.execute(sql);
				
			
				
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
			System.out.println("Erro ao inserir nova Pe�a.");
			System.out.println("Erro: " + e.getMessage());
		}
		

		return peca;
		}
	

	@Override
	public Peca consultar(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = "SELECT NOMEPECA,CODIGO FROM PECA ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		Peca pecs = new Peca();
		
		try {
			
			
			pecs.setNomePeca(rs.getString("NOMEPECA")); 
			pecs.setCodigo(rs.getString("CODIGO"));
			
			
			stmt.execute(sql);
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				peca.setIdPeca(idGerado);
			
			//Consulta Item Pe�a
				sql = "SELECT IDPECA, QUANTIDADE, VALORCOMPRA, VALORVENDA, DATAENTRADA, DATASAIDA FROM ITEM_PECA ";
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					pecs.setIdPeca(rs.getInt("IDPECA"));
					pecs.setQuantida(rs.getInt("QUANTIDADE"));
					pecs.setValCompra(rs.getDouble("VALORCOMPRA"));
					pecs.setValVenda(rs.getDouble("VALORVENDA"));
					pecs.setDataEntrada(rs.getDate("DATAENTRADA"));
					pecs.setDataSaida(rs.getDate("DATASAIDA"));
					
					stmt.execute(sql);
				
			
				
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
			System.out.println("Erro ao inserir nova Pe�a.");
			System.out.println("Erro: " + e.getMessage());
		}
		

		return pecs;
	}

	@Override
	public boolean alterar(Peca peca) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE PECA SET NOMEPECA = " + peca.getNomePeca()
				+ ", CODIGO = " + peca.getCodigo()
				+ "WHERE IDPECA = " + peca.getIdPeca() ;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		boolean resultado = false;
		
		try {
			if (stmt.executeUpdate(sql) != 0) {
				
				resultado = true;
				
			}			
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				peca.setIdPeca(idGerado);
			
			//Atualiza Item Pe�a
				sql = "UPDATE ITEM_PECA SET IDPECA = " + peca.getIdPeca()
						+ ",QUANTIDADE = " + peca.getQuantida()
						+ ",VALORCOMPRA = " + peca.getValCompra()
						+ ",VALORVENDA = " + peca.getValVenda()
						+ ",DATAENTRADA = " + peca.getDataEntrada()
						+ ",DATASAIDA = " + peca.getDataSaida()
						+ " WHERE IDITEMPECA = " + peca.getIdItempeca();
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					if (stmt.executeUpdate(sql) != 0) {
						
						resultado = true;
						
					}
				
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
			System.out.println("Erro ao inserir nova Pe�a.");
			System.out.println("Erro: " + e.getMessage());
		}
		

		return resultado;
	}

	@Override
	public int deletar(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM PECA WHERE IDPECA = " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		Peca pecs = new Peca();
		boolean resultado = false;
		int resposta = 0;
		
		try {
			
			resultado = stmt.execute(sql);
			
			if (resultado != false) {
				resposta = 1;
			}else {
				resposta = 0;
			}
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
			
			//Consulta Item Pe�a
				sql = "DELETE FROM ITEM_PECA WHERE IDPECA = " + id;
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					
					resultado = stmt.execute();
					if (resultado != false) {
						resposta = 1;
					}else {
						resposta = 0;
					}
					
			}finally {
				generatedKeys = stmt.getGeneratedKeys();
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);
				Banco.closeResultSet(generatedKeys);
			}
					
		} }catch (SQLException e) {
			System.out.println("Erro ao inserir nova Pe�a.");
			System.out.println("Erro: " + e.getMessage());
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
