module CrudJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens com.crud to javafx.graphics, javafx.fxml;
}
