package packageContole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Cliente;

public class ClienteDAO {
	
	public void create(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Cliente VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpfCnpj());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getDataNascimento());
			stmt.setString(6, cliente.getDataPrimeiraCompra());
			stmt.setString(7, cliente.getEndereco());
			stmt.setString(8, cliente.getTipoJuridico());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Cliente> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente clienteLista = new Cliente();
				clienteLista.setIdCliente(rs.getString(1));
				clienteLista.setNome(rs.getString(2));
				clienteLista.setCpfCnpj(rs.getString(3));
				clienteLista.setEmail(rs.getString(4));
				clienteLista.setTelefone(rs.getString(5));
				clienteLista.setDataNascimento(rs.getString(6));
				clienteLista.setDataPrimeiraCompra(rs.getString(7));
				clienteLista.setEndereco(rs.getString(8));
				clienteLista.setTipoJuridico(rs.getString(9));
				
				cliente.add(clienteLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return cliente;
		
	}
	
	public void update(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Cliente SET Nome = ?, "
														  + "CpfCnpj = ?, "
														  + "Email = ?, "
														  + "Telefone = ?, "
														  + "DataNascimento = ?, "
														  + "DataPrimeiraCompra = ?, "
														  + "Endereco = ?, "
														  + "TipoJuridico = ? "
														  + "WHERE CpfCnpj = ?");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpfCnpj());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getDataNascimento());
			stmt.setString(6, cliente.getDataPrimeiraCompra());
			stmt.setString(7, cliente.getEndereco());
			stmt.setString(8, cliente.getTipoJuridico());
			stmt.setString(9, cliente.getCpfCnpj());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String CpfCnpj) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Cliente WHERE CpfCnpj = ?");
			stmt.setString(1, CpfCnpj);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! O Cliente possui compras registradas!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Cliente> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente where Nome like ? or CpfCnpj like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente clienteLista = new Cliente();
				clienteLista.setIdCliente(rs.getString(1));
				clienteLista.setNome(rs.getString(2));
				clienteLista.setCpfCnpj(rs.getString(3));
				clienteLista.setEmail(rs.getString(4));
				clienteLista.setTelefone(rs.getString(5));
				clienteLista.setDataNascimento(rs.getString(6));
				clienteLista.setDataPrimeiraCompra(rs.getString(7));
				clienteLista.setEndereco(rs.getString(8));
				clienteLista.setTipoJuridico(rs.getString(9));
				
				cliente.add(clienteLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return cliente;
		
	}

}
