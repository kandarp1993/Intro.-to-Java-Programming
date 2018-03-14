/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/06/2017
 * Description - Calculate area of triangle with given coordinates .
 */

import javax.swing.JOptionPane;
public class C2E19AreaOfaTriangle {

	public static void main(String args[]) {
		
		//Display message box with the description.
		JOptionPane.showMessageDialog(null,"Enter the coordinates (x1,y1), (x2,y2), (x3,y3) of the triangle. ","Exercise Description",JOptionPane.INFORMATION_MESSAGE );
		
		//Display Input dialog box  to take values and store in respective variables.
		try{
				double X1=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  x1 coordinate: ","x1",JOptionPane.QUESTION_MESSAGE));
				double Y1=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  y1 coordinate: ","y1",JOptionPane.QUESTION_MESSAGE));
				double X2=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  x2 coordinate: ","x2",JOptionPane.QUESTION_MESSAGE));
				double Y2=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  y2 coordinate: ","y2",JOptionPane.QUESTION_MESSAGE));
				double X3=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  x3 coordinate: ","x3",JOptionPane.QUESTION_MESSAGE));
				double Y3=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter  y3 coordinate: ","y3",JOptionPane.QUESTION_MESSAGE));
				
				
				
				//Calculating the length of the sides of the triangle.
				double S1 = Math.sqrt((X2-X1)*(X2-X1) + (Y2-Y1)*(Y2-Y1));
				double S2 = Math.sqrt((X3-X2)*(X3-X2) + (Y3-Y2)*(Y3-Y2));
				double S3 = Math.sqrt((X3-X1)*(X3-X1) + (Y3-Y1)*(Y3-Y1));
				
				//Calculating the semi-perimeter of the triangle.
				double S = (S1 + S2 + S3)/2; 
				
				//Calculating the area of the given triangle.
				double area = Math.sqrt(S*(S-S1)*(S-S2)*(S-S3));
				
				//Display the message dialog box with the are of the triangle.
				JOptionPane.showMessageDialog(null,"The area of the triangle is : " + area,"Result",JOptionPane.INFORMATION_MESSAGE );
			} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Exception Occured. Please execution again.","Exception",JOptionPane.WARNING_MESSAGE );
		}
	}
}
