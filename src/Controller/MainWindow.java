package Controller;


import View.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main window class
 * @author gauthier
 *
 */
public class MainWindow {

	// Application main frame/stage
	private Stage stage;
	
	public MainWindow(Stage stage, String urlStyle) {
		// Defines stage
        this.stage = stage;
        this.stage.setTitle("English Project App");

        // Defines main layout and scene
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(new AppButton());
        MainScene scene = new MainScene(mainLayout, 800, 500);

        // Sets style sheet and scene
        scene.getStylesheets().add(urlStyle);
		stage.setScene(scene);
		stage.show();
	}

    /**
     * Returns the main stage.
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }
	
}
