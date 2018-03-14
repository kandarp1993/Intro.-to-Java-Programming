/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/08/2017
 * Description - To solve the 2x2 linear equations using Cramer's rule.     
 */

import javax.swing.JOptionPane;

public class C3E3CramersRule {
	public static void main(String[] args) {
		double a, b, c, d, e, f, x, y;
		boolean bFlag = true;
		while(bFlag) {
			try {
				
					//Take inputs from the user.
					String input = JOptionPane.showInputDialog(null, "Enter a, b, c, d, e, f numbers separated with comma","User Input",JOptionPane.QUESTION_MESSAGE);	
					//Separate the input given by user using space delimiter.
					String[] inputNumbers = input.split(",");
		
					//To display error message, if the inputs given by the user are more than 6 numbers.
					if(inputNumbers.length > 6) {
						JOptionPane.showMessageDialog(null,"Please enter 6 numbers i.e. a, b, c, d, e, f separated with comma. "+'\n'+"Please retry the execution.","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {
						a = Double.parseDouble(inputNumbers[0]);
						b = Double.parseDouble(inputNumbers[1]);
						c = Double.parseDouble(inputNumbers[2]);
						d = Double.parseDouble(inputNumbers[3]);
						e = Double.parseDouble(inputNumbers[4]);
						f = Double.parseDouble(inputNumbers[5]);
						
						//Check if the linear equations has solution. If not display the respective message to the user.
						if((a*d - b*c) == 0)
							JOptionPane.showMessageDialog(null, "The equation has no solution", "No Solution", JOptionPane.INFORMATION_MESSAGE);
						else {
							x = (e*d - b*f)/(a*d - b*c);
							y = (a*f - e*c)/(a*d - b*c);
							JOptionPane.showMessageDialog(null, "The solution for the given linear equation X is "+ x +" and Y is "+ y, "Result", JOptionPane.PLAIN_MESSAGE);
						}
					}	
					
					
			}
			catch(Exception exp) {
				JOptionPane.showMessageDialog(null,"Exception Occured.", "Exception",JOptionPane.WARNING_MESSAGE);
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
