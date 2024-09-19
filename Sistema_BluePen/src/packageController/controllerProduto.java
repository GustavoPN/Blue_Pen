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

public class controllerProduto implements Initializable {
	
	  	@FXML
	    private TableView<Produto> tableProduto;
	
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
	    private TableColumn<Produto, String> columnCodigo;

	    @FXML
	    private TableColumn<Produto, String> columnDataFabricacao;

	    @FXML
	    private TableColumn<Produto, String> columnDataValidade;

	    @FXML
	    private TableColumn<Produto, String> columnEstoque;

	    @FXML
	    private TableColumn<Produto, String> columnId;

	    @FXML
	    private TableColumn<Produto, String> columnNome;

	    @FXML
	    private TableColumn<Produto, String> columnPrecoUnitario;

	    @FXML
	    private TableColumn<Produto, String> columnTipoUnitario;

	    @FXML
	    private TextField txtBarraParaDigitar;
	    
	    private ObservableList<Produto> ArrayProduto;
	    private ProdutoDAO produto = new ProdutoDAO();
	    public static Produto produtoEditor = new Produto();


	    @FXML
	    void btnCadastrarAction(ActionEvent event) throws IOException {
	    	
	    	produtoEditor = null;
	    	Main.telaCadastroProduto();
	    	carregarTableProduto();

	    }

	    @FXML
	    void btnClientesAction(ActionEvent event) {
	    	Main.changeScrenn("cliente");
	    }

	    @FXML
	    void btnEditarAction(ActionEvent event) throws IOException {
	    	
	    	if (tableProduto.getSelectionModel().getSelectedIndex() == -1) {
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um Produto para editar primeiro!");
				mensagemDeErro.show();
			}else {
				int i = tableProduto.getSelectionModel().getSelectedIndex();
				produtoEditor = tableProduto.getItems().get(i);
				Main.telaCadastroProduto();
			}
	    	
	    	carregarTableProduto();
	    		
	    }

	    @FXML
	    void btnExcluirAction(ActionEvent event) {
	    	
	    	int i = tableProduto.getSelectionModel().getSelectedIndex();
	    	
	    	if (i == -1) {
	    		
				Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeErro.setContentText("Selecione um produto primeiro!");
				mensagemDeErro.show();
				
			}else {
				
				Produto produto = new Produto();
				produto = tableProduto.getItems().get(i);
				
				Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
				mensagemDeAviso.setContentText("Deseja realmente excluir o produto: " + produto.getNome());
				
				Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
				
				if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
					ProdutoDAO produtoDao = new ProdutoDAO();
					produtoDao.delete(produto.getCodigo());
					
					Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
					mensagemDeExclusao.setContentText("Produto excluido com sucesso!");
					mensagemDeExclusao.show();
					carregarTableProduto();
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
	    	
	    	ArrayProduto = FXCollections.observableArrayList(produto.search(txtBarraParaDigitar.getText()));
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
			columnEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
			columnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnitario"));
			columnTipoUnitario.setCellValueFactory(new PropertyValueFactory<>("TipoUnitario"));
			columnDataFabricacao.setCellValueFactory(new PropertyValueFactory<>("DataFabricacao"));
			columnDataValidade.setCellValueFactory(new PropertyValueFactory<>("DataValidade"));
			
			tableProduto.setItems(ArrayProduto);
			tableProduto.refresh();

	    }

	    @FXML
	    void btnProdutosAction(ActionEvent event) {
	    	tableProduto.refresh();
	    	carregarTableProduto();
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
			carregarTableProduto();
		}
		
		public void carregarTableProduto() {
			ArrayProduto = FXCollections.observableArrayList(produto.read());
			columnId.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
			columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			columnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
			columnEstoque.setCellValueFactory(new PropertyValueFactory<>("Estoque"));
			columnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnitario"));
			columnTipoUnitario.setCellValueFactory(new PropertyValueFactory<>("TipoUnitario"));
			columnDataFabricacao.setCellValueFactory(new PropertyValueFactory<>("DataFabricacao"));
			columnDataValidade.setCellValueFactory(new PropertyValueFactory<>("DataValidade"));
			
			tableProduto.setItems(ArrayProduto);
			
		}

}
