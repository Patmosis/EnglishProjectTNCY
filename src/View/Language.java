package View;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Language extends BorderPane {
	
	public Language() {
		initialize();
	}
	
	/**
	 * Initializes language pane
	 */
	private void initialize() {
		setCenter(new Label("Language"));
	}
	
}
