/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 10/04/2017
 * Description - This program finds the number of characters, words and lines in a  file.     
 **/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class C12E13CountCharactersLinesWordsFromFile {
	public static void main(String[] args) throws IOException {
		boolean bRepeat = true;
		String programDescription = "This program displays the number of characters, words, and lines in the given file. ";
		while (bRepeat) {
			int numberOfCharacters = 0, numberOfWords = 0, numberOfLines = 0;
			//JFileChooser to choose a file
			JFileChooser fileChooser = new JFileChooser();
			
			JOptionPane.showMessageDialog(null, programDescription,"Program Description", JOptionPane.INFORMATION_MESSAGE);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
					    StringBuilder sb = new StringBuilder();
					    String line = br.readLine();
		
					    while (line != null) {
					        sb.append(line);
					        sb.append(System.lineSeparator());
					        line = br.readLine();
					    }
					    String sFile = sb.toString();
					    //Regular expression to match a word
					    Matcher checkWord = Pattern.compile("\\b\\S+?\\b").matcher(sFile);
					    //Regular expression to match a line
						Matcher checkLine = Pattern.compile("\\r?\\n").matcher(sFile);
						String ev = sFile.replaceAll("\\s+", "");
						//Regular expression to match a character
						Matcher checkCharacter = Pattern.compile(".").matcher(ev);
						
						while(checkWord.find()) {
							numberOfWords++;
						}
						while(checkCharacter.find()) {
							numberOfCharacters++;
						}
						while(checkLine.find()) {
							numberOfLines++;
						}
		
						JOptionPane.showMessageDialog(null, "The File you selected is "
								+ selectedFile.getAbsolutePath() + "\nNumber of Lines in the file : " + numberOfLines
								+ "\nNumber of Words in the file : " + numberOfWords + 
								"\nNumber Of Characters in the file : " + numberOfCharacters);
					}
				
					catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "The File Does not Exists.");
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Exception occured.", "Exception",JOptionPane.WARNING_MESSAGE);
				}
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,
					"Do you want to re-execute the program?",
					"Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				bRepeat = true;
			else
				bRepeat = false;
		}
	}
}

