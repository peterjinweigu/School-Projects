/* import statements */
import java.awt.Color;
import java.awt.Graphics;

/** [Ellipse.java]
  * This class acts as the parent class for circle and also represents and ellipse/oval
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class Ellipse extends Shape{ // Inherit from Shape
  
  /**
   * Constructor
   * The parameters specified below are required to create an ellipse
   * @param x, y, len, height, r, g, b
   */
  Ellipse(int x, int y, int len, int height, int r, int g, int b){
    super(x, y, len, height, r, g, b);
  }
  
  /**
   * getArea
   * This method will return the area of the ellipse
   * @return double value that represents the area of the ellipse
   */
  public double getArea(){
    // Mutiply both radii and PI
    return (this.getLen()/2.0)*(this.getHeight()/2.0)*Math.PI;
  }
  
  /**
   * getPerimeter
   * This method will return the perimeter of the ellipse
   * @return double value that represents the area of the ellipse
   */
  public double getPerimeter(){
    // Ellipse perimeter approximation formula
    double d = Math.sqrt(((this.getLen()/2.0)*(this.getLen()/2.0)+(this.getHeight()/2.0)*(this.getHeight()/2.0))/2.0);
    return Math.PI*2*d;
  }
  
  /**
   * drawShape
   * This method will draw an ellipse
   * @param g the graphics object to draw with
   */  
  public void drawShape(Graphics g){
    g.setColor(this.getColor());
    g.drawOval(this.getX(), this.getY(), this.getLen(), this.getHeight());
  }
  
  /**
   * pAll
   * This method will output all the relevant information of the ellipse
   */ 
  public void pAll(){
    // Use printf to format the output
    System.out.printf("Type: %s, Area: %.2f, Perimeter: %.2f, Colour (R, G, B): (%d, %d, %d)\n", "Oval", this.getArea(),
                      this.getPerimeter(), this.getColor().getRed(), this.getColor().getGreen(), 
                      this.getColor().getBlue());
    System.out.printf("Center Point (x, y): (%d, %d), Length: %d, Height: %d\n", this.getX()-250, (this.getY()-250)*-1, 
                      this.getLen(), this.getHeight());
  }
}
    
  