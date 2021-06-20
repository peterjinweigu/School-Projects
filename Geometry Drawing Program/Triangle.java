/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Triangle.java]
  * This class represents the triangle shape
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Triangle extends Polygon{ // Inherit from Polygon
  
  /**
   * Constructor
   * The parameters specified below are required to create a triangle
   * @param x, y, len, r, g, b
   */
  Triangle(int x, int y, int len, int r, int g, int b){
    super(x, y, len, (int)(len/2*Math.sqrt(3)), r, g, b);
    this.setNumPoints(3);
  }
  
  /**
   * getAllX
   * This method will return all the x points of the triangle
   * @return int array that contains all the x points
   */
  public int[] getAllX(){
    int[] allX = {this.getX(), this.getX()-(this.getLen()/2), this.getX()+(this.getLen()/2)};
    return allX;
  }
  
  /**
   * getAllY
   * This method will return all the y points of the triangle
   * @return int array that contains all the y points
   */
  public int[] getAllY(){
    int[] allY = {this.getY(), this.getY()+this.getHeight(), this.getY()+this.getHeight()};
    return allY;
  }
  
  /**
   * getArea
   * This method will return the area of the triangle
   * @return double value that represents the area of the triangle
   */
  public double getArea(){
    // Mutiply the length and height and divide by 2
    return (this.getLen()*this.getHeight())/2.0;
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the triangle
   * @return double value that represents the perimeter of the triangle
   */
  public double getPerimeter(){
    // Mutiply the length by 3
    return this.getLen()*3;
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the triangle
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Triangle", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", (this.getX() + this.getLen()/2)-250, 
                      ((this.getY() + this.getHeight()/2)-250)*-1, this.getLen(), this.getHeight());
  }
}
  