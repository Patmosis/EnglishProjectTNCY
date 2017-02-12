package View;

import javafx.scene.control.Button;

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
