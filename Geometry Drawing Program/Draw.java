/* import statements */
import java.awt.Graphics;
import java.awt.Color;

/** [Draw.java]
  * This class acts as the interface for drawing shapes
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

public interface Draw{
  
  /**
   * drawShape
   * This method will draw the shape
   * @param g the graphics object to draw with
   */
  public void drawShape(Graphics g);
}