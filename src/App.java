import java.io.IOException;

import Controller.*;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Launch class
 * @author gauthier
 *
 */
public class App extends Application {
	
	public static void main(String[] args) {
		// Launches the application
		launch(args);
	}
		
	/**
	 * JavaFX start function (overriding)
	 * @throws IOException 
	 */
	@Override
    public void start(Stage stage) throws IOException {
		// Loads CSS properties
		String url = App.class.getResource("resources/style.css").toExternalForm();
		
		// Creates main window
		new MainWindow(stage, url);
    }
		
}
