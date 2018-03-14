/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 10/17/2017
 * Description - This program displays a bar chart for representing grades using Java Fx. 
 **/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class C14E12DisplayBarChart extends Application {
	@Override 
	// Override the start method in the Application class
	public void start(Stage newStage) {
		// Create a HBox
		HBox hBox = new HBox(15);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		//Declaring list containing titles and grades
		String[] subjects = {"Project", "Quiz", "Midterm", "Final"};
		double[] gradePercent = {20, 10, 30, 40};

		double max = getMax(gradePercent);

		double height = 200;
		double width = 150;

		StackPane pane = new StackPane();
		pane.setPadding(new Insets(20, 15, 5, 15));

		// Create rectangles
		Rectangle r1 = new Rectangle(0, 0, width, height * gradePercent[0] / max);
		//Specifying color
		r1.setFill(Color.RED);
		Rectangle r2 = new Rectangle(0, 0, width, height * gradePercent[1] / max);
		r2.setFill(Color.BLUE);
		Rectangle r3 = new Rectangle(0, 0, width, height * gradePercent[2] / max);
		r3.setFill(Color.GREEN);
		Rectangle r4 = new Rectangle(0, 0, width, height * gradePercent[3] / max);
		r4.setFill(Color.ORANGE);

		// Create 4 Text objects
		Text t1 = new Text(0, 0, subjects[0] + " -- " + gradePercent[0] + "%");
		Text t2 = new Text(0, 0, subjects[1] + " -- " + gradePercent[1] + "%");
		Text t3 = new Text(0, 0, subjects[2] + " -- " + gradePercent[2] + "%");
		Text t4 = new Text(0, 0, subjects[3] + " -- " + gradePercent[3] + "%");
		
		hBox.getChildren().addAll(getVBox(t1, r1), getVBox(t2, r2), 
			getVBox(t3, r3), getVBox(t4, r4));
		pane.getChildren().add(hBox);

		// Create a scene and place it in the stage
		Scene newScene = new Scene(pane);
		newStage.setTitle("This program displays a bar chart representing grades"); // Set the stage title
		newStage.setScene(newScene); // Place the scene in the stage
		newStage.show(); // Display the stage
	}

	public double getMax(double[] value) {
		double max = value[0];
		for (int i = 0; i < value.length; i++) {
			if (value[i] > max)
				max = value[i];
		}
		return max;
	}

	public VBox getVBox(Text text, Rectangle rectangle) {
		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.BOTTOM_LEFT);
		vBox.getChildren().addAll(text, rectangle);
		return vBox;
	}
	public static void main(String[] args) 
	 { 
		 //Launching the java fx application
		 Application.launch(args);    
	}
}
