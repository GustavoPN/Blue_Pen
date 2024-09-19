package packageContole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnection.ConnectionDatabase;
import packageModel.Compra;

public class CompraDAO {

	public void create(Compra compra) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Compra VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, compra.getIdCliente());
			stmt.setString(2, compra.getIdVendedor());
			stmt.setString(3, compra.getIdProduto());
			stmt.setString(4, compra.getQuantidade());
			stmt.setString(5, compra.getPrecoTotal());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Compra> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Compra> compra = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT IdCompra, Cliente.Nome, Vendedor.Nome, \r\n"
					+ "Produto.Nome, compra.Quantitade, compra.PrecoTotal\r\n"
					+ "										FROM Compra compra\r\n"
					+ "INNER JOIN Cliente cliente on compra.IdCliente = cliente.IdCliente\r\n"
					+ "INNER JOIN Produto produto on compra.IdProduto = produto.IdProduto\r\n"
					+ "INNER JOIN Vendedor vendedor on compra.IdVendedor = vendedor.IdVendedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Compra compraLista = new Compra();
				compraLista.setIdCompra(rs.getString(1));
				compraLista.setIdCliente(rs.getString(2));
				compraLista.setIdVendedor(rs.getString(3));
				compraLista.setIdProduto(rs.getString(4));
				compraLista.setQuantidade(rs.getString(5));
				compraLista.setPrecoTotal(rs.getString(6));
				
				compra.add(compraLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return compra;
		
	}
	
	public void update(Compra compra) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Compra SET IdCliente = ?, "
														  + "IdVendedor = ?, "
														  + "IdProduto = ?, "
														  + "Quantidade = ?, "
														  + "PrecoTotal = ? "
														  + "WHERE IdCompra = ?");
			stmt.setString(1, compra.getIdCliente());
			stmt.setString(2, compra.getIdVendedor());
			stmt.setString(3, compra.getIdProduto());
			stmt.setString(4, compra.getQuantidade());
			stmt.setString(5, compra.getPrecoTotal());
			stmt.setString(6, compra.getIdCompra());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(String IdCompra) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Compra WHERE IdCompra = ?");
			stmt.setString(1, IdCompra);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! Compra possui compras registradas!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<Compra> search(String search){
		search = "%"+search+"%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null; 
		ArrayList<Compra> compra = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Vw_RelatorioCompra where Cliente like ? or Vendedor like ? or Produto like ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			stmt.setString(3, search);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Compra compraLista = new Compra();
				compraLista.setIdCompra(rs.getString(1));
				compraLista.setIdCliente(rs.getString(2));
				compraLista.setIdVendedor(rs.getString(3));
				compraLista.setIdProduto(rs.getString(4));
				compraLista.setQuantidade(rs.getString(5));
				compraLista.setPrecoTotal(rs.getString(6));
				
				compra.add(compraLista);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		return compra;
		
	}
}
