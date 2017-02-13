package View;

import javafx.scene.control.Button;

/**
 * Application buttons
 * @author gauthier
 *
 */
public class AppButton extends Button {

	public AppButton() {
		super();
		getStyleClass().add("appButton");
	}
	
	public AppButton(String text) {
		super(text);
		getStyleClass().add("appButton");
	}
	
}
