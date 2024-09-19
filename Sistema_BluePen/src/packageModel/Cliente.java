package packageModel;

public class Cliente {
	
	private String IdCliente;
	private String Nome;
	private String CpfCnpj;
	private String Email;
	private String Telefone;
	private String DataNascimento;
	private String DataPrimeiraCompra;
	private String Endereco;
	private String TipoJuridico;
	
	public Cliente() {
		super();
	}

	public Cliente(String idCliente, String nome, String cpfCnpj, String email, String telefone, String dataNascimento,
			String dataPrimeiraCompra, String endereco, String tipoJuridico) {
		super();
		IdCliente = idCliente;
		Nome = nome;
		CpfCnpj = cpfCnpj;
		Email = email;
		Telefone = telefone;
		DataNascimento = dataNascimento;
		DataPrimeiraCompra = dataPrimeiraCompra;
		Endereco = endereco;
		TipoJuridico = tipoJuridico;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpfCnpj() {
		return CpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		CpfCnpj = cpfCnpj;
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

	public String getDataPrimeiraCompra() {
		return DataPrimeiraCompra;
	}

	public void setDataPrimeiraCompra(String dataPrimeiraCompra) {
		DataPrimeiraCompra = dataPrimeiraCompra;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTipoJuridico() {
		return TipoJuridico;
	}

	public void setTipoJuridico(String tipoJuridico) {
		TipoJuridico = tipoJuridico;
	}
	
	
	
}
