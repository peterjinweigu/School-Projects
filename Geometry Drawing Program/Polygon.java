/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Polygon.java]
  * This class acts as a parent class for the Parallelogram, Rhombus, and Triangle
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

abstract class Polygon extends Shape{ // Inherit from Shape
  // Class variables
  private int numPoints;
  
  /**
   * Constructor
   * The parameters specified below are required to create a shape
   * @param x, y, len, height, r, g, b
   */
  Polygon(int x, int y, int len, int height, int r, int g, int b){
    super(x, y, len, height, r, g, b);
    this.numPoints = 0; // Unique to child classes
  }
  
  /**
   * getAllX
   * This method will return all the x points of the shape
   * @return int array that contains all the x points
   */
  abstract public int[] getAllX();
  
  /**
   * getAllY
   * This method will return all the y points of the shape
   * @return int array that contains all the y points
   */
  abstract public int[] getAllY();
  
  /**
   * getNumPoints 
   * This method will return the number of points of the shape
   * @return this.numPoints
   */
  public int getNumPoints(){
    return this.numPoints;
  }
  
  /**
   * setNumPoints 
   * This method will set the number of points of the shape
   * @param n, new number of points
   */
  public void setNumPoints(int n){
    this.numPoints = n;
  }
  
  /**
   * drawShape
   * This method will draw a polygon
   * @param g the graphics object to draw with
   */  
  public void drawShape(Graphics g){
    g.setColor(this.getColor());
    // Uses previous point functions to draw shape
    g.drawPolygon(this.getAllX(), this.getAllY(), this.numPoints); 
  }
}