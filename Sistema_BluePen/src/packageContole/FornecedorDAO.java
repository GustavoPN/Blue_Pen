package packageContole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import packageConnection.ConnectionDatabase;
import packageModel.Fornecedor;

public class FornecedorDAO {

	public void create(Fornecedor fornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Fornecedor VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCNPJ());
			stmt.setString(3, fornecedor.getEmail());
			stmt.setString(4, fornecedor.getTelefone());
			stmt.setString(5, fornecedor.getEndereco());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Fornecedor> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Fornecedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedorLista = new Fornecedor();
				fornecedorLista.setIdFornecedor(rs.getString(1));
				fornecedorLista.setNome(rs.getString(2));
				fornecedorLista.setCNPJ(rs.getString(3));
				fornecedorLista.setEmail(rs.getString(4));
				fornecedorLista.setTelefone(rs.getString(5));
				fornecedorLista.setEndereco(rs.getString(6));
				
				fornecedor.add(fornecedorLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return fornecedor;
		
	}
	
	public void update(Fornecedor fornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Fornecedor SET Nome = ?, "
														  + "CNPJ = ?, "
														  + "Email = ?, "
														  + "Telefone = ?, "
														  + "Endereco = ? "
														  + "WHERE CNPJ = ?");
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getCNPJ());
			stmt.setString(3, fornecedor.getEmail());
			stmt.setString(4, fornecedor.getTelefone());
			stmt.setString(5, fornecedor.getEndereco());
			stmt.setString(6, fornecedor.getCNPJ());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String CNPJ) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Fornecedor WHERE CNPJ = ?");
			stmt.setString(1, CNPJ);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! Não foi possivel apagar Fornecedor!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Fornecedor> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Fornecedor where Nome like ? or CNPJ like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedorLista = new Fornecedor();
				fornecedorLista.setIdFornecedor(rs.getString(1));
				fornecedorLista.setNome(rs.getString(2));
				fornecedorLista.setCNPJ(rs.getString(3));
				fornecedorLista.setEmail(rs.getString(4));
				fornecedorLista.setTelefone(rs.getString(5));
				fornecedorLista.setEndereco(rs.getString(6));
				
				fornecedor.add(fornecedorLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return fornecedor;
		
	}
	
	public ObservableList<String> readNome(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ObservableList<String> fornecedor = FXCollections.observableArrayList();
		
		try {
			stmt = con.prepareStatement("SELECT Nome FROM Fornecedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String fornecedorLista = rs.getString(1);
				fornecedor.add(fornecedorLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return fornecedor;
		
	}
	
}
