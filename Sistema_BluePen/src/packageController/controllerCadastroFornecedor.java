package packageController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageContole.FornecedorDAO;
import packageModel.Fornecedor;

public class controllerCadastroFornecedor {
	

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtInserirCnpjFornecedor;

    @FXML
    private TextField txtInserirEmailFornecedor;

    @FXML
    private TextField txtInserirEnderecoFornecedor;

    @FXML
    private TextField txtInserirNomeFornecedor;

    @FXML
    private TextField txtInserirTelefoneFornecedor;

    @FXML
    void btnCancelarAction(ActionEvent event) {
    	
    	txtInserirNomeFornecedor.setText("");
    	txtInserirCnpjFornecedor.setText("");
    	txtInserirEmailFornecedor.setText("");
    	txtInserirTelefoneFornecedor.setText("");
    	txtInserirEnderecoFornecedor.setText("");
    	controllerCliente.clienteEditor = null;
    	
    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void btnSalvarAction(ActionEvent event) {
    	
    	if (controllerFornecedor.fornecedorEditor == null) {
    		Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(txtInserirNomeFornecedor.getText());
    		fornecedor.setCNPJ(txtInserirCnpjFornecedor.getText());
        	fornecedor.setEmail(txtInserirEmailFornecedor.getText());
        	fornecedor.setTelefone(txtInserirTelefoneFornecedor.getText());
        	fornecedor.setEndereco(txtInserirEnderecoFornecedor.getText());
        	FornecedorDAO fornecedorDao = new FornecedorDAO();
        	fornecedorDao.create(fornecedor);
        	
        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
        	stage.close();
		}else {
			Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(txtInserirNomeFornecedor.getText());
    		fornecedor.setCNPJ(txtInserirCnpjFornecedor.getText());
        	fornecedor.setEmail(txtInserirEmailFornecedor.getText());
        	fornecedor.setTelefone(txtInserirTelefoneFornecedor.getText());
        	fornecedor.setEndereco(txtInserirEnderecoFornecedor.getText());
        	FornecedorDAO fornecedorDao = new FornecedorDAO();
        	fornecedorDao.update(fornecedor);
        	
        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
        	stage.close();
		}
    		

    }

}
