/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/26/2017
 * Description - Display the current year, month, and day using GregorianCalendar class.    
 **/

import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class C9E5GregorianCalendar {

	public static void main(String[] args) {
		long lMilliSeconds;
		boolean bContinueProgram = true;
		GregorianCalendar calendar = new GregorianCalendar();
		
		while (bContinueProgram) {
			try {
				int year = calendar.get(GregorianCalendar.YEAR);
				int month = calendar.get(GregorianCalendar.MONTH) + 1;
				int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
				JOptionPane.showMessageDialog(null, "Current Year: " + year+ "\n" + "Current Month: " + month + "\n"+ "Current Day: " + day + " ", "Result",JOptionPane.INFORMATION_MESSAGE);

				// setTimeInMillis(long) method sets Calendar's current time from the given long value.
				lMilliSeconds = Long.parseLong(JOptionPane.showInputDialog(null,"Enter a long value to set a specified elapsed time since January 1, 1970","Input", JOptionPane.QUESTION_MESSAGE));
				calendar.setTimeInMillis(lMilliSeconds);
				year = calendar.get(GregorianCalendar.YEAR);
				month = calendar.get(GregorianCalendar.MONTH) + 1;
				day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
				JOptionPane.showMessageDialog(null, "Modified time, Year: "+ year + "\n" + "Modified time, Month: " + month + "\n"+ "Modified time, Day: " + day + " ", "Result",JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Exception occured. Please retry the execution.","Exception", JOptionPane.ERROR_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,"Do you want to repeat the program?","Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				bContinueProgram = true;
			else
				bContinueProgram = false;
		}
	}

}
