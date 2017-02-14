package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Main pane of the language learning part of the application
 * @author nicolas
 *
 */
public class Language extends BorderPane {
	
	public Language() {
		initialize();
	}
	
	/**
	 * Initializes language pane
	 */
	private void initialize() {
		// TODO Create language pane
		setTop(new Label("How English is English?"));
	}
	
}
