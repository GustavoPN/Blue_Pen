package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import packageContole.VendedorDAO;
import packageModel.Vendedor;

public class controllerLogin {
	

    @FXML
    private ToggleButton VerSenha;

	@FXML
	private Button btnButton;

	@FXML
	private PasswordField txtPassword;
	

    @FXML
    private TextField txtSenha;

	@FXML
	private TextField txtUser;
	
	@FXML
    void visualizarSenha(ActionEvent event) {
		
		if (VerSenha.isSelected()) {
			txtSenha.setText(txtPassword.getText());
			txtPassword.setVisible(false);
			txtSenha.setVisible(true);
		}else {
			txtPassword.setText(txtSenha.getText());
			txtPassword.setVisible(true);
			txtSenha.setVisible(false);
		}

    }

	VendedorDAO vendedorDao = new VendedorDAO();
	public static Vendedor vendedor = new Vendedor();

	@FXML
	void btnButtonTeste(ActionEvent event) {
		txtPassword.setVisible(true);
		vendedor = vendedorDao.autenticarUser(txtUser.getText(), txtPassword.getText());

		if (vendedor.getPassword() != null && vendedor.getCpf() != null) {
			
			Alert saudacao = new Alert(Alert.AlertType.CONFIRMATION);
			saudacao.setHeaderText("Saudações");
			saudacao.setTitle("Bem vindo");
			saudacao.setContentText("Seja bem vindo de volta " + vendedor.getNome() + "!");
			saudacao.show();

			Main.changeScrenn("main");

		} else {
			Alert erro = new Alert(Alert.AlertType.ERROR);
			erro.setTitle("Falha ao realizar login!");
			erro.setHeaderText("Erro!");
			erro.setContentText("Usuario ou senha incorretos! verifique as informações.");
			erro.show();
		}

	}

}
