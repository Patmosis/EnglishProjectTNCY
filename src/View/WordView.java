package View;

import java.io.FileInputStream;

import java.util.ArrayList;

import Model.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javazoom.jl.player.Player;

/**
 * View of a word: diplay a word considering its country. Also provide a quiz and an example sentence.
 * @author gauthier
 *
 */
public class WordView extends BorderPane {
	
	private ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>();
	private Label wordMeaning;
	private VBox wordAndPlayAndMeaningBox;
	private HBox wordAndPlayBox;
	private int wordNumber = -1;
	private Button[] answers = new Button[3];

	
	public WordView(Data data, String country) {
		
	    this.setPadding(new Insets(0, 10, 0, 10));
		words = data.get(country);
		
		this.nextWord();
	    
	}
	
	/**
	 * Show the meaning of the current word; called when "Show meaning" button is pressed
	 */
	public void showAnswer() {
		
		// Remove "Show meaning" button
		wordAndPlayAndMeaningBox.getChildren().clear();
		
		// Add the actual meaning of the word, along with removed word and play button
		wordAndPlayAndMeaningBox.getChildren().add(wordAndPlayBox);
		wordAndPlayAndMeaningBox.getChildren().add(wordMeaning);
		
		// Set quiz button as disabled; set correct answer's button's background as green
		for (int i=0; i<3; i++) {
			answers[i].setDisable(true);
			if (answers[i].getText().equals(words.get(wordNumber).get(2))) {
				answers[i].getStyleClass().add("rightAnswer");
			}
		}
		
	}
	
