package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageContole.ClienteDAO;
import packageModel.Cliente;

public class controllerCadastroCliente implements Initializable{
	

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private ChoiceBox<String> chBoxInserireTipoJuridicoCliente;

    @FXML
    private DatePicker dataNascimento;
    
    @FXML
    private DatePicker dataPrimeiraCompra;

    @FXML
    private TextField txtInserirCpfCliente;

    @FXML
    private TextField txtInserirEmailCliente;

    @FXML
    private TextField txtInserirEnderecoCliente;

    @FXML
    private TextField txtInserirNomeCliente;

    @FXML
    private TextField txtInserireTelefoneCliente;

    @FXML
    void btnCancelarAction(ActionEvent event) {
    	
    	dataNascimento.setValue(null);
    	txtInserirNomeCliente.setText("");
    	txtInserirCpfCliente.setText("");
    	txtInserirEmailCliente.setText("");
    	txtInserireTelefoneCliente.setText("");
    	chBoxInserireTipoJuridicoCliente.setValue(null);
    	controllerCliente.clienteEditor = null;
    	
    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void btnSalvarAction(ActionEvent event) {
    	
    	if (controllerCliente.clienteEditor == null) {
    		Cliente cliente = new Cliente();
        	cliente.setNome(txtInserirNomeCliente.getText());
        	cliente.setCpfCnpj(txtInserirCpfCliente.getText());
        	cliente.setEmail(txtInserirEmailCliente.getText());
        	cliente.setTelefone(txtInserireTelefoneCliente.getText());
        	cliente.setEndereco(txtInserirEnderecoCliente.getText());
        	cliente.setDataNascimento(dataNascimento.getValue().toString());
        	cliente.setDataPrimeiraCompra(dataPrimeiraCompra.getValue().toString());
        	cliente.setTipoJuridico(chBoxInserireTipoJuridicoCliente.getValue().toString());
        	ClienteDAO clienteDao = new ClienteDAO();
        	clienteDao.create(cliente);
        	
        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
        	stage.close();
		}else {
			Cliente cliente = new Cliente();
        	cliente.setNome(txtInserirNomeCliente.getText());
        	cliente.setCpfCnpj(txtInserirCpfCliente.getText());
        	cliente.setEmail(txtInserirEmailCliente.getText());
        	cliente.setTelefone(txtInserireTelefoneCliente.getText());
        	cliente.setEndereco(txtInserirEnderecoCliente.getText());
        	cliente.setDataNascimento(dataNascimento.getValue().toString());
        	cliente.setDataPrimeiraCompra(dataPrimeiraCompra.getValue().toString());
        	cliente.setTipoJuridico(chBoxInserireTipoJuridicoCliente.getValue().toString());
        	ClienteDAO clienteDao = new ClienteDAO();
        	clienteDao.update(cliente);
        	
        	Stage stage = (Stage) btnCancelar.getScene().getWindow();
        	stage.close();
		}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		chBoxInserireTipoJuridicoCliente.getItems().add("PF");
		chBoxInserireTipoJuridicoCliente.getItems().add("PJ");
		
		if (controllerCliente.clienteEditor != null) {
			txtInserirNomeCliente.setText(controllerCliente.clienteEditor.getNome());
			txtInserirCpfCliente.setText(controllerCliente.clienteEditor.getCpfCnpj());
			txtInserirEmailCliente.setText(controllerCliente.clienteEditor.getEmail());
			txtInserirEnderecoCliente.setText(controllerCliente.clienteEditor.getEndereco());
			txtInserireTelefoneCliente.setText(controllerCliente.clienteEditor.getTelefone());
		}
	}


}
