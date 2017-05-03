package View;

import java.util.ArrayList;

import Model.HistoryData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.text.TextAlignment;

public class History extends BorderPane {
	
	private static int nbPages = 14;
	private int numPage = 0;
	private HistoryData data;
	
	public History(int numPage) {
		data = new HistoryData();
		initialize();
	}
	
	
	public void initialize() {

		HBox menu = new HBox();
		menu.setPadding(new Insets(1));
		ArrayList<Button> menuList = new ArrayList<Button>();
		
		for(int i=1; i<=nbPages;i++) {
			int i2 = i;
			menuList.add(new Button(Integer.toString(i2)));
		}
		
		for(int i=1; i<=nbPages; i++) {
			int i2 = i;
			menuList.get(i-1).getStyleClass().add("hmenuButton");
			menu.getChildren().add(menuList.get(i-1));
			menuList.get(i-1).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					numPage = i2;
					initialize();
				}
			});
		}

		Label title = new Label();
		title.setText(data.getByNum(numPage).get(0));
		title.getStyleClass().add("historyTitlePane");

		Label onpages = new Label();
		onpages.setText("/" + String.valueOf(nbPages));
		
		VBox content = new VBox(15);
		BorderPane change = new BorderPane();
		
		Button prev = new Button("previous\n🢀");
		Button next = new Button("next\n    🢂");
		Button start = new Button("start");
		
		prev.getStyleClass().add("nextprevButton");
		next.getStyleClass().add("nextprevButton");
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

		
		if(numPage == 0) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/colonization.jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(400);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			Label presentation = new Label();
			presentation.setText(data.getByNum(numPage).get(1));
			presentation.setWrapText(true);
			presentation.getStyleClass().add("historyText");
			presentation.setTextAlignment(TextAlignment.CENTER);
			presentation.setMaxWidth(900);
			content.getChildren().add(presentation);
			change.setCenter(start);
			
		
		}
		
		if(numPage == 1) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/page1.gif");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(400);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			Label presentation = new Label();
			presentation.setText(data.getByNum(numPage).get(1));
			presentation.setWrapText(true);
			presentation.getStyleClass().add("historyText");
			presentation.setTextAlignment(TextAlignment.CENTER);
			presentation.setMaxWidth(900);
			content.getChildren().add(presentation);
			next.getStyleClass().add("backButton");
			
			change.setCenter(menu);
			change.setRight(next);
			
			menu.setAlignment(Pos.CENTER);
			next.setAlignment(Pos.CENTER_RIGHT);
			
		}
		
		if(numPage < nbPages && numPage > 1) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/worldmap"+Integer.toString(numPage)+".jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(400);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			Label presentation = new Label();
			presentation.setText(data.getByNum(numPage).get(1));
			presentation.setWrapText(true);
			presentation.getStyleClass().add("historyText");
			presentation.setTextAlignment(TextAlignment.CENTER);
			presentation.setMaxWidth(900);
			content.getChildren().add(presentation);
			
			change.setCenter(menu);
			change.setRight(next);
			change.setLeft(prev);
			
			prev.setAlignment(Pos.CENTER_LEFT);
			menu.setAlignment(Pos.CENTER);
			next.setAlignment(Pos.CENTER_RIGHT);
		}
		
		
		if(numPage == nbPages) {
			
			ImageView mapView = new ImageView();
			Image map = new Image("resources/images/commonwealth.jpg");
			mapView.setPreserveRatio(true);
			mapView.setFitHeight(400);
			mapView.setImage(map);
			content.getChildren().add(mapView);
			
			Label presentation = new Label();
			presentation.setText(data.getByNum(numPage).get(1));
			presentation.setWrapText(true);
			presentation.getStyleClass().add("historyText");
			presentation.setTextAlignment(TextAlignment.CENTER);
			presentation.setMaxWidth(900);
			content.getChildren().add(presentation);

			change.setCenter(menu);
			change.setLeft(prev);
			
			prev.setAlignment(Pos.CENTER_LEFT);
			menu.setAlignment(Pos.CENTER);
			
		}
		
		menu.setAlignment(Pos.CENTER);
		content.setAlignment(Pos.CENTER);
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		
		setTop(title);
		setCenter(content);
		setBottom(change);
		
	}
	
}
