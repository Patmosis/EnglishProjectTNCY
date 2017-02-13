package Model;

import View.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu extends GridPane {
	
	private Button language = new Button("Language");
	private Button history = new Button("History");
	private Button closingButton = new Button(" x ");

	public Menu(final BorderPane mainLayout, final Stage stage) {
		setHgap(260);

		// Sets default text on opening application
		mainLayout.setCenter(new Label("Welcome on our app!"));
		
		// Sets language button properties
	    language.setMinWidth(250);
	    language.setAlignment(Pos.CENTER);
	    language.getStyleClass().clear();
	    language.getStyleClass().add("menuButton");
	    
	    // Sets history button properties
	    history.setMinWidth(250);
	    history.setAlignment(Pos.CENTER);
	    history.getStyleClass().clear();
	    history.getStyleClass().add("menuButton");
	    
	    // Sets closing button button properties
	    closingButton.getStyleClass().clear();
	    closingButton.getStyleClass().add("menuButton");
	    
	    closingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
	    
	    language.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //new History(new Stage());
            	mainLayout.setCenter(new Language());
            }
        });
	    
	    history.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //new Language(new Stage());
            	mainLayout.setCenter(new History());
            }
        });
	    
	    // Sets language-history menu part
	    GridPane actualMenu = new GridPane();
	    actualMenu.setHgap(1);
	    actualMenu.add(language, 0, 0);
	    actualMenu.add(history, 1, 0);
	    
	    // Adds nodes to menu
	    add(actualMenu,0,0);    	    
	    add(closingButton, 1, 0);
	}
	
}
