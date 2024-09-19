package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageContole.FornecedorDAO;
import packageContole.ProdutoDAO;
import packageModel.Produto;

public class controllerCadastroProduto implements Initializable{
	
	 	@FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private DatePicker dataFabricacao;

	    @FXML
	    private DatePicker dataValidade;
	    
	    @FXML
	    private TextField txtInserirCodicoProduto;

	    @FXML
	    private TextField txtInserirEstoqueProduto;

	    @FXML
	    private ChoiceBox<String> txtInserirFornecedorProduto;

	    @FXML
	    private TextField txtInserirNomeProduto;

	    @FXML
	    private TextField txtInserirTipoUnProduto;

	    @FXML
	    private TextField txtInserirePrecoUnProduto;

	    @FXML
	    void btnCancelarAction(ActionEvent event) {
	    	
	    	dataFabricacao.setValue(null);
	    	dataValidade.setValue(null);
	    	txtInserirCodicoProduto.setText("");
	    	txtInserirEstoqueProduto.setText("");
	    	txtInserirNomeProduto.setText("");
	    	txtInserirTipoUnProduto.setText("");
	    	txtInserirePrecoUnProduto.setText("");
	    	controllerProduto.produtoEditor = null;
	    	
	    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
	    	stage.close();


	    }

	    @FXML
	    void btnSalvarAction(ActionEvent event) {
	    	
	    	if (controllerProduto.produtoEditor == null) {
				Produto produto = new Produto();
				produto.setNome(txtInserirNomeProduto.getText());
				produto.setCodigo(txtInserirCodicoProduto.getText());
				produto.setTipoUnitario(txtInserirTipoUnProduto.getText());
				produto.setDataFabricacao(dataFabricacao.getValue().toString());
				produto.setDataValidade(dataValidade.getValue().toString());
				produto.setPrecoUnitario(txtInserirePrecoUnProduto.getText());
				produto.setEstoque(txtInserirEstoqueProduto.getText());
				ProdutoDAO produtoDao = new ProdutoDAO();
				produtoDao.create(produto);
				Stage stage = (Stage) btnCancelar.getScene().getWindow();
				stage.close();
			}else {
				Produto produto = new Produto();
				produto.setNome(txtInserirNomeProduto.getText());
				produto.setCodigo(txtInserirCodicoProduto.getText());
				produto.setTipoUnitario(txtInserirTipoUnProduto.getText());
				produto.setDataFabricacao(dataFabricacao.getValue().toString());
				produto.setDataValidade(dataValidade.getValue().toString());
				produto.setPrecoUnitario(txtInserirePrecoUnProduto.getText());
				produto.setEstoque(txtInserirEstoqueProduto.getText());
				ProdutoDAO produtoDao = new ProdutoDAO();
				produtoDao.update(produto);
				Stage stage = (Stage) btnCancelar.getScene().getWindow();
				stage.close();
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			txtInserirFornecedorProduto.setItems(fornecedorDao.readNome());
			
			if (controllerProduto.produtoEditor != null) {
				txtInserirNomeProduto.setText(controllerCliente.clienteEditor.getNome());
				txtInserirCodicoProduto.setText(controllerCliente.clienteEditor.getCpfCnpj());
				txtInserirTipoUnProduto.setText(controllerCliente.clienteEditor.getEmail());
				txtInserirePrecoUnProduto.setText(controllerCliente.clienteEditor.getEndereco());
				txtInserirEstoqueProduto.setText(controllerCliente.clienteEditor.getTelefone());
				//dataNascimento.setValue(controllerCliente.clienteEditor.getDataNascimento());
			}
		}


}
