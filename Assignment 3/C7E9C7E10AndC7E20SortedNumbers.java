/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/21/2017
 * Description - Display the minimum number and its index, then the numbers get sorted and display the sorted list.     
 **/

import javax.swing.JOptionPane;

public class C7E9C7E10AndC7E20SortedNumbers {

	public static void main(String[] args) {
		//Separate the input given by user using comma.
		
		boolean continueExecution = true;
		while (continueExecution) {
			try{
				String input = JOptionPane.showInputDialog(null, "Enter the  10 numbers separated with comma","User Input",JOptionPane.QUESTION_MESSAGE);	
				String[] inputs = input.split(",");
				double[] values = new double[10];		
				String sorted = ""; 
		
				if(inputs.length == 10){
					for(int i=0;i<inputs.length;i++){
						values[i] = Double.parseDouble(inputs[i]);
					}
				
					double minVal = min(values);
					JOptionPane.showMessageDialog(null, "The smallest element "+minVal,"Minimum Number", JOptionPane.INFORMATION_MESSAGE);
		
					int minIndex = minIndex(values);
					JOptionPane.showMessageDialog(null, "The index of the smallest element "+minIndex,"Minimum number's index", JOptionPane.INFORMATION_MESSAGE);
				
					selectionSort(values);
					
					for (double e: values) {
						sorted = sorted + " " + e + " ";
					}
					JOptionPane.showMessageDialog(null, sorted,"Sorted Numbers", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Exception occured. Please try executing the program again with correct input.","Exception", JOptionPane.WARNING_MESSAGE);
			}
			int confirmOption = JOptionPane.showConfirmDialog(null,"Do you want to re-execute the program?","Program repeat - confirmation", JOptionPane.YES_NO_OPTION);
			
			if (confirmOption == 0)
				continueExecution = true;
			else
				continueExecution = false;
		}	
	}
	
	//Find the smallest element
	public static double min(double[] array){
		double  min = array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]<min){
				min = array[i];
			}
		}
		
		return min;
		
	}
	// Find the index of the smallest element
	public static int minIndex(double[] array){
		double  min = array[0];
		int index = 0;
		for(int i=1;i<array.length;i++){
			if(array[i]<min){
				index = i;
			}
		}
		
		return index;
		
	}
	/** selsctionSort sorts array in accending order */
	public static void selectionSort(double[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			// Find the maximum in the list[i+1...list.length]
			double currentMax = list[i];
			int currentMaxIndex = i;

			for (int j = i - 1; j >= 0; j--) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}

			// Swap list[i] with list[currentMax] if necessary
			if (currentMaxIndex != i) {
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
		}
	}
}
