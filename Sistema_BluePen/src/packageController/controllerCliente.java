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
import packageModel.Vendedor;

public class controllerCliente implements Initializable {
	
	@FXML
	private TableView<Cliente> tableCliente;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnEditarAction;

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
    private TableColumn<Cliente, String> columnCpfCnpj;

    @FXML
    private TableColumn<Cliente, String> columnDataNascimento;

    @FXML
    private TableColumn<Cliente, String> columnDataPrimeiraCompra;

    @FXML
    private TableColumn<Cliente, String> columnEmail;

    @FXML
    private TableColumn<Cliente, String> columnEndereco;

    @FXML
    private TableColumn<Cliente, String> columnId;

    @FXML
    private TableColumn<Cliente, String> columnNome;

    @FXML
    private TableColumn<Cliente, String> columnTelefone;

    @FXML
    private TableColumn<Cliente, String> columnTipoJuridico;

    @FXML
    private TextField txtBarraParaDigitar;
    
    private ObservableList<Cliente> ArrayCliente;
    private ClienteDAO cliente = new ClienteDAO();
    public static Cliente clienteEditor = new Cliente();

    @FXML
    void btnCadastrarAction(ActionEvent event) throws IOException {
    	
    	clienteEditor = null;
    	Main.telaCadastroCliente();
    	carregarTableCliente();

    }

    @FXML
    void btnClientesAction(ActionEvent event) {
    	
    	tableCliente.refresh();
    	carregarTableCliente();

    }

    @FXML
    void btnEditarAction(ActionEvent event) throws IOException {
    	
    	if (tableCliente.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Cliente para editar primeiro!");
			mensagemDeErro.show();
		}else {
			int i = tableCliente.getSelectionModel().getSelectedIndex();
			clienteEditor = tableCliente.getItems().get(i);
			Main.telaCadastroCliente();
		}
    	
    	carregarTableCliente();

    }

    @FXML
    void btnExcluirAction(ActionEvent event) {
    	
    	int i = tableCliente.getSelectionModel().getSelectedIndex();
    	
    	if (i == -1) {
    		
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro!");
			mensagemDeErro.show();
			
		}else {
			
			Cliente cliente = new Cliente();
			cliente = tableCliente.getItems().get(i);
			
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o cliente: " + cliente.getNome());
			
			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
			
			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO clienteDao = new ClienteDAO();
				clienteDao.delete(cliente.getCpfCnpj());
				
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Cliente excluido com sucesso!");
				mensagemDeExclusao.show();
				carregarTableCliente();
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
    	
    	ArrayCliente = FXCollections.observableArrayList(cliente.search(txtBarraParaDigitar.getText()));
		columnId.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCpfCnpj.setCellValueFactory(new PropertyValueFactory<>("CpfCnpj"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimento"));
		columnDataPrimeiraCompra.setCellValueFactory(new PropertyValueFactory<>("DataPrimeiraCompra"));
		columnTipoJuridico.setCellValueFactory(new PropertyValueFactory<>("TipoJuridico"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		
		tableCliente.setItems(ArrayCliente);
		tableCliente.refresh();

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
		carregarTableCliente();
	}
	
	public void carregarTableCliente() {
		ArrayCliente = FXCollections.observableArrayList(cliente.read());
		columnId.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCpfCnpj.setCellValueFactory(new PropertyValueFactory<>("CpfCnpj"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimento"));
		columnDataPrimeiraCompra.setCellValueFactory(new PropertyValueFactory<>("DataPrimeiraCompra"));
		columnTipoJuridico.setCellValueFactory(new PropertyValueFactory<>("TipoJuridico"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		
		tableCliente.setItems(ArrayCliente);
		
	}

}
