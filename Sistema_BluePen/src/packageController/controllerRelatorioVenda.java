package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageContole.CompraDAO;
import packageModel.Cliente;
import packageModel.Compra;

public class controllerRelatorioVenda implements Initializable {
	
	@FXML
    private Button btnCadastrar;

    @FXML
    private Button btnPesquisar;
    
    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnRegistrarVenda;

    @FXML
    private Button btnVendedores;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Compra, String> columnCodigo;

    @FXML
    private TableColumn<Compra, String> columnIdProduto;

    @FXML
    private TableColumn<Compra, String> columnNome;

    @FXML
    private TableColumn<Compra, String> columnPrecoTotal;

    @FXML
    private TableColumn<Compra, String> columnQuantidade;

    @FXML
    private TableColumn<Compra, String> columnVendedor;

    @FXML
    private TableView<Compra> tableViewRelatorioVenda;
    
    @FXML
    private TextField txtFileldPesquisar;
    
   
    private ObservableList<Compra> ArrayCompra;
    private CompraDAO compra = new CompraDAO();
    
    @FXML
    void btnCadastrarAction(ActionEvent event) throws IOException {
    	tableViewRelatorioVenda.refresh();
    	Main.registrarVenda();
    	tableViewRelatorioVenda.refresh();
    	CarregarRelatorio();
    }


    @FXML
    void btnClientesAction(ActionEvent event) {
    	
    	Main.changeScrenn("cliente");

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
    	
    	ArrayCompra = FXCollections.observableArrayList(compra.search(txtFileldPesquisar.getText()));
    	columnIdProduto.setCellValueFactory(new PropertyValueFactory<>("IdCompra"));
    	columnVendedor.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
    	columnNome.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
    	columnCodigo.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("PrecoTotal"));

		
		tableViewRelatorioVenda.setItems(ArrayCompra);
		tableViewRelatorioVenda.refresh();

    }

    @FXML
    void btnProdutosAction(ActionEvent event) {
    	
    	Main.changeScrenn("produto");

    }

    @FXML
    void btnRegistrarVendaAction(ActionEvent event) {
    	tableViewRelatorioVenda.refresh();
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
		CarregarRelatorio();
	}
	
	private void CarregarRelatorio() {
		
		ArrayCompra = FXCollections.observableArrayList(compra.read());
		
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("IdCompra"));
		columnIdProduto.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("PrecoTotal"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columnVendedor.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
		
		tableViewRelatorioVenda.setItems(ArrayCompra);
	}


}
