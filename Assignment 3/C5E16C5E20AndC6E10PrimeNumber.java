/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/21/2017
 * Description - Displays first 50 prime numbers under 1000 and  verifies whether the user given input number is prime or not.    
 **/

import javax.swing.JOptionPane;

public class C5E16C5E20AndC6E10PrimeNumber {

	public static void main(String[] args) {
		boolean continueExecution = true;
		boolean continuePrimecheck = true;
		String first50PrimeNumbers = "  ";
		int primesCount = 0;
		int[] pNArray = new int[168];

		while (continueExecution) {
			try {
				int count = 0;
				int j = 0;
				for (int i = 2; i < 1000; i++) {
					if (isPrime(i)) {
						// Add to the array;
						pNArray[j] = i;
						j++;
						primesCount++;
						if (primesCount < 51) {
							first50PrimeNumbers = first50PrimeNumbers + " " + i + " ";
							count++;
						}
						if (count == 10) {
							first50PrimeNumbers = first50PrimeNumbers + '\n';
							count = 0;
						}
					}
				}
				JOptionPane.showMessageDialog(null,"First 50 prime numbers under 1000 are: \n\n" + first50PrimeNumbers,"First 50 prime numbers", JOptionPane.INFORMATION_MESSAGE);
				
				//Repeat this loop for verifying input number is prime or not.
				while (continuePrimecheck) {
					int primeCheck = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter a number under 1000 to check if it is prime or not.","Prime or not?",JOptionPane.QUESTION_MESSAGE));
					String checkPrime = "";
					if(primeCheck < 10000){
						for (int i = 0; i < pNArray.length; i++) {
							if (pNArray[i] == primeCheck) {
								checkPrime = "It is a prime number.";
							}
						}
						if (checkPrime == "") {
							checkPrime = "Given number is not prime. Factors of the number are: \n";
								for (int i = 0; i < pNArray.length; i++) {
									if ((primeCheck > pNArray[i]) && (primeCheck % pNArray[i] == 0)) {
										checkPrime = checkPrime + pNArray[i]+ '\n';
									}
								}
						}
					}
					else{
						checkPrime = "Please enter number under 10000.";
					}
					JOptionPane.showMessageDialog(null, checkPrime,"Prime check", JOptionPane.INFORMATION_MESSAGE);

					// Ask user if the program needs to be re-executed.
					int confirmPrimeCheckOption = JOptionPane.showConfirmDialog(null,"Do you want to check another number?","Prime check repeat - confirmation",JOptionPane.YES_NO_OPTION);
					
					if (confirmPrimeCheckOption == 0)
						continuePrimecheck = true;
					else
						continuePrimecheck = false;
				}
			} 
			catch (Exception e) {
				// Display warning box if any exception occurs.
				JOptionPane.showMessageDialog(null,"Exception occured. Please try executing the program again with correct input.","Exception", JOptionPane.WARNING_MESSAGE);
			}
			
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,"Do you want to re-execute the program?","Program repeat - confirmation", JOptionPane.YES_NO_OPTION);
			
			if (confirmOption == 0)
				continueExecution = true;
			else
				continueExecution = false;
		}
	}

	// Check whether given input number is prime or not an return boolean.
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false; // Number not prime.
			}
		}
		return true; // Number is prime.
	}
}
