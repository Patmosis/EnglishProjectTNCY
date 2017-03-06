package View;

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
	
	Label paneTitle = new Label("    How English is English?    ");
	GridPane choicePane = new GridPane();
	
	public Language() {
		initialize();
	}
	
	/**
	 * Initialize language pane
	 */
	private void initialize() {
		paneTitle.getStyleClass().add("paneTitle");
		setTop(paneTitle);
		//setCenter(new Label("What do you want to do?"));
		
		
		// load the image
        Image worldMap = new Image("resources/images/worldmap.jpg");

        // simple displays ImageView the image as is
        ImageView worldMapView = new ImageView();
        worldMapView.setImage(worldMap);
        worldMapView.setFitWidth(750);
        worldMapView.setPreserveRatio(true);
        worldMapView.setSmooth(true);
        worldMapView.setCache(true);
        
        StackPane stack = new StackPane();

        Button usaButton = new Button("USA");
        usaButton.getStyleClass().add("mapButton");
        
        Button ukButton = new Button("UK");
        ukButton.getStyleClass().add("mapButton");
        
        Button indiaButton = new Button("India");
        indiaButton.getStyleClass().add("mapButton");
        
        Button australiaButton = new Button("Australia");
        australiaButton.getStyleClass().add("mapButton");
        
        Button southAfricaButton = new Button("South\nAfrica");
        southAfricaButton.getStyleClass().add("mapButton");


        stack.getChildren().add(worldMapView);
        stack.getChildren().add(usaButton);
        stack.getChildren().add(ukButton);
        stack.getChildren().add(indiaButton);
        stack.getChildren().add(australiaButton);
        stack.getChildren().add(southAfricaButton);

        StackPane.setMargin(usaButton, new Insets(0, 460, 50, 0)); 
        StackPane.setMargin(ukButton, new Insets(0, 70, 120, 0));
        StackPane.setMargin(indiaButton, new Insets(25, 0, 0, 250));
        StackPane.setMargin(australiaButton, new Insets(230, 0, 0, 470));
        StackPane.setMargin(southAfricaButton, new Insets(240, 0, 0, 25));
        
        this.setCenter(stack);

	}
	
}
