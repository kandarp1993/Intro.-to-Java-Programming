/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 09/11/2017
 * Description - Calculate estimated area  enclosed by Atlanta, Georgia,Orlando, Florida; Savannah, Georgia; and Charlotte, North Carolina.
 */

public class C4E3EstimateArea {
	private static final double AVERAGE_EARTH_RADIUS = 6371.01;

    public static void main(String[] args) {

        double atlantaGeoY = -84.3879824;
        double atlantaGeoX = 33.7489954;

        double orlandoFLY = -81.3792364999;
        double orlandoFLX = 28.5383355;

        double SavannahGeoY = -81.09983419999998;
        double SavannahGeoX = 32.0835407;

        double charlotteNCY = -80.84312669999997;
        double charlotteNCX = 35.2270869;

        // Getting sides for 2 triangles
        double Triangel1Side1 = distanceBetweenTwoPoints(atlantaGeoX, atlantaGeoY, SavannahGeoX, SavannahGeoY);
        double Triangel1Side2 = distanceBetweenTwoPoints(SavannahGeoX, SavannahGeoY, charlotteNCX, charlotteNCY);
        double Triangel1Side3 = distanceBetweenTwoPoints(charlotteNCX, charlotteNCY, atlantaGeoX, atlantaGeoY);
        
        double Triangel2Side1 = distanceBetweenTwoPoints(atlantaGeoX, atlantaGeoY, orlandoFLX, orlandoFLY);
        double Triangel2Side2 = distanceBetweenTwoPoints(orlandoFLX, orlandoFLY, SavannahGeoX, SavannahGeoY);
        double Triangel2Side3 = distanceBetweenTwoPoints(SavannahGeoX, SavannahGeoY, atlantaGeoX, atlantaGeoY);
        
        //Print distance for Triangle 1 which is covered by Atlanta,Savannah and Charlotte.
        System.out.println("Distance from Atlanta to Savannah :"+Triangel1Side1);
        System.out.println("Distance from Savannah to Charlotte :"+Triangel1Side2);
        System.out.println("Distance from Charlotte to Atlanta :"+Triangel1Side3);
        
      //Print distance for Triangle 1 which is covered by Atlanta,Orlando and Savannah.
        System.out.println("Distance from Atlanta to Orlando :"+Triangel2Side1);
        System.out.println("Distance from Orlando to Savannah :"+Triangel2Side2);
        System.out.println("Distance from Savannah to Atlanta :"+Triangel2Side3);



        // If they are a triangle, add both areas to get
        // total area
            double area1 = getTriangleArea(Triangel1Side1, Triangel1Side2, Triangel1Side3);
            System.out.println("Area For First Triangle is "+ area1);
            double area2 = getTriangleArea(Triangel2Side1, Triangel2Side2, Triangel2Side3);
            System.out.println("Area For First Triangle is "+ area2);

            double totalArea = area1 + area2;
            System.out.println("The area of the triangle is " + totalArea);

    }

    public static double distanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {

        double distance = AVERAGE_EARTH_RADIUS *
                Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
                        Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2)));

        return distance;
    }

    public static double getTriangleArea(double side1, double side2, double side3) {

        double s = (side1 + side2 + side3) / 2.0;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

}
