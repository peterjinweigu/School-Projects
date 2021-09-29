/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Circle.java]
  * This class represents the circle shape
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Circle extends Ellipse{ // Inherit from Ellipse
  
  /**
   * Constructor
   * The parameters specified below are required to create a circle
   * @param x, y, diam, r, g, b
   */
  Circle(int x, int y, int diam, int r, int g, int b){
    super(x, y, diam, diam, r, g, b);
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the circle
   * @return double value that represents the perimeter of the circle
   */
  public double getPerimeter(){
    // Diameter mutiplied by PI
    return this.getLen()*Math.PI;
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the circle
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Circle", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Diameter: %d\n", this.getX()-250, (this.getY()-250)*-1, this.getLen());
  }
}