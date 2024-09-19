package packageController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import packageContole.ClienteDAO;
import packageContole.CompraDAO;
import packageContole.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Compra;
import packageModel.Produto;
import packageController.controllerLogin;

public class controllerRegistrarCompra implements Initializable {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnClientes;

	@FXML
	private Button btnFornecedores;

	@FXML
	private Button btnMenu;

	@FXML
	private Button btnPesquisar;

	@FXML
	private Button btnProdutos;

	@FXML
	private Button btnRegistrarVenda;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnVendedores;

	@FXML
	private Button btnVoltar;

	@FXML
	private TableColumn<Produto, String> columnIdProduto;

	@FXML
	private TableColumn<Produto, String> columnNomeProduto;

	@FXML
	private TableColumn<Produto, String> columnPrecoProduto;

	@FXML
	private TableView<Produto> tableRegistrarRelatorio;

	@FXML
	private TextField txtIdCliente;

	@FXML
	private TextField txtCodigoProduto;

	@FXML
	private TextField txtCpfCnpjCliente;

	@FXML
	private TextField txtCpfVendedor;

	@FXML
	private TextField txtDescontoProduto;

	@FXML
	private TextField txtIdVendedor;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private TextField txtNomeProduto;

	@FXML
	private TextField txtNomeVendedor;

	@FXML
	private TextField txtPrecoTotalProduto;

	@FXML
	private TextField txtPrecoUnitarioProduto;

	@FXML
	private TextField txtQuantidadeProduto;

	Produto produto = new Produto();
	ArrayList<Cliente> clienteArray = new ArrayList<>();
	Cliente cliente = new Cliente();
	private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produtoDao = new ProdutoDAO();
	private ClienteDAO clienteDao = new ClienteDAO();

	@FXML
	void btnCancelarAction(ActionEvent event) {

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();

	}

	@FXML
	void btnPesquisarAction(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDao.search(txtNomeProduto.getText()));
		columnIdProduto.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
		columnNomeProduto.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnPrecoProduto.setCellValueFactory(new PropertyValueFactory<>("PrecoUnitario"));

		tableRegistrarRelatorio.setItems(ArrayProduto);
	}

	@FXML
	void btnSalvarAction(ActionEvent event) {

		if (cliente != null && produto != null && txtIdVendedor != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso
					.setContentText("Deseja realmente Salvar a venda para o vendedor : " + txtNomeVendedor.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setIdCliente(cliente.getIdCliente());
				compra.setIdVendedor(txtIdVendedor.getText());
				compra.setIdProduto(produto.getIdProduto());
				compra.setQuantidade(txtQuantidadeProduto.getText());
				compra.setPrecoTotal(txtPrecoTotalProduto.getText());
				compraDAO.create(compra);
				txtIdCliente.setText("");
				txtNomeCliente.setText("");
				txtCpfCnpjCliente.setText("");
				txtCodigoProduto.setText("");
				txtNomeProduto.setText("");
				txtQuantidadeProduto.setText("");
				txtPrecoUnitarioProduto.setText("");
				txtPrecoTotalProduto.setText("");
				txtDescontoProduto.setText("");
				cliente = null;
			}
		} else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
		}

	}

	public void carregarTable() {

		ArrayProduto = FXCollections.observableArrayList(produtoDao.read());
		columnIdProduto.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
		columnNomeProduto.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnPrecoProduto.setCellValueFactory(new PropertyValueFactory<>("PrecoUnitario"));

		tableRegistrarRelatorio.setItems(ArrayProduto);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTable();
		cliente = null;

		txtIdVendedor.setText(controllerLogin.vendedor.getIdVendedor());
		txtCpfVendedor.setText(controllerLogin.vendedor.getCpf());
		txtNomeVendedor.setText(controllerLogin.vendedor.getNome());
		txtQuantidadeProduto.setText("0");

		tableRegistrarRelatorio.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tableRegistrarRelatorio.getSelectionModel().getSelectedIndex();
				produto = tableRegistrarRelatorio.getItems().get(i);
				txtCodigoProduto.setText(produto.getCodigo());
				txtPrecoUnitarioProduto.setText(produto.getPrecoUnitario());
				txtNomeProduto.setText(produto.getNome());
			}
		});
	}
	
	@FXML
    void definirPrecoTotal(KeyEvent event) {
    	if(txtQuantidadeProduto.getText() != "" && txtQuantidadeProduto.getText()!= null) {
   
    	double quantidade = Double.parseDouble(txtQuantidadeProduto.getText());
    	
    	if(quantidade < 30) {
    	txtDescontoProduto.setText("");
    	double precoTotal = Double.parseDouble(txtPrecoUnitarioProduto.getText())* Double.parseDouble(txtQuantidadeProduto.getText());
    	txtPrecoTotalProduto.setText(Double.toString(precoTotal));
    	
    	}else {
    		
    		double precoTotal = (Double.parseDouble(txtPrecoUnitarioProduto.getText())* Double.parseDouble(txtQuantidadeProduto.getText()));
    		precoTotal = precoTotal * 0.85;
    		txtPrecoTotalProduto.setText(Double.toString(precoTotal));
    		Double desconto = precoTotal * 0.15;
    		txtDescontoProduto.setText(Double.toString(desconto));
    		
    		}
    	}
    }

	@FXML
	void definirCliente(KeyEvent evente) {
		if (clienteDao.search(txtCpfCnpjCliente.getText()) != null) {
			clienteArray = clienteDao.search(txtCpfCnpjCliente.getText());
			cliente = clienteArray.get(0);
			txtIdCliente.setText(cliente.getIdCliente());
			txtNomeCliente.setText(cliente.getNome());
		}

	}
}
