package View;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class History extends BorderPane {
	
	public History() {
		initialize();
	}
	
	/**
	 * Initializes history pane
	 */
	private void initialize() {
		setCenter(new Label("History"));
	}
	
}
