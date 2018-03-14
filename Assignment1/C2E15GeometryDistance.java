/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/06/2017
 * Description - Write a program that prompts the user to enter two points (x1, y1) and (x2, y2) and displays their distance between them.
 */

//import scanner from Util package.
import java.util.Scanner;

public class C2E15GeometryDistance {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		//Prompt user to enter two points
		System.out.print("Enter x1 and y1 : ");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		System.out.print("Enter x2 and y2 :");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		
		double result = CalculateDistance(x1, y1, x2, y2);
		//Display result
		System.out.println("The distance between two points is : "+ result);
	}
	
	// Calculate distance between two points
	private static double CalculateDistance (double x1,double y1, double x2, double y2 ){
		
		double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		return distance;
		
	}
}
