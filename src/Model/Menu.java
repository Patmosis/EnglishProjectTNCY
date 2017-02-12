package Model;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane {
	
	private Button language = new Button("Language");
	private Button history = new Button("History");

	public Menu() {
	    setHgap(1);
	    setVgap(2);

	    language.setMinWidth(400);
	    language.setAlignment(Pos.CENTER);
	    language.getStyleClass().clear();
	    language.getStyleClass().add("menuButton");
	    history.setMinWidth(400);
	    history.setAlignment(Pos.CENTER);
	    history.getStyleClass().clear();
	    history.getStyleClass().add("menuButton");
	    
	    GridPane.setHalignment(language, HPos.LEFT);
	    add(language, 0, 0);
	    
	    GridPane.setHalignment(history, HPos.RIGHT);
	    add(history, 1, 0);
	}
	
}
