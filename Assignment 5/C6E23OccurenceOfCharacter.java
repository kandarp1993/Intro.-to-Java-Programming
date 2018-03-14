/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 10/04/2017
 * Description - This program takes as input a string and counts the occurrence of a user entered character in that string.     
 **/

import javax.swing.JOptionPane;

public class C6E23OccurenceOfCharacter {
	
	public static void main(String args[]){
		
		String sDescription = "This program takes as input a string and a character and "+ "counts the occurrence of the character in that string";
		boolean bString = true;
		boolean bCharacter = true;
		
		while(bString){
			JOptionPane.showMessageDialog(null, sDescription, "Description", JOptionPane.INFORMATION_MESSAGE);
			//Taking as input a string
			String sSentence = JOptionPane.showInputDialog(null, "Enter a String", "Input", JOptionPane.QUESTION_MESSAGE);
			while(bCharacter){
				//Taking input a character to find its occurrence in string
				String sChar = JOptionPane.showInputDialog(null,"Enter a single character to find its occurrence in the string" ,"Input", JOptionPane.QUESTION_MESSAGE);
				char cWord = sChar.charAt(0);
				//Calling method to count the occurrence of character
				int count = Totaloccurence(sSentence,cWord);
				String output = "Entered String : "+sSentence+"\nEntered Character : "+sChar+"\nNumber of occurrences of character in string : "+count;
				JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
				int confirm =JOptionPane.showConfirmDialog(null,"Do you want count occurrence of any other character","Repeat",JOptionPane.YES_NO_OPTION);	
				if (confirm == 0)
					bCharacter = true;
				else
					bCharacter = false;
			}
			int confirmOption=JOptionPane.showConfirmDialog(null,"Do you want to repeat the program for another string","Repeat",JOptionPane.YES_NO_OPTION);
			if(confirmOption == 0){
				bString = true;
				bCharacter = true;
			}
			else
				bString = false;
		}
	}
	//Method to count the occurrence of character in string 
	public static int Totaloccurence(String sWord, char word) {
		
		int count = 0;
		for(int i = 0 ; i < sWord.length(); i++){
			//Comparing each character of string with the entered character
			if(sWord.charAt(i) == word){
				count++;
			}
		}
		return count;
		
	}

}
