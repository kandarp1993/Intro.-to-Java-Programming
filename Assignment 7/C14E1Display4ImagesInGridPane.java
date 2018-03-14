/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 10/17/2017
 * Description - This program displays four images in a grid pane using Java Fx 
 **/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class C14E1Display4ImagesInGridPane  extends Application{

	@Override
	public void start(Stage newStage) throws Exception {
		// TODO Auto-generated method stub
		//Declaring grid pane
		GridPane grid = new GridPane();
		//Setting alignment
		grid.setAlignment(Pos.CENTER);     
		grid.setPadding(new Insets(10, 11, 12, 13));  
		//Specifying the horizontal gap
		grid.setHgap(5);
		//Specifying the vertical gap
		grid.setVgap(6);
		//Adding text
		Text heading = new Text(20,20,"This program displays four images in a grid pane using JavaFx");
		grid.add(heading, 0, 0);
		//Declaring images
		Image flag = new Image("flag1.png");
		Image flag1 = new Image("flag2.gif");
		Image flag2 = new Image("flag3.gif");
		Image flag3 = new Image("flag4.gif");
		//Adding images to grid plane
		grid.add(new ImageView(flag),0,1);
		grid.add(new ImageView(flag1),1,1);
		grid.add(new ImageView(flag2),0,4);
		grid.add(new ImageView(flag3),1,4);
		
		//Setting up scene and stage
		Scene newScene = new Scene(grid);
		newStage.setTitle("Display Images");
		newStage.setScene(newScene);
		newStage.show();
	}
	
	 public static void main(String[] args) 
	 { 
		 //Launching the java fx application
		 Application.launch(args);    
	} 
	

}

