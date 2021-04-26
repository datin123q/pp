package application;
	
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		InputStream input = getClass().getResourceAsStream("/images/background.png");
		 
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        
		    Pane root = new Pane(imageView);
			Scene scene = new Scene(root,1000,600);
			
			InputStream input1 = getClass().getResourceAsStream("/images/normal.png");
			 
	        Image image1 = new Image(input1);
	        ImageView imageView1 = new ImageView(image1);
	        
	        
	        Button but1 = new Button();
	        but1.setGraphic(imageView1);
	        but1.setLayoutX(100);
	        but1.setLayoutY(275);
	        
	        but1.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            
	            	BattleshipMain main1 = new BattleshipMain();
	            	main1.run(primaryStage);
	            }
	        });

			InputStream input2 = getClass().getResourceAsStream("/images/hard.png");
			 
	        Image image2 = new Image(input2);
	        ImageView imageView2 = new ImageView(image2);
	        
	        Button but2 = new Button();
	        but2.setGraphic(imageView2);
	        but2.setLayoutX(100);
	        but2.setLayoutY(375);
	        but2.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	BatttleshipMain2 main1 = new BatttleshipMain2();
	            	main1.run(primaryStage);
	            }
	        });
	        
			InputStream input3 = getClass().getResourceAsStream("/images/about.png");
			 
	        Image image3 = new Image(input3);
	        ImageView imageView3 = new ImageView(image3);
	        
	        Button but3 = new Button();
	        but3.setGraphic(imageView3);
	        but3.setLayoutX(100);
	        but3.setLayoutY(475);
	        
	        
	        but3.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent event) {
	 
	                Label secondLabel = new Label();
	                BufferedReader br = null;
	    			try {
	    				br = new BufferedReader(new FileReader(new File(
	    						"D:/tittle/src/application/about.txt")));
	    			} catch (FileNotFoundException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			String str = "";
	    			String line = "";
	    			try {
	    				while((line=br.readLine())!=null){
	    					str=str+line+"\n";
	    				}
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			try {
	    				br.close();
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block   
	    				e.printStackTrace();
	    			}
	    			secondLabel.setText(str);
	    		   // secondLabel.setFont(new Font(30));
	                Pane secondaryLayout = new Pane();
	                secondaryLayout.getChildren().add(secondLabel);
	 
	                Scene secondScene = new Scene(secondaryLayout, 600, 600);
	 
	                // Một cửa sổ mới (Stage)
	                Stage newWindow = new Stage();
	                newWindow.setTitle("About");
	                newWindow.setScene(secondScene);
	 
	                // Sét đặt vị trí cho cửa sổ thứ 2.
	                // Có vị trí tương đối đối với cửa sổ chính.
	                newWindow.setX(primaryStage.getX() + 200);
	                newWindow.setY(primaryStage.getY() );
	 
	                newWindow.show();
	            }
	        });
	        

	        
	        primaryStage.setScene(scene);
			root.getChildren().addAll(but1, but2, but3);
			primaryStage.setTitle("Battleship");
			primaryStage.setResizable(false);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}