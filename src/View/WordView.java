package View;

import java.io.FileInputStream;

import java.util.ArrayList;

import Model.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javazoom.jl.player.Player;

public class WordView extends BorderPane {
	
	private ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
	private Label word;
	private Label meaning;
	private VBox vbox;
	private HBox hbox;

	
	public WordView(Data data, String country) {
		
	    this.setPadding(new Insets(0, 10, 0, 10));
		words = data.get(country);
		
		final int randomNumber = (int) (Math.random()*words.size());
		
		hbox = new HBox();
		vbox = new VBox();
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(20);

	    word = new Label(words.get(randomNumber).get(0));
	    hbox.getChildren().add(word);
	    
	    Button play = new Button("Play");
	    play.getStyleClass().add("appButton");
	    play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	try {
        	        FileInputStream fis = new FileInputStream("src/resources/" + words.get(randomNumber).get(2));
        	        Player playMP3 = new Player(fis);

        	        playMP3.play();

        	    } catch (Exception exception) {System.out.println(exception);}
            }
        });
	    hbox.getChildren().add(play);
	    hbox.setAlignment(Pos.CENTER);
	    hbox.setSpacing(20);
	    vbox.getChildren().add(hbox);
	    GridPane.setValignment(word, VPos.CENTER);
	    
	    meaning = new Label(words.get(randomNumber).get(3));

	    Button showMeaning = new Button("Show meaning");
	    showMeaning.getStyleClass().add("appButton");
	    showMeaning.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	showAnswer();
            }
        });
	    vbox.getChildren().add(showMeaning);
	    
	    this.setCenter(vbox);

	    
	}
	
	public void showAnswer() {
		vbox.getChildren().clear();
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(meaning);
	}
	
}
