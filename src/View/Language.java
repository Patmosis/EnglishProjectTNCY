package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	
	public Language() {
		initialize();
	}
	
	/**
	 * Initialize language pane with the world map
	 */
	private void initialize() {
		// Set tab title
		titlePane = new GridPane();
		title.setText("     How English is English?");
		title.getStyleClass().add("paneTitle");
		titlePane.add(title, 1, 0);
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
        StackPane.setMargin(ukButton, new Insets(0, 70, 120, 0));
        StackPane.setMargin(indiaButton, new Insets(25, 0, 0, 250));
        StackPane.setMargin(australiaButton, new Insets(230, 0, 0, 470));
        StackPane.setMargin(southAfricaButton, new Insets(240, 0, 0, 25));
        
        // Set the stack as the center of the pane
        this.setCenter(stack);

	}
	
	/**
	 * Switch to the USA view
	 */
	private void usa() {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("backButton");
		titlePane.add(back, 0, 0);
		
		// Set view title
		title.setText(" The United States of America");
		BorderPane usaPane = new BorderPane();
		this.setCenter(usaPane);
	}
	
	/**
	 * Switch to the UK view
	 */
	private void uk() {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("backButton");
		titlePane.add(back, 0, 0);
		
		// Set view title
		title.setText(" The United Kingdom");
		BorderPane ukPane = new BorderPane();
		this.setCenter(ukPane);
	}
	
	/**
	 * Switch to the India view
	 */
	private void india() {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("backButton");
		titlePane.add(back, 0, 0);
		
		// Set view title
		title.setText(" India");
		BorderPane indiaPane = new BorderPane();
		this.setCenter(indiaPane);
	}
	
	/**
	 * Switch to the South Africa view
	 */
	private void southAfrica() {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("backButton");
		titlePane.add(back, 0, 0);
		
		// Set view title
		title.setText(" South Africa");
		BorderPane southAfricaPane = new BorderPane();
		this.setCenter(southAfricaPane);
	}
	
	/**
	 * Switch to the Australia view
	 */
	private void australia() {
		// Create button to go back to main menu of the view
		Button back = new Button("🢀");
		back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	initialize();
            }
        });
		back.getStyleClass().add("backButton");
		titlePane.add(back, 0, 0);
		
		// Set view title
		title.setText(" Australia");
		BorderPane australiaPane = new BorderPane();
		this.setCenter(australiaPane);
	}
	
	/**
	 * Create a clickable area for the world map
	 * @param string to be printed, number of the method to be called when area is clicked
	 */
	public Button createMapButton(String s, final int functionToBeCalled) {
		Button button = new Button(s);
		button.getStyleClass().add("mapButton");
		button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	switch (functionToBeCalled) {
            		case 1:
            			usa();
            			break;
            		case 2:
            			uk();
            			break;
            		case 3:
            			india();
            			break;
            		case 4:
            			southAfrica();
            			break;
            		case 5:
            			australia();
            			break;
            	}
            }
        });
		return button;
	}
	
}
