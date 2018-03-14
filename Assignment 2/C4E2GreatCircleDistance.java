/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/11/2017
 * Description - Calculate great circle distance for given Latitude and Longitude of two points.
 */

import javax.swing.JOptionPane;

public class C4E2GreatCircleDistance {
	
	private static final double AVERAGE_EARTH_RADIUS = 6371.01;

    public static void main(String[] args) {
    	boolean bFlag = true;
    	while(bFlag){
    		try{
    			// Getting (x1,y1) (x2,y2) from user
    			String inputone = JOptionPane.showInputDialog(null, "Enter point 1 (latitude and longitude) in degrees separated with comma","User Input",JOptionPane.QUESTION_MESSAGE);
    			String[] inputNumbers = inputone.split(",");

    			double x1 = Double.parseDouble(inputNumbers[0]);
    			double y1 = Double.parseDouble(inputNumbers[1]);

    			String inputtwo = JOptionPane.showInputDialog(null, "Enter point 2 (latitude and longitude) in degrees separated with comma","User Input",JOptionPane.QUESTION_MESSAGE);
    			String[] inputNumbers2 = inputtwo.split(",");

    			double x2 = Double.parseDouble(inputNumbers2[0]);
    			double y2 = Double.parseDouble(inputNumbers2[1]);

    			// Solving for the distance between the two points
    			// Formula: d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))

    			double radius = AVERAGE_EARTH_RADIUS;

    			double distance = radius *
    					Math.acos( Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
                           Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) *
                           Math.cos(Math.toRadians(y1 - y2)));
    			JOptionPane.showMessageDialog(null, "The distance between the two points is"+distance+" km","Result", JOptionPane.INFORMATION_MESSAGE);
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
