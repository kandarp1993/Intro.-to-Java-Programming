
/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/26/2017
 * Description - This class represents a rectangle.     
 **/

public class C9E1Rectangle {
	
	double dWidth = 1;
	double dHeight = 1;
	private String errorMessage = "";
	
	//No argument constructor to create default rectangle.
	public C9E1Rectangle() {
	}
	
	//A constructor that creates a rectangle with the specified width and height.
	public C9E1Rectangle(double dWidth, double dHeight) {
		this.dWidth = dWidth;
		this.dHeight = dHeight;
	}


	public double getdWidth() {
		return dWidth;
	}


	public void setdWidth(double dNewWidth) throws Exception {
		if(validate(dNewWidth)) {
			Exception e = new Exception(errorMessage);
        	throw e;	
		}
		else
			dWidth = dNewWidth;
	}


	public double getdHeight() {
		return dHeight;
	}


	public void setdHeight(double dNewHeight) throws Exception {
		if(validate(dNewHeight)) {
			Exception e = new Exception(errorMessage);
        	throw e;	
		}
		else
			dHeight = dNewHeight;
	}

	//Return area of the rectangle.
	double getArea() {
		return dWidth * dHeight;
	}
	
	//Return perimeter of the rectangle.
	double getPerimeter() {
		return 2 * (dWidth + dHeight);
	}
	
	public String getErrorMessage() { System.out.println("1"+errorMessage); return errorMessage; }
		
	//Validation method.
	boolean validate(double value) throws Exception{
		if(value < 0){
			errorMessage = "Width or height cannot be negative.";
			return true;
		}
		else if(value ==0) {
			errorMessage = "Width or height cannot be 0.";
			return true;
		}
		else
			return false;	
	}
	
	

}
