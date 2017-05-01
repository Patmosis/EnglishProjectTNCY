package Controller;


import Model.*;
import View.*;
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
        this.stage = s;
        
        // Defines main layout and scene
        BorderPane mainPane = new BorderPane();
        Menu menu = new Menu(mainPane, stage);
        mainPane.setTop(menu);
        mainPane.getStyleClass().add("mainPane");
        // Sets default text on opening application
        mainPane.setCenter(new HomePage(menu));//(new Label("Welcome to our app!"));
        MainScene scene = new MainScene(mainPane, 1000, 700);

        // Sets style sheet and scene
        scene.getStylesheets().add(urlStyle);
		stage.setScene(scene);
		
		setStageStyle();
		
		stage.show();
	}

    /**
     * Return the main stage.
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }
    
    /**
     * Set application stage style
     */
    private void setStageStyle() {
    	// Sets stage title (useless as we then suppress borders)
    	this.stage.setTitle("English Project App");
        
        // Suppresses window's borders
        this.stage.initStyle(StageStyle.UNDECORATED);
    	
    	// Only way I found to prevent resizing
    	this.stage.setMaxWidth(1000);
    	this.stage.setMaxHeight(700);
    	this.stage.setMinWidth(1000);
    	this.stage.setMinHeight(700);
    }
	
}
