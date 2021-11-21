package dad.login;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LoginController controller = new LoginController();

		Scene scene = new Scene(controller.getView(), 480, 300);
		
		primaryStage.setTitle("Iniciar sesion");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
