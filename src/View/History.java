package View;

import Model.HistoryData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class History extends BorderPane {
	
	private static int nbPages = 19;
	private int numPage = 0;
	private HistoryData data;
	
	public History(int numPage) {
		data = new HistoryData();
		initialize();
	}
	
	
	public void initialize() {
		
		Label title = new Label();
		title.setText(data.getByNum(numPage).get(1));

		
		Label onpages = new Label();
		onpages.setText("/" + String.valueOf(nbPages));
		
		VBox content = new VBox();
		StackPane change = new StackPane();
		
		Button prev = new Button("previous\n🢀");
		Button next = new Button("next\n    🢂");
		Button start = new Button("start");
		HBox gotobox = new HBox();
		
		TextField gotofield = new TextField();
		gotofield.setMinHeight(5);
		gotofield.setMinWidth(5);
		gotofield.setPrefSize(50,35);
		gotofield.setFont(new Font(18));
		Button gotobutton = new Button();
		gotobutton.setText("go!");
		
		prev.getStyleClass().add("nextprevButton");
		next.getStyleClass().add("nextprevButton");
		gotobutton.getStyleClass().add("startButton");
		start.getStyleClass().add("startButton");
		
		getChildren().removeAll();
		
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
		
		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				numPage++;
				initialize();
			}
		});
		
		gotobutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String fieldcontent = gotofield.getText().replaceAll("[\\D]","");
				if(!(fieldcontent.equals(""))) {
					int value = Integer.parseInt(fieldcontent);
					if(value > 0 && value < nbPages) {
						numPage = value;
						initialize();
						gotofield.setText("");
					}
				}
			}
		});
		
		if(numPage == 0) {
			
			change.getChildren().add(start);
			StackPane.setAlignment(start, Pos.BOTTOM_CENTER);
		
		}
		
		if(numPage == 1) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/worldmap"+Integer.toString(numPage)+".jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(380);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			gotobutton.getStyleClass().add("startButton");
			
			gotobox.getChildren().add(gotofield);
			gotobox.getChildren().add(onpages);
			gotobox.getChildren().add(gotobutton);
			change.getChildren().add(gotobox);
			
			next.getStyleClass().add("backButton");
			change.getChildren().add(next);
			StackPane.setAlignment(next, Pos.BOTTOM_RIGHT);
			
			gotobox.setAlignment(Pos.CENTER);
			StackPane.setAlignment(gotobox, Pos.BOTTOM_CENTER);


		}
		
		if(numPage < nbPages && numPage > 1) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/worldmap"+Integer.toString(numPage)+".jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(380);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			gotobox.getChildren().add(gotofield);
			gotobox.getChildren().add(onpages);
			gotobox.getChildren().add(gotobutton);
			change.getChildren().add(gotobox);
			
			change.getChildren().add(next);
			StackPane.setAlignment(next, Pos.BOTTOM_RIGHT);

			change.getChildren().add(prev);
			StackPane.setAlignment(prev, Pos.BOTTOM_LEFT);
			gotobox.setAlignment(Pos.CENTER);
			StackPane.setAlignment(gotobox, Pos.BOTTOM_CENTER);
		}
		
		
		if(numPage == nbPages) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/worldmap"+Integer.toString(numPage)+".jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(380);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			gotobox.getChildren().add(gotofield);
			gotobox.getChildren().add(onpages);
			gotobox.getChildren().add(gotobutton);
			change.getChildren().add(gotobox);
			
			change.getChildren().add(prev);
			StackPane.setAlignment(prev, Pos.BOTTOM_LEFT);
			gotobox.setAlignment(Pos.CENTER);
			StackPane.setAlignment(gotobox, Pos.BOTTOM_CENTER);
			
		}
					
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		
		content.setAlignment(Pos.TOP_CENTER);
		
		setTop(title);
		setCenter(content);
		setBottom(change);
		
	}
	
}
