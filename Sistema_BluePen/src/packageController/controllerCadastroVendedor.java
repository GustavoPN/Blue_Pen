package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageContole.VendedorDAO;
import packageModel.Vendedor;

public class controllerCadastroVendedor implements Initializable {
	
	 	@FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private DatePicker dataContratacao;

	    @FXML
	    private DatePicker dataNascimento;

	    @FXML
	    private TextField txtInserirCpfVendedor;

	    @FXML
	    private TextField txtInserirEmailVendedor;

	    @FXML
	    private TextField txtInserirEnderecoVendedor;

	    @FXML
	    private TextField txtInserirNomeVendedor;

	    @FXML
	    private TextField txtInserireTelefoneVendedor;

	    @FXML
	    void btnCancelarAction(ActionEvent event) {
	    	
	    	dataNascimento.setValue(null);
	    	dataContratacao.setValue(null);
	    	txtInserirNomeVendedor.setText("");
	    	txtInserirCpfVendedor.setText("");
	    	txtInserirEmailVendedor.setText("");
	    	txtInserireTelefoneVendedor.setText("");
	    	txtInserirEnderecoVendedor.setText("");
	    	controllerCliente.clienteEditor = null;
	    	
	    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
	    	stage.close();


	    }

	    @FXML
	    void btnSalvarAction(ActionEvent event) {
	    	
	    	if (controllerVendedor.vendedorEditor == null) {
	    		Vendedor vendedor = new Vendedor();
	    		vendedor.setNome(txtInserirNomeVendedor.getText());
	    		vendedor.setCpf(txtInserirCpfVendedor.getText());
	    		vendedor.setEmail(txtInserirEmailVendedor.getText());
	    		vendedor.setTelefone(txtInserireTelefoneVendedor.getText());
	    		vendedor.setEndereco(txtInserirEnderecoVendedor.getText());
	    		vendedor.setDataNascimento(dataNascimento.getValue().toString());
	    		vendedor.setDataContratacao(dataContratacao.getValue().toString());
	    		VendedorDAO vendedorDao = new VendedorDAO();
	    		vendedorDao.create(vendedor);
	        	
	        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
	        	stage.close();
			}else {
				Vendedor vendedor = new Vendedor();
	    		vendedor.setNome(txtInserirNomeVendedor.getText());
	    		vendedor.setCpf(txtInserirCpfVendedor.getText());
	    		vendedor.setEmail(txtInserirEmailVendedor.getText());
	    		vendedor.setTelefone(txtInserireTelefoneVendedor.getText());
	    		vendedor.setEndereco(txtInserirEnderecoVendedor.getText());
	    		vendedor.setDataNascimento(dataNascimento.getValue().toString());
	    		vendedor.setDataContratacao(dataContratacao.getValue().toString());
	    		VendedorDAO vendedorDao = new VendedorDAO();
	    		vendedorDao.update(vendedor);
	        	
	        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
	        	stage.close();
			}

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		if (controllerVendedor.vendedorEditor != null) {
			txtInserirNomeVendedor.setText(controllerVendedor.vendedorEditor.getNome());
			txtInserirCpfVendedor.setText(controllerVendedor.vendedorEditor.getCpf());
			txtInserirEmailVendedor.setText(controllerVendedor.vendedorEditor.getEmail());
			txtInserirEnderecoVendedor.setText(controllerVendedor.vendedorEditor.getEndereco());
			txtInserireTelefoneVendedor.setText(controllerVendedor.vendedorEditor.getTelefone());
			
		}
	}

}
