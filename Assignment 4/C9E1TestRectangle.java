/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/26/2017
 * Description - To test the C9E1Rectangle class with creating objects     
 **/

import javax.swing.JOptionPane;

public class C9E1TestRectangle {

	public static void main(String[] args) {
		String sResult = "";
		boolean continueProgram = true;
		while (continueProgram) {
			try {
				String inputString = JOptionPane.showInputDialog(null,"Enter the width and height of the rectangle separated with comma.","Input", JOptionPane.QUESTION_MESSAGE);
				
				String[] splitInput = inputString.split(",");
				double dWidth = Double.parseDouble(splitInput[0]);
				double dHeight = Double.parseDouble(splitInput[1]);
				
				C9E1Rectangle rectangle = new C9E1Rectangle(dWidth, dHeight);
				
				double perimeter = rectangle.getPerimeter();
				double area = rectangle.getArea();
				sResult = " - The width, height, area and perimeter of the first rectangle are "
						+ dWidth
						+ ", "
						+ dHeight
						+ ", "
						+ area
						+ " and "
						+ perimeter + " respectively.";

				JOptionPane.showMessageDialog(null, sResult, "Result",JOptionPane.INFORMATION_MESSAGE);
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Exception caught.\nMessage: "+e.getMessage(),
						"Exception", JOptionPane.ERROR_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,"Do you want to repeat the program?","Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}


}
