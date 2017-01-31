package Controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	
	private Stage stage;
    private BorderPane mainLayout;
	
	public static void main(String[] args) {
		// Launching the application:
		launch(args);
	}

	@Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("English Project App");

        initRootLayout();
    }
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        // Creating main layout
		mainLayout = new BorderPane();
		
		/*
		 * BorderPane = BorderLayout in Swing
		 * HBox/VBox = align horizontally or vertically
		 * example: mainLayout.setTop(addHBox()); // setLeft(), setCenter(), setRight() (scroll down for adding methods)
		 * 		also: addGridPane(), addFlowPane()
		 */

		// Show the scene containing the main layout.
		Scene scene = new Scene(mainLayout, 800, 500);
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
    
    
    // Check out: http://docs.oracle.com/javafx/2/layout/builtin_layouts.htm#CHDGHCDG
    /*
     public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");
	
	    Button buttonCurrent = new Button("Current");
	    buttonCurrent.setPrefSize(100, 20);
	
	    Button buttonProjected = new Button("Projected");
	    buttonProjected.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);
	
	    return hbox;
	}*/
	
}
