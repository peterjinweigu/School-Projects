/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Rhombus.java]
  * This class represents the rhombus shape
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Rhombus extends Polygon{ // Inherit from Polygon
  
  /**
   * Constructor
   * The parameters specified below are required to create a rhombus
   * @param x, y, len, height, r, g, b
   */
  Rhombus(int x, int y, int len, int height, int r, int g, int b){
    super(x, y, len, height, r, g, b);
    this.setNumPoints(4);
  }
  
  /**
   * getAllX
   * This method will return all the x points of the rhombus
   * @return int array that contains all the x points
   */
  public int[] getAllX(){
    int[] allX = {this.getX(), this.getX()-this.getLen()/2, this.getX(), this.getX()+this.getLen()/2};
    return allX;
  }
  
  /**
   * getAllY
   * This method will return all the y points of the rhombus
   * @return int array that contains all the y points
   */
  public int[] getAllY(){
    int[] allY = {this.getY(), this.getY()+this.getHeight()/2, this.getY()+this.getHeight(), 
      this.getY()+this.getHeight()/2};
    return allY;
  }
  
  /**
   * getArea
   * This method will return the area of the rhombus
   * @return double value that represents the area of the rhomubs
   */
  public double getArea(){
    // Mutiply length by the height
    return (this.getLen()*this.getHeight())/2.0;
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the rhombus
   * @return double value that represents the perimeter of the rhombus
   */
  public double getPerimeter(){
    // Find the length of a side by using pythagorean formula
    double sideLen = Math.sqrt((this.getLen()/2.0)*(this.getLen()/2.0) + (this.getHeight()/2.0)*(this.getHeight()/2.0));
    return sideLen*4; // Then mutiply by 4
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the rhombus
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Rhombus", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", (this.getX() + this.getLen()/2)-250, 
                      ((this.getY() + this.getHeight()/2)-250)*-1, this.getLen(), this.getHeight());
  }
}
  