package Model;

import View.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Main menu of the application
 * @author gauthier
 *
 */
public class Menu extends GridPane {
	
	private Button language = new Button("Language");
	private Button history = new Button("History");
	private Button closingButton = new Button(" x ");
	private Button reducingButton = new Button(" ⎼ ");
	private BorderPane windowMainPane;
	private Stage gameMainStage;
	
	private static double xOffset = 0;
    private static double yOffset = 0;
	
	private String currentTab = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Menu(final BorderPane mainPane, final Stage stage) {
		windowMainPane = mainPane;
		gameMainStage = stage;
		
		// Set horizontal gap between parts of the menu
		setHgap(520);//260
		getStyleClass().add("mainMenu");
		
		// Initialize class attributes
		initializeAttributes();
	    
	    // Set language-history menu part
	    GridPane actualMenu = new GridPane();
	    actualMenu.setHgap(1);
	    actualMenu.add(history, 0, 0);
	    actualMenu.add(language, 1, 0);
	    
	    // Set window's properties menu part
	    GridPane propertyMenu = new GridPane();
	    propertyMenu.setHgap(1);
	    propertyMenu.add(reducingButton, 0, 0);
	    propertyMenu.add(closingButton, 1, 0);
	    
	    
	    // Add nodes to menu
	    add(actualMenu,0,0);    	    
	    add(propertyMenu, 1, 0);
	    
	    
	    this.setOnMousePressed(new EventHandler() {
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }

			@Override
			public void handle(Event arg0) {
				handle((MouseEvent) arg0);
				
			}
        });
	    
	    this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
	}
	
	private void initializeAttributes() {		
		// Set language button properties
	    language.setMinWidth(200);//250
	    language.setAlignment(Pos.CENTER);
	    language.getStyleClass().clear();
	    language.getStyleClass().add("menuButton");
	    
	    // Set history button properties
	    history.setMinWidth(200);//250
	    history.setAlignment(Pos.CENTER);
	    history.getStyleClass().clear();
	    history.getStyleClass().add("menuButton");
	    
	    // Set closing button button properties
	    closingButton.getStyleClass().clear();
	    closingButton.getStyleClass().add("menuButton");
	    
	    // Set reducing button button properties
	    reducingButton.getStyleClass().clear();
	    reducingButton.getStyleClass().add("menuButton");
	    
	    // Close window/application on click
	    closingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	gameMainStage.close();
            }
        });
	    
	    // Reduce window/application on click
	    reducingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	gameMainStage.setIconified(true);
            }
        });
	    
	    // Switch to the language part of the application on click
	    language.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (currentTab == null || currentTab.equals("history")) {
                	currentTab = "language";
                	updateTabButtons();
                	windowMainPane.setCenter(new Language());
                }
            }
        });
	    
		// Switch to the history part of the application on click
	    history.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	if (currentTab == null || currentTab.equals("language")) {
            		currentTab = "history";
            		updateTabButtons();
            		windowMainPane.setCenter(new History(0));
            	}
            }
        });
	}
	
	/**
	 * Update menu buttons (set enabled/disabled)	
	 */
	private void updateTabButtons() {
		if (currentTab == null || currentTab.equals("history")) {
			history.setDisable(true);
			language.setDisable(false);
		} else if (currentTab == null || currentTab.equals("language")) {
			language.setDisable(true);
			history.setDisable(false);
		}
	}
	
	public void setHistory() {
		if (currentTab == null || currentTab.equals("language")) {
    		currentTab = "history";
    		updateTabButtons();
    		windowMainPane.setCenter(new History(0));
    	}
	}
	
	public void setLanguage() {
		if (currentTab == null || currentTab.equals("history")) {
        	currentTab = "language";
        	updateTabButtons();
        	windowMainPane.setCenter(new Language());
        }
	}
	
}
