/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Square.java]
  * This class represents the square shape
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Square extends Rectangle{ // Inherit from Rectangle
  
  /**
   * Constructor
   * The parameters specified below are required to create a square
   * @param x, y, len, r, g, b
   */
  Square(int x, int y, int len, int r, int g, int b){
    super(x, y, len, len, r, g, b);
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the square
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Square", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", (this.getX() + this.getLen()/2)-250, 
                      ((this.getY() + this.getHeight()/2)-250)*-1, this.getLen(), this.getHeight());
  }
}