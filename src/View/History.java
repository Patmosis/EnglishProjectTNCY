package View;

import java.util.ArrayList;

import Model.HistoryData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		getChildren().removeAll();
		
		HBox menu = new HBox();
		
		ArrayList<Button> menuList = new ArrayList<Button>();
		menuList.add(new Button("🏠"));
		menuList.get(0).getStyleClass().add("hmenuButton");
		menu.getChildren().add(menuList.get(0));
		menuList.get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				numPage = 0;
				initialize();
				
			}
		});
		
		for(int i=1; i<=nbPages; i++) {
			final int i2 = i;
			menuList.add(new Button(Integer.toString(i2)));
			if(i == numPage) {
				menuList.get(i).getStyleClass().add("selectedPageButton");
			}
			else {
				menuList.get(i).getStyleClass().add("hmenuButton");
			}
			menu.getChildren().add(menuList.get(i));
			menuList.get(i).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					if(numPage != i2) {
						numPage = i2;
						initialize();
					}
				}
			});
			

		}

		Label title = new Label();
		title.setText(data.getByNum(numPage).get(0));
		title.getStyleClass().add("historyTitlePane");
		
		BorderPane change = new BorderPane();
		
		Button prev = new Button("previous\n🢀");
		Button next = new Button("       next\n           🢂");
		Button start = new Button("start");
		
		
		prev.getStyleClass().add("nextprevButton");
		next.getStyleClass().add("nextprevButton");
		start.getStyleClass().add("startButton");
		
		
		
		VBox content = new VBox(15);
		
		ImageView mapView = new ImageView();
		Image map = new Image("resources/images/worldmap"+Integer.toString(numPage)+".jpg");
		mapView.setPreserveRatio(true);
		mapView.setFitHeight(400);
		mapView.setImage(map);
		
		
		Label presentation = new Label();
		presentation.setText(data.getByNum(numPage).get(1));
		presentation.setWrapText(true);
		presentation.getStyleClass().add("historyText");
		presentation.setTextAlignment(TextAlignment.CENTER);
		presentation.setMaxWidth(900);
		
		
		if(numPage == 0) {
			
			HBox imAndSum = new HBox(15);
			VBox summary = new VBox(0);
			ArrayList<Button> summaryList = new ArrayList<Button>();
			change.setCenter(start);
			for(int i=1; i<=nbPages; i++) {
				final int i2 = i;
				summaryList.add(new Button(Integer.toString(i)+". "+data.getByNum(i).get(0)));
				summary.getChildren().add(summaryList.get(i-1));
				summaryList.get(i-1).getStyleClass().add("summaryButton");
				
				summaryList.get(i-1).setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						numPage = i2;
						initialize();
					}
				});
			}
			
			imAndSum.setAlignment(Pos.CENTER);
			imAndSum.getChildren().add(summary);
			imAndSum.getChildren().add(mapView);
			
			content.getChildren().add(imAndSum);
			content.getChildren().add(presentation);
			
		}
		
		else {

			content.getChildren().add(mapView);
			content.getChildren().add(presentation);
			
			change.setCenter(menu);
			change.setRight(next);
			change.setLeft(prev);
			
			if(numPage == 1) {
				prev.setVisible(false);
			}
			
			if(numPage == nbPages) {
				next.setVisible(false);
			}
			
		}
		
		menu.setAlignment(Pos.CENTER);
		content.setAlignment(Pos.CENTER);
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		
		setTop(title);
		setCenter(content);
		setBottom(change);
		
		
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
	}
	
}
