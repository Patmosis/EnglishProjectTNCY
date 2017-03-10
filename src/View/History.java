package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * Main pane of the history part of the application
 * @author nicolas
 *
 */
public class History extends BorderPane {
	
	private static int nbPages = 15;
	private int numPage;
	
	public History(int num) {
		numPage = num;
		initialize();
	}
	
	/**
	 * Initializes history pane
	 **/
	
	private void initialize() {
		
		VBox contenu = new VBox();
		Label title = new Label("titre de la 'diapo'");
		StackPane change = new StackPane();
		
		if(numPage >= 0) {
			/*Image fg = new Image("resources/Images/flechegauche.jpg");
			ImageView flecheG = new ImageView(fg);*/
			Button prev = new Button("🢀");
			prev.getStyleClass().add("backButton");
			/*prev.setGraphic(flecheG);*/
			change.getChildren().add(prev);
			StackPane.setAlignment(prev, Pos.BOTTOM_LEFT);
		}
		
		if(numPage < nbPages) {
			/*Image fd = new Image("resources/Images/flechedroite.jpg");
			ImageView flecheD = new ImageView(fd);*/
			Button next = new Button("next");
			next.getStyleClass().add("backButton");
			/*next.setGraphic(flecheD);*/
			change.getChildren().add(next);
			StackPane.setAlignment(next, Pos.BOTTOM_RIGHT);
		}
		
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		
		setBottom(change);
		setTop(title);
		setCenter(contenu);
		
	}
	
}
