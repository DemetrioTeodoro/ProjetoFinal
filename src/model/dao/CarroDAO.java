package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Carro;
import model.entity.Cliente;

public class CarroDAO implements BaseDAO<Carro> {

	@Override
	public Carro cadastrar(Carro carro) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CARRO (MARCA, ANO, COR, MODELO, PLACA, IDCLIENTE ) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, carro.getMarca()); 
			stmt.setInt(2, carro.getAno());
			stmt.setString(3, carro.getCor());
			stmt.setString(4, carro.getModelo());
			stmt.setString(5, carro.getPlaca());
			stmt.setInt(6, carro.getIdCliente());
			
			
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				carro.setIdCarro(idGerado);
			}
			}catch (SQLException e) {
				System.out.println("Erro ao inserir novo Carro.");
				System.out.println("Erro: " + e.getMessage());
				
			}finally {
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(stmt);		
			}
		return carro;	
		
		}

	@Override
	public Carro consultar(Carro novaEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(Carro novaEntidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	public Carro consultarPorPlaca(String placa) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CARRO"
				+ " WHERE PLACA = " + placa;

		Connection conexao = Banco.getConnection();
		ResultSet resultadoDaConsulta = null;
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		Carro carro = new Carro();
		
		try {
			resultadoDaConsulta = stmt.executeQuery();
			while(resultadoDaConsulta.next()) {
				carro = construirDoResultSet(resultadoDaConsulta);
				
				
			}
		}catch(SQLException ex) {
			System.out.println("Erro ao consultar carro por Placa cadastrado ");
			System.out.println("Erro: " + ex.getMessage());
		}finally {
			Banco.closeResultSet(resultadoDaConsulta);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		
		return carro;
	}
	
	private Carro construirDoResultSet(ResultSet rs) {
		Carro carro = null;
		
		  
		try {
			int id = rs.getInt("IDCARRO");
			String marca = rs.getString("MARCA");
			String modelo = rs.getString("MODELO");
			String cor = rs.getString("COR");
			String placa = rs.getString("PLACA");	
			int ano = rs.getInt("ANO");
			int idCliente = rs.getInt("IDCLIENTE");
				
			
			carro = new Carro();
			carro.setIdCarro(id);
			carro.setMarca(marca);
			carro.setModelo(modelo);
			carro.setCor(cor);
			carro.setPlaca(placa);
			carro.setAno(ano);
			carro.setIdCliente(idCliente);
			
	
		} catch (SQLException e) {
			System.out.println("Erro ao construir orcamento do ResultSet ");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return carro;
	}

}
