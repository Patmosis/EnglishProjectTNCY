package Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu extends GridPane {
	
	private Button language = new Button("Language");
	private Button history = new Button("History");
	private Button closingButton = new Button(" x ");

	public Menu(final Stage stage) {
		setHgap(260);

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
