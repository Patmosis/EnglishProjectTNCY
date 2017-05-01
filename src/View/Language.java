package View;

import Model.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Main pane of the language learning part of the application
 * @author gauthier
 *
 */
public class Language extends BorderPane {
	
	GridPane titlePane;
	Label title = new Label();
	private Data data;
	
	public Language() {
		data = new Data();
		initialize();
	}
	
	/**
	 * Initialize language pane with the world map
	 */
	private void initialize() {
		this.setBottom(null);
		// Set tab title
		titlePane = new GridPane();
		title.setText("     How English is English?");
		title.getStyleClass().add("paneTitle");
		titlePane.add(title, 1, 0);
		titlePane.getStyleClass().add("titlePane");
		setTop(titlePane);		
		
		// Load world map
        Image worldMap = new Image("resources/images/worldmap.jpg");

        // Create image view for the world map
        ImageView worldMapView = new ImageView();
        worldMapView.setImage(worldMap);
        worldMapView.setFitWidth(750);
        worldMapView.setPreserveRatio(true);
        worldMapView.setSmooth(true);
        worldMapView.setCache(true);
        
        // Create image stack
        StackPane stack = new StackPane();

        // Create map buttons
        Button usaButton = createMapButton("USA", 1);
        Button ukButton = createMapButton("UK", 2);
        Button indiaButton = createMapButton("India", 3);
        Button southAfricaButton = createMapButton("South\nAfrica", 4);
        Button australiaButton = createMapButton("Australia", 5);

        // Set world map 
        stack.getChildren().add(worldMapView);
        // Add buttons on the map
        stack.getChildren().addAll(usaButton, ukButton, indiaButton, australiaButton, southAfricaButton);

        // Set buttons position
        StackPane.setMargin(usaButton, new Insets(0, 460, 50, 0)); 
        StackPane.setMargin(ukButton, new Insets(0, 80, 120, 0));
        StackPane.setMargin(indiaButton, new Insets(25, 0, 0, 250));
        StackPane.setMargin(australiaButton, new Insets(230, 0, 0, 470));
        StackPane.setMargin(southAfricaButton, new Insets(240, 0, 0, 25));
        
        // Set the stack as the center of the pane
        this.setCenter(stack);

	}
	
	/**
	 * Create a clickable area for the world map
	 * @param string to be printed, number of the method to be called when area is clicked
	 * @return a map button of the required country 
	 */
	public Button createMapButton(String s, final int functionToBeCalled) {
		Button button = new Button(s);
		button.getStyleClass().add("mapButton");
		button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	createCountryView(functionToBeCalled);
            }
        });
		return button;
	}
	
	public void createCountryView(int countryId) {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("arrowButton");
		titlePane.add(back, 0, 0);
		
		// Set country view title and country reference for words in database
		String newTitle = null;
		String newCountry = null;
    	switch (countryId) {
    		case 1:
    			newTitle = " The United States of America";
    			newCountry = "us";
    			break;
    		case 2:
    			newTitle = " The United Kingdom";
    			newCountry = "gb";
    			break;
    		case 3:
    			newTitle = " India";
    			newCountry = "in";
    			break;
    		case 4:
    			newTitle = " South Africa";
    			newCountry = "za";
    			break;
    		case 5:
    			newTitle = " Australia";
    			newCountry = "au";
    			break;
    	}
    	title.setText(newTitle);
    	final WordView countryPane = new WordView(data,newCountry);
    	this.setCenter(countryPane);
    	
    	// Get next randomly chosen word
    	Button nextButton = new Button("Next");
    	nextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	countryPane.nextWord();
            }
        });
    	nextButton.getStyleClass().add("appButton");
    	StackPane bottomStack = new StackPane();
    	bottomStack.getStyleClass().add("accessButtons");
    	bottomStack.setAlignment(Pos.CENTER);
    	bottomStack.getChildren().add(nextButton);
    	this.setBottom(bottomStack);
	}
	
}
