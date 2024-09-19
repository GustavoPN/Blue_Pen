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
import packageContole.FornecedorDAO;
import packageContole.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Fornecedor;
import packageModel.Produto;
import packageModel.Vendedor;

public class controllerFornecedor implements Initializable {
	
    	@FXML
    	private TableView<Fornecedor> tableFornecedor;

	
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
	    private TableColumn<Fornecedor, String> columnCNPJ;

	    @FXML
	    private TableColumn<Fornecedor, String> columnEmail;

	    @FXML
	    private TableColumn<Fornecedor, String> columnEndereco;

	    @FXML
	    private TableColumn<Fornecedor, String> columnId;

	    @FXML
	    private TableColumn<Fornecedor, String> columnNome;

	    @FXML
	    private TableColumn<Fornecedor, String> columnTelefone;

	    @FXML
	    private TextField txtBarraParaDigitar;
	    
	    private ObservableList<Fornecedor> ArrayFornecedor;
	    private FornecedorDAO fornecedor = new FornecedorDAO();
	    public static Fornecedor fornecedorEditor = new Fornecedor();

	    @FXML
	    void btnCadastrarAction(ActionEvent event) throws IOException {
	    	
	    	fornecedorEditor = null;
	    	Main.telaCadastroFornecedor();
	    	carregarTableFornecedor();

	    }

	    @FXML
	    void btnClientesAction(ActionEvent event) {
	    	Main.changeScrenn("cliente");
	    }

	    @FXML
	    void btnEditarAction(ActionEvent event) throws IOException {
	    	
	    	if (tableFornecedor.getSelectionModel().getSelectedIndex() == -1) {
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um Fornecedor para editar primeiro!");
				mensagemDeErro.show();
			}else {
				int i = tableFornecedor.getSelectionModel().getSelectedIndex();
				fornecedorEditor = tableFornecedor.getItems().get(i);
				Main.telaCadastroFornecedor();
			}
	    	carregarTableFornecedor();

	    }

	    @FXML
	    void btnExcluirAction(ActionEvent event) {
	    	
	    	int i = tableFornecedor.getSelectionModel().getSelectedIndex();
	    	
	    	if (i == -1) {
	    		
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um fornecedor primeiro!");
				mensagemDeErro.show();
				
			}else {
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor = tableFornecedor.getItems().get(i);
				
				Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
				mensagemDeAviso.setContentText("Deseja realmente excluir o fornecedor: " + fornecedor.getNome());
				
				Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
				
				if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
					FornecedorDAO fornecedorDao = new FornecedorDAO();
					fornecedorDao.delete(fornecedor.getCNPJ());
					
					Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
					mensagemDeExclusao.setContentText("Fornecedor excluido com sucesso!");
					mensagemDeExclusao.show();
					carregarTableFornecedor();
				}
			}


	    }

	    @FXML
	    void btnFornecedoresAction(ActionEvent event) {
	    	tableFornecedor.refresh();
	    	carregarTableFornecedor();
	    }

	    @FXML
	    void btnMenuAction(ActionEvent event) {
	    	Main.changeScrenn("main");
	    }

	    @FXML
	    void btnPesquisarAction(ActionEvent event) {
	    	
	    	ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(txtBarraParaDigitar.getText()));
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdFornecedor"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
			columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			
			tableFornecedor.setItems(ArrayFornecedor);
			tableFornecedor.refresh();

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
	    	Main.changeScrenn("Vendedores");
	    }

	    @FXML
	    void btnVoltarAction(ActionEvent event) {
	    	Main.changeScrenn("main");
	    }
	    
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	// TODO Auto-generated method stub
	    	carregarTableFornecedor();
	    }
	    
	    public void carregarTableFornecedor() {
			ArrayFornecedor = FXCollections.observableArrayList(fornecedor.read());
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdFornecedor"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
			columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
			
			tableFornecedor.setItems(ArrayFornecedor);
			
		}


}
