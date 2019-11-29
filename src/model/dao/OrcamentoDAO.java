package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.entity.Orcamento;

public class OrcamentoDAO implements BaseDAO<Orcamento> {

	@Override
	public Orcamento cadastrar(Orcamento orcamento) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ORCAMENTO (IDCARRO, DESCRICAO, DATAINICIO ) "
				+ "VALUES (?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setInt(1, orcamento.getCliente().getCarro().getIdCarro());
			stmt.setString(2, orcamento.getDescricao());
			stmt.setDate(3, Date.valueOf(orcamento.getDataInicio()));
			//stmt.setString(4, orcamento.getSituacao().toString());
						
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
		// TODO Auto-generated method stub
		return true;
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

	

}
