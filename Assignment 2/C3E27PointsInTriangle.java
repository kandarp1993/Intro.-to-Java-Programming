/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/08/2017
 * Description - To find whether the given point is inside the triangle or not.    
 */

import javax.swing.JOptionPane;

public class C3E27PointsInTriangle {
	public static void main(String[] args) {
	boolean bFlag = true;
	while(bFlag){
		try{
			
			//Take x , y coordinates from user.
			String input = JOptionPane.showInputDialog(null, "Enter the  x-coordinate, y-coordinate separated with comma","User Input",JOptionPane.QUESTION_MESSAGE);	
			//Separate the input given by user using comma.
			String[] inputs = input.split(",");
			
			double x = Double.parseDouble(inputs[0]);
			double y = Double.parseDouble(inputs[1]);
			
			double intersectx = (-x * (200 * 100)) / (-y * 200 - x * 100);
			double intersecty = (-y * (200 * 100)) / (-y * 200 - x * 100);
			
			//Display result.
			if((x > intersectx || y > intersecty)){
				JOptionPane.showMessageDialog(null, "The point is not in the triangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "The point is in the triangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(Exception e) {
			//Display warning box if any exception occurs.
			JOptionPane.showMessageDialog(null, "Exception occured. Please try executing the program again with correct input.", "Exception", JOptionPane.WARNING_MESSAGE);
		}
		
		//Ask user if the program needs to be re-executed.
		int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to re-execute?", "Repeat confirmation", JOptionPane.YES_NO_OPTION);
		if(confirmOption == 0)
			bFlag = true;
		else
			bFlag = false;
	}
}
}
