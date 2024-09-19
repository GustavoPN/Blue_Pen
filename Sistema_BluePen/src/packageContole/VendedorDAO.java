package packageContole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Vendedor;

public class VendedorDAO {

	public void create(Vendedor vendedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Vendedor VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, vendedor.getNome());
			stmt.setString(2, vendedor.getCpf());
			stmt.setString(3, vendedor.getEmail());
			stmt.setString(4, vendedor.getTelefone());
			stmt.setString(5, vendedor.getDataNascimento());
			stmt.setString(6, vendedor.getDataContratacao());
			stmt.setString(7, vendedor.getTotalVendido());
			stmt.setString(8, vendedor.getEndereco());
			stmt.setString(9, vendedor.getPassword());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Vendedor> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Vendedor vendedorLista = new Vendedor();
				vendedorLista.setIdVendedor(rs.getString(1));
				vendedorLista.setNome(rs.getString(2));
				vendedorLista.setCpf(rs.getString(3));
				vendedorLista.setEmail(rs.getString(4));
				vendedorLista.setTelefone(rs.getString(5));
				vendedorLista.setDataNascimento(rs.getString(6));
				vendedorLista.setDataContratacao(rs.getString(7));
				vendedorLista.setTotalVendido(rs.getString(8));
				vendedorLista.setEndereco(rs.getString(9));
				
				vendedor.add(vendedorLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return vendedor;
		
	}
	
	public void update(Vendedor vendedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Vendedor SET Nome = ?, "
														  + "Cpf = ?, "
														  + "Email = ?, "
														  + "Telefone = ?, "
														  + "DataNascimento = ?, "
														  + "DataContratacao = ?, "
														  + "TotalVendido = ?, "
														  + "Endereco = ?, "
														  + "Password = ?"
														  + "WHERE Cpf = ?");
			stmt.setString(1, vendedor.getNome());
			stmt.setString(2, vendedor.getCpf());
			stmt.setString(3, vendedor.getEmail());
			stmt.setString(4, vendedor.getTelefone());
			stmt.setString(5, vendedor.getDataNascimento());
			stmt.setString(6, vendedor.getDataContratacao());
			stmt.setString(7, vendedor.getTotalVendido());
			stmt.setString(8, vendedor.getEndereco());
			stmt.setString(9, vendedor.getPassword());
			stmt.setString(10, vendedor.getCpf());
			
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String Cpf) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Vendedor WHERE Cpf = ?");
			stmt.setString(1, Cpf);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! O Vendedor possui vendas registradas!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public Vendedor autenticarUser(String user, String password) {
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		Vendedor vendedor = new Vendedor();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor WHERE Password = ? AND Cpf = ?");
			stmt.setString(1, password);
			stmt.setString(2, user);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Vendedor vendedorLista = new Vendedor();
				vendedorLista.setIdVendedor(rs.getString(1));
				vendedorLista.setNome(rs.getString(2));
				vendedorLista.setCpf(rs.getString(3));
				vendedorLista.setEmail(rs.getString(4));
				vendedorLista.setTelefone(rs.getString(5));
				vendedorLista.setDataNascimento(rs.getString(6));
				vendedorLista.setDataContratacao(rs.getString(7));
				vendedorLista.setTotalVendido(rs.getString(8));
				vendedorLista.setEndereco(rs.getString(9));
				vendedorLista.setPassword(rs.getString(10));
				
				vendedor = vendedorLista;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return vendedor;
		
	}
	
	public ArrayList<Vendedor> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor where Nome like ? or Cpf like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Vendedor vendedorLista = new Vendedor();
				vendedorLista.setIdVendedor(rs.getString(1));
				vendedorLista.setNome(rs.getString(2));
				vendedorLista.setCpf(rs.getString(3));
				vendedorLista.setEmail(rs.getString(4));
				vendedorLista.setTelefone(rs.getString(5));
				vendedorLista.setDataNascimento(rs.getString(6));
				vendedorLista.setDataContratacao(rs.getString(7));
				vendedorLista.setTotalVendido(rs.getString(8));
				vendedorLista.setEndereco(rs.getString(9));
				
				vendedor.add(vendedorLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return vendedor;
		
	}

}
