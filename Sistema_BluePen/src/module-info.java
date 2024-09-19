module Sistema_BluePen {
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	exports packageController;
	exports packageModel;
	exports packageContole;
	
	opens packageController to javafx.fxml;
	
	opens packageModel to javafx.fxml;
	
	opens packageContole to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
