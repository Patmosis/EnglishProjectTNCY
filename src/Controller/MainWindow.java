package Controller;


import Model.*;
import View.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main window class
 * @author gauthier
 *
 */
public class MainWindow {

	// Application main frame/stage
	private Stage stage;
	
	public MainWindow(Stage s, String urlStyle) {
		// Defines stage
        this.stage = s;
        this.stage.setTitle("English Project App");
        
        // Suppresses window's borders
        this.stage.initStyle(StageStyle.UNDECORATED);

        // Defines main layout and scene
        BorderPane mainLayout = new BorderPane();
        AppButton button = new AppButton("x");  // Example button ; closes window on click
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        mainLayout.setCenter(button);
        mainLayout.setTop(new Menu());
        MainScene scene = new MainScene(mainLayout, 800, 600);

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
