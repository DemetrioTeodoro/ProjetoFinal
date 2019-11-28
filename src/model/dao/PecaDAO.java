package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				System.out.println("Erro ao inserir nova Pe�a.");
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
			System.out.println("Erro ao inserir nova Pe�a.");
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
			//Atualiza Item Pe�a
				
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
			System.out.println("Erro ao inserir nova Pe�a.");
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
		
			//Consulta Item Pe�a
				
				
		try { 
					
				resultado = stmt.execute(sql);
					
				if (resultado != false) {
						resposta = 1;
				}else {
						resposta = 0;
				}
					
			
					
		}catch (SQLException e) {
			System.out.println("Erro ao inserir nova Pe�a.");
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
				p.setDataEntrada(LocalDate.parse((CharSequence) result.getDate("I.DATAENTRADA"), formatador));
				p.setDataSaida(LocalDate.parse((CharSequence) result.getDate("I.DATASAIDA"), formatador));
				p.setQuantidade(result.getInt("I.QUANTIDADE"));
				pecas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pecas;

	
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
				System.out.println("Erro ao inserir nova Pe�a.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return peca;	
		
		}
}
