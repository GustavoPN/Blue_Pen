package packageModel;

public class Compra {
	
	private String IdCompra;
	private String IdCliente;
	private String IdVendedor;
	private String IdProduto;
	private String Quantidade;
	private String PrecoTotal;
	
	public Compra() {
		super();
	}

	public Compra(String idCompra, String idCliente, String idVendedor, String idProduto, String quantidade,
			String precoTotal) {
		super();
		IdCompra = idCompra;
		IdCliente = idCliente;
		IdVendedor = idVendedor;
		IdProduto = idProduto;
		Quantidade = quantidade;
		PrecoTotal = precoTotal;
	}

	public String getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(String idCompra) {
		IdCompra = idCompra;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getIdVendedor() {
		return IdVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		IdVendedor = idVendedor;
	}

	public String getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(String idProduto) {
		IdProduto = idProduto;
	}

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getPrecoTotal() {
		return PrecoTotal;
	}

	public void setPrecoTotal(String precoTotal) {
		PrecoTotal = precoTotal;
	}

}