	/**
	 * Change view to display another randomly chosen word; called when next button is pressed
	 */
	public void nextWord() {
		
		// Choose a random number different to the previous word's number
		int number = 0;
		while (wordNumber == -1 || wordNumber == (number = (int) (Math.random()*words.size()))) {
			wordNumber = number;
		}
		
		// Saves random number value as the current world's number
		wordNumber = number;		

		// Label show word that is being considered
	    Label word = new Label(words.get(wordNumber).get(0));
	    
	    // Create play button; access mp3 file using JLayer
	    Button play = new Button("▶");
	    play.getStyleClass().add("appButton");
	    play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	try {
        	        FileInputStream fis = new FileInputStream("src/resources/audio/" + words.get(wordNumber).get(3) + ".mp3");
        	        Player playMP3 = new Player(fis);

        	        playMP3.play();

        	    } catch (Exception exception) {System.out.println(exception);}
            }
        });
	    
	    // Word and play button are displayed in a HBox
	 	wordAndPlayBox = new HBox();
	    wordAndPlayBox.setAlignment(Pos.CENTER);
	    wordAndPlayBox.setSpacing(20);
	 	wordAndPlayBox.getChildren().add(word);
	    wordAndPlayBox.getChildren().add(play);
	    
	    // Create label with the word meaning; it is not displayed until call to the showAnswer() function
	    wordMeaning = new Label(words.get(wordNumber).get(2));
	    wordMeaning.setMaxWidth(400);
	    wordMeaning.setWrapText(true);
	    wordMeaning.setTextAlignment(TextAlignment.CENTER);

	    // Create Show meaning button
	    Button showMeaning = new Button("Show meaning");
	    showMeaning.getStyleClass().add("appButton");
	    showMeaning.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	showAnswer();
            }
        });
	    
	    // HBox containing word and play button and meaning/Show meaning button are displayed using a VBox
 		wordAndPlayAndMeaningBox = new VBox();
 		wordAndPlayAndMeaningBox.setPadding(new Insets(10));
 		wordAndPlayAndMeaningBox.setAlignment(Pos.CENTER);
 		wordAndPlayAndMeaningBox.setSpacing(20);
 		
 		// Add items to VBox
 		wordAndPlayAndMeaningBox.getChildren().add(wordAndPlayBox);
	    wordAndPlayAndMeaningBox.getChildren().add(showMeaning);
	    
	    // Create the quiz box
	    VBox answerBox = createPossibleAnswers(wordNumber);

	    // HBox containing the word part and the quiz par of the view to display them horizontally
	    HBox wordAndAnswersBox = new HBox();
	    wordAndAnswersBox.setAlignment(Pos.CENTER);
	    wordAndAnswersBox.setSpacing(20);
	    wordAndAnswersBox.getChildren().add(wordAndPlayAndMeaningBox);
	    wordAndAnswersBox.getChildren().add(answerBox);
	  
	    // Main VBox of the view; contains the word/quiz part and the example if there is one for the considered word
	    VBox mainVBox = new VBox();
	    mainVBox.setPadding(new Insets(10));
	    mainVBox.setAlignment(Pos.CENTER);
	    mainVBox.setSpacing(65);	    
	    mainVBox.getChildren().add(wordAndAnswersBox); 
	    
	    // Add example sentence if there is one
	    String exampleText = words.get(wordNumber).get(4);
	    if (!(exampleText.equals(""))) {
		    Label example = new Label(/*"Example: " + */exampleText);
		    example.setMaxWidth(600);
		    example.setWrapText(true);
		    example.setTextAlignment(TextAlignment.CENTER);
		    example.getStyleClass().add("example");
		    
		    AnchorPane.setLeftAnchor(example, 0.0);
		    AnchorPane.setRightAnchor(example, 0.0);
		    example.setAlignment(Pos.CENTER);
		    
		    mainVBox.getChildren().add(example);
	    }
	    
	    this.setCenter(mainVBox);	   
	    
	}
	
	/**
	 * Creates a VBox containing the possible answers for the quiz
	 * @param number/position of the considered word in the database
	 * @return a VBox containing three possible answers
	 */
	public VBox createPossibleAnswers(int rand) {
		
		int secondAnswerRand;
		int thirdAnswerRand;
		while ((secondAnswerRand = (int) (Math.random()*words.size())) == rand 
				|| (thirdAnswerRand = (int) (Math.random()*words.size())) == rand
				|| (secondAnswerRand = (int) (Math.random()*words.size())) == (thirdAnswerRand = (int) (Math.random()*words.size())))
				{}
				
		Button secondAnswer = makeAnswerButton(secondAnswerRand);
		Button thirdAnswer = makeAnswerButton(thirdAnswerRand);
		Button rightAnswer = makeAnswerButton(rand);
		
		int position = (int) (Math.random()*3);
		answers[position] = rightAnswer;
		answers[(position+1)%3] = secondAnswer;
		answers[(position+2)%3] = thirdAnswer;
		
		VBox answerBox = new VBox();
		answerBox.setAlignment(Pos.CENTER);
		answerBox.setSpacing(15);
		
		answerBox.getChildren().add(answers[0]);
		answerBox.getChildren().add(answers[1]);
		answerBox.getChildren().add(answers[2]);
		
		return answerBox;
		
	}
	
	/**
	 * Creates a VBox containing the possible answers for the quiz
	 * @param number/position of the considered word in the database
	 * @return a answer button
	 */
	private Button makeAnswerButton(final int number) {
		
		Button button = new Button(words.get(number).get(2));
		
		button.getStyleClass().add("answerButton");
		button.setMinWidth(200);
		button.setMaxWidth(200);
		button.setWrapText(true);
		button.setTextAlignment(TextAlignment.CENTER);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	String buttonWord = words.get(number).get(2);
            	if (buttonWord.equals(wordMeaning.getText())) {
            		for (int i=0; i<3; i++) {
            			answers[i].setDisable(true);
            			if (answers[i].getText().equals(buttonWord)) {
            				answers[i].getStyleClass().add("rightAnswer");
            			}
            		}
            	} else {
            		for (int i=0; i<3; i++) {
            			answers[i].setDisable(true);
            			if (answers[i].getText().equals(buttonWord)) {
            				answers[i].getStyleClass().add("wrongAnswer");
            			} else if (answers[i].getText().equals(wordMeaning.getText())) {
            				answers[i].getStyleClass().add("rightAnswer");
            			}
            		}
            	}
            	showAnswer();
            }
        });
		
		return button;
		
	}
	
}
