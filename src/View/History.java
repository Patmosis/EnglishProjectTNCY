package View;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Main pane of the history part of the application
 * @author nicolas
 *
 */
public class History extends BorderPane {
	
	public History() {
		initialize();
	}
	
	/**
	 * Initializes history pane
	 */
	private void initialize() {
		// TODO Create history pane
		setCenter(new Label("History"));
	}
	
}
