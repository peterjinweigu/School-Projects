/* import statements*/
import java.awt.Color;
import java.awt.Graphics;

/** [Shape.java]
  * This class acts as a parent class for the rest of the shapes
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

abstract class Shape implements Draw{ // Implements drawing interface (Draw)
  // Class variables
  private int x, y;
  private int len, height;
  private Color myCol;
  
  /**
   * Constructor
   * The parameters specified below are required to create a shape
   * @param x, y, len, height, r, g, b
   */
  Shape(int x, int y, int len, int height, int r, int g, int b){
    this.x = x+250; // Adjusting (x, y) based on user input
    this.y = 250-y;
    this.len = len;
    this.height = height;
    this.myCol = new Color(r, g, b);
  }
  
  /**
   * getArea
   * This method will return the area of the shape
   * @return double value representing area of shape
   */
  public abstract double getArea();
  
  /**
   * getPerimeter
   * This method will return the perimeter of the shape
   * @return double value representing perimeter of shape
   */
  public abstract double getPerimeter();
  
  /**
   * pAll
   * This method will output all the relevant information of the shape
   */
  public abstract void pAll();
  
  /**
   * getX
   * This method will return the value of x
   * @return this.x
   */
  public int getX(){
    return this.x;
  }
  
  /**
   * getY
   * This method will return the value of y
   * @return this.y
   */
  public int getY(){
    return this.y;
  }
  
  /**
   * getLen
   * This method will return the value of len
   * @return this.len
   */
  public int getLen(){
    return this.len;
  }
  
  /**
   * getHeight
   * This method will return the value of height
   * @return this.height
   */
  public int getHeight(){
    return this.height;
  }
  
  /**
   * getColor
   * This method will return the value of myCol
   * @return this.myCol
   */
  public Color getColor(){
    return this.myCol;
  }
  
  /**
   * setX
   * This method will set the value of x
   * @param x, new x value
   */
  public void setX(int x){
    this.x = x;
  }
  
  /**
   * setY
   * This method will set the value of y
   * @param y, new y value
   */
  public void setY(int y){
    this.y = y;
  }
}
  