package packageModel;

public class Produto {

	private String IdProduto;
	private String Nome;
	private String Codigo;
	private String Estoque;
	private String PrecoUnitario;
	private String TipoUnitario;
	private String DataFabricacao;
	private String DataValidade;
	
	public Produto() {
		super();
	}

	public Produto(String idProduto, String nome, String codigo, String estoque, String precoUnitario,
			String tipoUnitario, String dataFabricacao, String dataValidade) {
		super();
		IdProduto = idProduto;
		Nome = nome;
		Codigo = codigo;
		Estoque = estoque;
		PrecoUnitario = precoUnitario;
		TipoUnitario = tipoUnitario;
		DataFabricacao = dataFabricacao;
		DataValidade = dataValidade;
	}

	public String getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(String idProduto) {
		IdProduto = idProduto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getEstoque() {
		return Estoque;
	}

	public void setEstoque(String estoque) {
		Estoque = estoque;
	}

	public String getPrecoUnitario() {
		return PrecoUnitario;
	}

	public void setPrecoUnitario(String precoUnitario) {
		PrecoUnitario = precoUnitario;
	}

	public String getTipoUnitario() {
		return TipoUnitario;
	}

	public void setTipoUnitario(String tipoUnitario) {
		TipoUnitario = tipoUnitario;
	}

	public String getDataFabricacao() {
		return DataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		DataFabricacao = dataFabricacao;
	}

	public String getDataValidade() {
		return DataValidade;
	}

	public void setDataValidade(String dataValidade) {
		DataValidade = dataValidade;
	}
	
	
	
}
