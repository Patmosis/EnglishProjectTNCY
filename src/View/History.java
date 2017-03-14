package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class History extends BorderPane {
	
	private static int nbPages = 15;
	private int numPage = 0;
	private Label title = new Label();
	private VBox content = new VBox();
	private StackPane change = new StackPane();
	private Button prev = new Button("🢀");
	private Button next = new Button("🢂");
	/*private Button start;*/
	
	
	public History(int numPage) {
		initialize();
	}
	
	
	public void initialize() {
		getChildren().removeAll();
		
		prev.getStyleClass().add("backButton");
		next.getStyleClass().add("backButton");
		
		prev.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	numPage--;
            	initialize();
            }
        });
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				numPage++;
				initialize();
			}
		});
		
		
		if(numPage == 0) {
			
			Button start = new Button("start");
			start.getStyleClass().add("startButton");
			
			start.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					numPage++;
					initialize();
				}
			});
			
			change.getChildren().add(start);
			StackPane.setAlignment(start, Pos.BOTTOM_CENTER);
		
		}
		
		if(numPage == 1) {
			
			next.getStyleClass().add("backButton");

			change.getChildren().add(next);
			StackPane.setAlignment(next, Pos.BOTTOM_RIGHT);

		}
		
		if(numPage < nbPages && numPage > 1) {

			change.getChildren().add(next);
			StackPane.setAlignment(next, Pos.BOTTOM_RIGHT);

			change.getChildren().add(prev);
			StackPane.setAlignment(prev, Pos.BOTTOM_LEFT);
			

		}
		
		
		if(numPage == nbPages) {

			change.getChildren().add(prev);
			StackPane.setAlignment(prev, Pos.BOTTOM_LEFT);
			
		}
					
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		
		setTop(title);
		setCenter(content);
		setBottom(change);
		
	}
	
}
