module com.example.javafxapplication {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires net.synedra.validatorfx;
	requires java.sql;

	opens javaFX to javafx.fxml;
	exports javaFX;
}