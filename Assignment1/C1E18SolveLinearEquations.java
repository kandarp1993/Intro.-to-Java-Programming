/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/05/2017
 * Description - This program calculates Perimeter and Radius of a Circle which has radius of 5.5    
 */

public class C1E18SolveLinearEquations {
	public static void main(String args[]){
		double area;
		double perimeter;
		final double radius = 5.5;
		final double pi = 3.14;
		
		if(radius > 0.0){
			perimeter = 2 * pi * radius;
			area = pi * radius * radius;
		}
		System.out.println("Perimeter of this circle is : "+ perimeter);
		System.out.println("Radius of this circle is : "+ area);
	}
}
