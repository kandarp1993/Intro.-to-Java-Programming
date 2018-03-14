/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 10/04/2017
 * Description - To verify whether the given password is valid or invalid.     
 **/

import javax.swing.JOptionPane;

public class C6E18CheckPassword {

	public static void main(String[] args) {
		String sErrMessage = "";
		String programDescription = "This program validates the password given by the user. \n\nNote: \n1. The password should contain at least eight characters. \n2. The password consists of only letters and digits. \n3.The password should contain at least two digits.";
		boolean continueProgram = true;
		while (continueProgram) {
			JOptionPane.showMessageDialog(null, programDescription,"Program Description", JOptionPane.INFORMATION_MESSAGE);

			try {
				String sPassword = JOptionPane.showInputDialog(null,"Please enter password", "Input",JOptionPane.QUESTION_MESSAGE);
				String passwordValidation = isPasswordValid(sPassword);
				if (passwordValidation == "InValid length") {
					sErrMessage = "A password must have at least eight characters.";
					throw new Exception(sErrMessage);
				} else if (passwordValidation == "InValid pattern") {
					sErrMessage = "A password must contain only letters and digits.";
					throw new Exception(sErrMessage);
				} else if (passwordValidation == "InValid digits") {
					sErrMessage = "A password must contain at least two digits";
					throw new Exception(sErrMessage);
				} else if (passwordValidation == "Valid") {
					JOptionPane.showMessageDialog(null,"Entered password is a valid password.", "Result",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid Password.\n\n"+ "Error Message : " + ex.getMessage(), "Exception",JOptionPane.WARNING_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,"Do you want to re-execute the program?","Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}

	private static String isPasswordValid(String pswd) {
		int ilength = 0, a = 0;
		
		if (pswd.length() < 8) {
			return "InValid length";
		} 
		else {
			for(int i=0;i<pswd.length();i++){
				if(pswd.charAt(i)>='0' && pswd.charAt(i)<='9'){
					ilength++;
				}
				else if((pswd.charAt(i)>='A' && pswd.charAt(i)<='Z') || (pswd.charAt(i)>='a' && pswd.charAt(i)<='z')){
					a++;
				}
				else{
					return "InValid pattern"; 
				}
			}
			if(ilength<2 || ilength == 0){
				return "InValid digits";
			}
			else if(ilength >=2 && a==pswd.length()-ilength)
			{
				return "Valid";
			}
			return "";
		}


	}

}
