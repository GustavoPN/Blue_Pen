package packageModel;

public class Vendedor {
	
	private String IdVendedor;
	private String Nome;
	private String Cpf;
	private String Email;
	private String Telefone;
	private String DataNascimento;
	private String DataContratacao;
	private String TotalVendido;
	private String Endereco;
	private String Password;
	
	public Vendedor() {
		super();
	}

	public Vendedor(String idVendedor, 
					String nome,
					String cpf, 
					String email, 
					String telefone, 
					String dataNascimento,
					String dataContratacao, 
					String totalVendido,
					String endereco,
					String passowrd) {
		super();
		IdVendedor = idVendedor;
		Nome = nome;
		Cpf = cpf;
		Email = email;
		Telefone = telefone;
		DataNascimento = dataNascimento;
		DataContratacao = dataContratacao;
		TotalVendido = totalVendido;
		Endereco = endereco;
		Password = passowrd;
	}

	public String getIdVendedor() {
		return IdVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		IdVendedor = idVendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getDataContratacao() {
		return DataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		DataContratacao = dataContratacao;
	}

	public String getTotalVendido() {
		return TotalVendido;
	}

	public void setTotalVendido(String totalVendido) {
		TotalVendido = totalVendido;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
