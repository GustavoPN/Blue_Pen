package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
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
import packageContole.ClienteDAO;
import packageContole.VendedorDAO;
import packageModel.Cliente;
import packageModel.Produto;
import packageModel.Vendedor;

public class controllerVendedor implements Initializable {
	
	 	@FXML
	    private TableView<Vendedor> TableVendedor;

	    @FXML
	    private Button btnCadastrar;

	    @FXML
	    private Button btnClientes;

	    @FXML
	    private Button btnEditar;

	    @FXML
	    private Button btnExcluir;

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
	    private Button btnVendedores;

	    @FXML
	    private Button btnVoltar;

	    @FXML
	    private TableColumn<Vendedor, String> columnCpf;

	    @FXML
	    private TableColumn<Vendedor, String> columnDataContratacao;

	    @FXML
	    private TableColumn<Vendedor, String> columnDataNascimento;

	    @FXML
	    private TableColumn<Vendedor, String> columnEmail;

	    @FXML
	    private TableColumn<Vendedor, String> columnEndereco;

	    @FXML
	    private TableColumn<Vendedor, String> columnId;

	    @FXML
	    private TableColumn<Vendedor, String> columnNome;

	    @FXML
	    private TableColumn<Vendedor, String> columnTelefone;

	    @FXML
	    private TableColumn<Vendedor, String> columnTotalVendido;

	    @FXML
	    private TextField txtBarraParaDigitar;
	    
	    private ObservableList<Vendedor> ArrayVendedor;
	    private VendedorDAO vendedor = new VendedorDAO();
	    public static Vendedor vendedorEditor = new Vendedor();

	    @FXML
	    void btnCadastrarAction(ActionEvent event) throws IOException {
	    	
	    	vendedorEditor = null;
	    	Main.telaCadastroVendedor();
	    	carregarTableVendedor();

	    }

	    @FXML
	    void btnClientesAction(ActionEvent event) {
	    	Main.changeScrenn("cliente");
	    }

	    @FXML
	    void btnEditarAction(ActionEvent event) throws IOException {
	    	
	    	if (TableVendedor.getSelectionModel().getSelectedIndex() == -1) {
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um Vendedor para editar primeiro!");
				mensagemDeErro.show();
			}else {
				int i = TableVendedor.getSelectionModel().getSelectedIndex();
				vendedorEditor = TableVendedor.getItems().get(i);
				Main.telaCadastroVendedor();
			}
	    	
	    	carregarTableVendedor();

	    }

	    @FXML
	    void btnExcluirAction(ActionEvent event) {
	    	
	    	int i = TableVendedor.getSelectionModel().getSelectedIndex();
	    	
	    	if (i == -1) {
	    		
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um vendedor primeiro!");
				mensagemDeErro.show();
				
			}else {
				
				Vendedor vendedor = new Vendedor();
				vendedor = TableVendedor.getItems().get(i);
				
				Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
				mensagemDeAviso.setContentText("Deseja realmente excluir o vendedor: " + vendedor.getNome());
				
				Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
				
				if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
					VendedorDAO vendedorDao = new VendedorDAO();
					vendedorDao.delete(vendedor.getCpf());
					
					Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
					mensagemDeExclusao.setContentText("Vendedor excluido com sucesso!");
					mensagemDeExclusao.show();
					carregarTableVendedor();
				}
			}


	    }

	    @FXML
	    void btnFornecedoresAction(ActionEvent event) {
	    	Main.changeScrenn("fornecedor");
	    }

	    @FXML
	    void btnMenuAction(ActionEvent event) {
	    	Main.changeScrenn("main");
	    }

	    @FXML
	    void btnPesquisarAction(ActionEvent event) {
	    	
	    	ArrayVendedor = FXCollections.observableArrayList(vendedor.search(txtBarraParaDigitar.getText()));
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
			columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimento"));
			columnDataContratacao.setCellValueFactory(new PropertyValueFactory<>("DataContratacao"));
			columnTotalVendido.setCellValueFactory(new PropertyValueFactory<>("TotalVendido"));
			columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			
			TableVendedor.setItems(ArrayVendedor);
			TableVendedor.refresh();

	    }

	    @FXML
	    void btnProdutosAction(ActionEvent event) {
	    	Main.changeScrenn("produto");
	    }

	    @FXML
	    void btnRegistrarVendaAction(ActionEvent event) {
	    	Main.changeScrenn("relatorioVenda");
	    }

	    @FXML
	    void btnVendedoresAction(ActionEvent event) {
	    	TableVendedor.refresh();
	    	carregarTableVendedor();
	    }

	    @FXML
	    void btnVoltarAction(ActionEvent event) {
	    	Main.changeScrenn("main");
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			carregarTableVendedor();
		}
		
		public void carregarTableVendedor() {
			ArrayVendedor = FXCollections.observableArrayList(vendedor.read());
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
			columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimento"));
			columnDataContratacao.setCellValueFactory(new PropertyValueFactory<>("DataContratacao"));
			columnTotalVendido.setCellValueFactory(new PropertyValueFactory<>("TotalVendido"));
			columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			
			TableVendedor.setItems(ArrayVendedor);
			
		}

}
