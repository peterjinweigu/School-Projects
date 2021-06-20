/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Parallelogram.java]
  * This class represents the parallelogram shape
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Parallelogram extends Polygon{ // Inherit from Polygon
  
  /**
   * Constructor
   * The parameters specified below are required to create a parallelogram
   * @param x, y, len, height, r, g, b
   */
  Parallelogram(int x, int y, int len, int height, int r, int g, int b){
    super(x, y, len, height, r, g, b);
    this.setNumPoints(4);
  }
  
  /**
   * getAllX
   * This method will return all the x points of the parallelogram
   * @return int array that contains all the x points
   */
  public int[] getAllX(){
    int[] allX = {this.getX(), this.getX()+this.getLen(), this.getX()+this.getLen()-this.getHeight(), 
      this.getX()-this.getHeight()};
    return allX;
  }
  
  /**
   * getAllY
   * This method will return all the y points of the parallelogram
   * @return int array that contains all the y points
   */
  public int[] getAllY(){
    int[] allY = {this.getY(), this.getY(), this.getY()+this.getHeight(), this.getY()+this.getHeight()};
    return allY;
  }
  
  /**
   * getArea
   * This method will return the area of the parallelogram
   * @return double value that represents the area of the parallelogram
   */
  public double getArea(){
    // Mutiply the length by the height
    return this.getLen()*this.getHeight();
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the parallelogram
   * @return double value that represents the perimeter of the parallelogram
   */
  public double getPerimeter(){
    // Mutiply the length by 2 and add the other side by using the 45 45 90 triangle principles
    return ((this.getLen()*2) + (this.getHeight()*Math.sqrt(2)*2));
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the parallelogram
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Parallelogram", 
                      this.getArea(), this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", (this.getX() + this.getLen()/2)-250, 
                      ((this.getY() + this.getHeight()/2)-250)*-1, this.getLen(), this.getHeight());
  }
}
  