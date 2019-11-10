package model.dao;

import java.sql.Connection;
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
			
			//Adiciona Item Peça
				sql = "INSERT INTO ITEM_PECA (IDPECA, QUANTIDADE, VALORCOMPRA, VALORVENDA, DATAENTRADA, DATASAIDA ) "
						+ "VALUES (?,?,?,?,?,?)";
				stmt = Banco.getPreparedStatement(conn, sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
				try { 
					stmt.setInt(1, peca.getIdPeca());
					stmt.setInt(2, peca.getQuantida()); 
					stmt.setDouble(3, peca.getValCompra());
					stmt.setDouble(4, peca.getValVenda());
					stmt.setString(5, peca.getDataEntrada());
					stmt.setString(6, peca.getDataSaida());
					
					stmt.execute();
				
			
				
			}finally {
				generatedKeys = stmt.getGeneratedKeys();
				if(generatedKeys.next()) {
					idGerado = generatedKeys.getInt(1);
					peca.setIdItempeca(idGerado); 
				}
			}
					
		} }catch (SQLException e) {
			System.out.println("Erro ao inserir nova Peça.");
			System.out.println("Erro: " + e.getMessage());
		}
		

		return peca;
		}
	

	@Override
	public Peca consultar(Peca peca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Peca peca) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
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
				p.setDataEntrada(result.getString("I.DATAENTRADA"));
				p.setDataSaida(result.getString("I.DATASAIDA"));
				p.setQuantida(result.getInt("I.QUANTIDADE"));
				pecas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pecas;

	
	}
}
