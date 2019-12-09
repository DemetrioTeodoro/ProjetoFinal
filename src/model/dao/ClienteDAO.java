package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.Carro;
import model.entity.Cliente;
import model.entity.Orcamento;

public class ClienteDAO implements BaseDAO<Cliente> {

	@Override
	public Cliente cadastrar(Cliente cliente) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CLIENTE (NOME, CPF, TELEFONE) "
				+ "VALUES (?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			

			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				cliente.setIdCliente(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir novo Cliente.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return cliente;	
		
		}
	

	@Override
	public Cliente consultar(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente consultarPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE"
				+ " WHERE CPF = " + cpf;

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		Cliente cliente = new Cliente();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				cliente = construirClienteDoResultSet(resultadoDaConsulta);
				
				
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar cliente por CPF cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return cliente;
	}
	
	private Cliente construirClienteDoResultSet(ResultSet rs) {
		Cliente cliente = null;
		
		  
		try {
			int id = rs.getInt("IDCLIENTE");
			String nome = rs.getString("NOME");
			String cpf = rs.getString("CPF");
			String telefone = rs.getString("TELEFONE");	
			
			cliente = new Cliente();
			cliente.setIdCliente(id);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setTelefone(telefone);
			
	
		} catch (SQLException e) {
			System.out.println("Erro ao construir cliente do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return cliente;
	}


	public Cliente consultarNome(int idCliente) {
		Cliente c = null;

		String sql = " SELECT * FROM CLIENTE WHERE IDCLIENTE = " + idCliente;

		PreparedStatement stmt;
		try {
			stmt = Banco.getConnection().prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				c = this.construirClienteDoResultSet(rs);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por id. Erro: " + e.getMessage());
		}

		return c;
	}
}
