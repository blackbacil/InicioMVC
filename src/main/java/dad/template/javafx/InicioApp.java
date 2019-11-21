package dad.template.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioApp extends Application {
	
	private InicioController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new InicioController();
		
		Scene escena = new Scene(controller.getRoot(),640,400);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Calculadora FXML");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
