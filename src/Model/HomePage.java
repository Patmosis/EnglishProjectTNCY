package Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HomePage extends BorderPane {
	
	public HomePage(final Menu menu) {
		// Title of the application
		Text title = new Text("Words and the world");// Around the world
		title.setFont(Font.loadFont("file:src/resources/fonts/Precious.ttf", 60));
		title.setFill(Color.color(0, 0, 0.25));
		title.setTranslateY(50);
		
		StackPane titlePane = new StackPane();
		titlePane.getChildren().add(title);
		StackPane.setAlignment(title, Pos.CENTER);
		
		setTop(titlePane);   
		
		
		// Description of the application
		Label description = new Label("Welcome on our application designed to help you learn a bit more about the history of the British Empire and differences in dialects of English.");
		
		description.getStyleClass().add("appDescription");
		
		description.setMaxWidth(700);
		description.setWrapText(true);
		description.setTextAlignment(TextAlignment.CENTER);
		
		setCenter(description);
		
		
		// Tab buttons
		HBox accessButtons = new HBox();
		accessButtons.getStyleClass().add("accessButtons");
		accessButtons.setAlignment(Pos.CENTER);
		accessButtons.setSpacing(50);

		
		Button history = new Button();
		history.getStyleClass().add("homeButtons");
		Image britannia = new Image("resources/images/britannia.jpg");
		ImageView britanniaView = new ImageView(britannia);
		britanniaView.getStyleClass().add("homePictures");
		britanniaView.setFitHeight(150);
		britanniaView.setPreserveRatio(true);
		history.setGraphic(britanniaView);
		history.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	menu.setHistory();
            }
        });
		
		Button language = new Button();
		language.getStyleClass().add("homeButtons");
		Image speaking = new Image("resources/images/english_speaking.png");
		ImageView speakingView = new ImageView(speaking);
		speakingView.getStyleClass().add("homePictures");
		speakingView.setFitHeight(150);
		speakingView.setPreserveRatio(true);
		language.setGraphic(speakingView);
		language.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	menu.setLanguage();
            }
        });
		
		accessButtons.getChildren().add(history);
		accessButtons.getChildren().add(language);
				
		StackPane bottomPane = new StackPane();
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().add(accessButtons);
		
		setBottom(bottomPane);
	}

}
