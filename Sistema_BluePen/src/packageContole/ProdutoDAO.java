package packageContole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Produto;

public class ProdutoDAO {

	public void create(Produto produto) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Produto VALUES(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getCodigo());
			stmt.setString(3, produto.getEstoque());
			stmt.setString(4, produto.getPrecoUnitario());
			stmt.setString(5, produto.getTipoUnitario());
			stmt.setString(6, produto.getDataFabricacao());
			stmt.setString(7, produto.getDataValidade());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Produto> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produtoLista = new Produto();
				produtoLista.setIdProduto(rs.getString(1));
				produtoLista.setNome(rs.getString(2));
				produtoLista.setCodigo(rs.getString(3));
				produtoLista.setEstoque(rs.getString(4));
				produtoLista.setPrecoUnitario(rs.getString(5));
				produtoLista.setTipoUnitario(rs.getString(6));
				produtoLista.setDataFabricacao(rs.getString(7));
				produtoLista.setDataValidade(rs.getString(8));
				
				produto.add(produtoLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return produto;
		
	}
	
	public void update(Produto produto) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Produto SET Nome = ?, "
														  + "Codigo = ?, "
														  + "Estoque = ?, "
														  + "PrecoUnitario = ?, "
														  + "TipoUnitario = ? "
														  + "DataFabricacao = ?, "
														  + "DataValidade = ? "
														  + "WHERE Codigo = ?");
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getCodigo());
			stmt.setString(3, produto.getEstoque());
			stmt.setString(4, produto.getPrecoUnitario());
			stmt.setString(5, produto.getTipoUnitario());
			stmt.setString(6, produto.getDataFabricacao());
			stmt.setString(7, produto.getDataValidade());
			stmt.setString(8, produto.getCodigo());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String Codigo) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Produto WHERE Codigo = ?");
			stmt.setString(1, Codigo);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! Não foi possivel deletar o Produto!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Produto> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto where Nome like ? or Codigo like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produtoLista = new Produto();
				produtoLista.setIdProduto(rs.getString(1));
				produtoLista.setNome(rs.getString(2));
				produtoLista.setCodigo(rs.getString(3));
				produtoLista.setEstoque(rs.getString(4));
				produtoLista.setPrecoUnitario(rs.getString(5));
				produtoLista.setTipoUnitario(rs.getString(6));
				produtoLista.setDataFabricacao(rs.getString(7));
				produtoLista.setDataValidade(rs.getString(8));
				
				produto.add(produtoLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return produto;
		
	}
}
