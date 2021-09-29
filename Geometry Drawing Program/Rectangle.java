/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Rectangle.java]
  * This class acts as the parent class for square and also represents a rectangle
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Rectangle extends Shape{ // Inherit from Shape
  
  /**
   * Constructor
   * The parameters specified below are required to create a rectangle
   * @param x, y, len, height, r, g, b
   */
  Rectangle(int x, int y, int len, int height, int r, int g, int b){
    super(x, y, len, height, r, g, b);
  }
  
  /**
   * getArea
   * This method will return the area of the rectangle
   * @return double value that represents the area of the rectangle
   */
  public double getArea(){
    // Mutiply the length by the height
    return this.getLen()*this.getHeight();
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the rectangle
   * @return double value that represents the perimeter of the rectangle
   */
  public double getPerimeter(){
    // Add up the length mutiplied by 2 and height mutiplied by 2
    return this.getLen()*2 + this.getHeight()*2;
  }
  
  /**
   * drawShape
   * This method will draw a rectangle
   * @param g the graphics object to draw with
   */  
  public void drawShape(Graphics g){
    g.setColor(this.getColor());
    g.drawRect(this.getX(), this.getY(), this.getLen(), this.getHeight());
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the rectangle
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Rectangle", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", (this.getX() + this.getLen()/2)-250, 
                      ((this.getY() + this.getHeight()/2)-250)*-1, this.getLen(), this.getHeight());
  }
}