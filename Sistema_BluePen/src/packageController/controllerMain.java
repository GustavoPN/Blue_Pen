package packageController;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controllerMain {

    @FXML
    private Button btnButton;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnRegistrarVenda;

    @FXML
    private Button btnRelatorioVendas;

    @FXML
    private Button btnVendedores;

    @FXML
    void btnButtonTest(ActionEvent event) {
    	Main.changeScrenn("login");
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
    void btnProdutosAction(ActionEvent event) {
    	Main.changeScrenn("produto");
    }

    @FXML
    void btnRegistrarVendaAction(ActionEvent event) throws IOException {
    	Main.registrarVenda();
    }

    @FXML
    void btnRelatorioVendasAction(ActionEvent event) {
    	Main.changeScrenn("relatorioVenda");
    }

    @FXML
    void btnVendedoresAction(ActionEvent event) {
    	Main.changeScrenn("Vendedores");
    }

}
