package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import packageConnection.ConnectionDatabase;
import packageContole.ClienteDAO;
import packageContole.FornecedorDAO;
import packageContole.ProdutoDAO;
import packageContole.VendedorDAO;
import packageModel.Cliente;
import packageModel.Fornecedor;
import packageModel.Produto;
import packageModel.Vendedor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	private static Scene login;
	private static Scene main;
	private static Scene vendedor;
	private static Scene cliente;
	private static Scene produto;
	private static Scene fornecedor;
	private static Scene relatorioVenda;
	private static Stage registrarVenda;
	private static Stage cadastroCliente;
	private static Stage cadastroProduto;
	private static Stage cadastroVendedor;
	private static Stage cadastroFornecedor;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			primaryStage.setTitle("Blue Pen");
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/viewLogin.fxml"));
			login = new Scene(fxmlLogin);
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageView/viewMain.fxml"));
			main = new Scene(fxmlMain);
			
			Parent fxmlVendedor = FXMLLoader.load(getClass().getResource("/packageView/viewVendedor.fxml"));
			vendedor = new Scene(fxmlVendedor);
			
			Parent fxmlCliente = FXMLLoader.load(getClass().getResource("/packageView/viewCliente.fxml"));
			cliente = new Scene(fxmlCliente);
			
			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packageView/viewProduto.fxml"));
			produto = new Scene(fxmlProduto);
			
			Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/packageView/viewFornecedor.fxml"));
			fornecedor = new Scene(fxmlFornecedor);
			
			Parent fxmlRelatorioVenda = FXMLLoader.load(getClass().getResource("/packageView/viewRelatorioVenda.fxml"));
			relatorioVenda = new Scene(fxmlRelatorioVenda);
		
			
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/packageIcon/logo.png")));
			stage.setResizable(false);
			
			primaryStage.setScene(login);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScrenn(String tela) {
		if (tela.equals("login")) {
			stage.setScene(login);
			stage.centerOnScreen();
		}else if(tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
		}else if(tela.equals("Vendedores")) {
			stage.setScene(vendedor);
			stage.centerOnScreen();
		}else if(tela.equals("cliente")) {
			stage.setScene(cliente);
			stage.centerOnScreen();
		}else if(tela.equals("produto")) {
			stage.setScene(produto);
			stage.centerOnScreen();
		}else if(tela.equals("fornecedor")) {
			stage.setScene(fornecedor);
			stage.centerOnScreen();
		}else if(tela.equals("relatorioVenda")) {
			stage.setScene(relatorioVenda);
			stage.centerOnScreen();			
		}
	}
	
	public static void telaCadastroCliente() throws IOException {
		
		FXMLLoader ClienteCadastro = new FXMLLoader();
		ClienteCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroCliente.fxml"));
		Parent cadCliente = ClienteCadastro.load();
		Scene scene2 = new Scene(cadCliente);
		
		cadastroCliente = new Stage();
		cadastroCliente.setTitle("Cadastro/Edição de Clientes - BLUE PEN");
		cadastroCliente.initModality(Modality.WINDOW_MODAL);
		cadastroCliente.setScene(scene2);
		cadastroCliente.centerOnScreen();
		cadastroCliente.showAndWait();
		
	}
	
	public static void telaCadastroProduto() throws IOException {
		
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroProduto.fxml"));
		Parent cadProduto = ProdutoCadastro.load();
		Scene scene2 = new Scene(cadProduto);
		
		cadastroProduto = new Stage();
		cadastroProduto.setTitle("Cadastro/Edição de Produto - BLUE PEN");
		cadastroProduto.initModality(Modality.WINDOW_MODAL);
		cadastroProduto.setScene(scene2);
		cadastroProduto.centerOnScreen();
		cadastroProduto.showAndWait();
		
	}
	
	public static void telaCadastroVendedor() throws IOException {
		
		FXMLLoader VendedorCadastro = new FXMLLoader();
		VendedorCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroVendedor.fxml"));
		Parent cadVendedor = VendedorCadastro.load();
		Scene scene2 = new Scene(cadVendedor);
		
		cadastroVendedor = new Stage();
		cadastroVendedor.setTitle("Cadastro/Edição de Vendedor - BLUE PEN");
		cadastroVendedor.initModality(Modality.WINDOW_MODAL);
		cadastroVendedor.setScene(scene2);
		cadastroVendedor.centerOnScreen();
		cadastroVendedor.showAndWait();
		
	}
	
	public static void telaCadastroFornecedor() throws IOException {
		
		FXMLLoader ClienteCadastro = new FXMLLoader();
		ClienteCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroFornecedor.fxml"));
		Parent cadCliente = ClienteCadastro.load();
		Scene scene2 = new Scene(cadCliente);
		
		cadastroFornecedor = new Stage();
		cadastroFornecedor.setTitle("Cadastro/Edição de Fornecedor - BLUE PEN");
		cadastroFornecedor.initModality(Modality.WINDOW_MODAL);
		cadastroFornecedor.setScene(scene2);
		cadastroFornecedor.centerOnScreen();
		cadastroFornecedor.showAndWait();
		
	}
	
	public static void registrarVenda() throws IOException {
		
		FXMLLoader RegistrarVenda = new FXMLLoader();
		RegistrarVenda.setLocation(Main.class.getResource("/packageView/viewRegistrarVenda.fxml"));
		Parent cadRegistrarVenda = RegistrarVenda.load();
		Scene scene2 = new Scene(cadRegistrarVenda);
		
		registrarVenda = new Stage();
		registrarVenda.setTitle("Cadastro de Compra - BLUE PEN");
		registrarVenda.initModality(Modality.WINDOW_MODAL);
		registrarVenda.setScene(scene2);
		registrarVenda.centerOnScreen();
		registrarVenda.showAndWait();
		
	}
	
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
//		ArrayList<Fornecedor> fornecedorList = new ArrayList<>();
//		FornecedorDAO fornecedorDao = new FornecedorDAO();
//		Fornecedor novoFornecedor = new Fornecedor();
//		
//		//cliente.delete("76663267183");
//		
//		fornecedorList = fornecedorDao.read();
//		
//		for (int i = 0; i < fornecedorList.size(); i++) {
//			Fornecedor fornecedorArray = fornecedorList.get(i);
//			System.out.println();
//			System.out.print((fornecedorArray.getIdFornecedor() +"| "));
//			System.out.print((fornecedorArray.getNome() + "| "));
//			System.out.print((fornecedorArray.getCNPJ() + "| "));
//			System.out.print((fornecedorArray.getEmail() + "| "));
//			System.out.print((fornecedorArray.getTelefone() + "| "));
//			System.out.print((fornecedorArray.getEndereco() + "| "));
//		
//		}
//			
		
		
		launch(args);
	}
}
