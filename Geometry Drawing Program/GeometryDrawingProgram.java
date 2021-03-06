/* import statements */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/** [GeometryDrawingProgram.java]
  * ICS3U6-B Unit 3 Summative
  * This program incoporates OOP to create a user interface
  * that can add, delete, translate, and display shapes
  * This file is the main class, other classes and subclasses will be
  * located in other files
  * @author Peter Gu
  * @version 1.0, 12 May 2021
  */

class GeometryDrawingProgram {
  /* Class Variables */
  static JFrame frame;
  static ArrayList<Shape> allShapes = new ArrayList<>(); // ArrayList for Shapes
  
  /**
   * pMenu
   * This method will print out the user interface (menu)
   */
  static public void pMenu(){
    System.out.println("Enter 1 to display all shapes and relevant data");
    System.out.println("Enter 2 to add a shape");
    System.out.println("Enter 3 to remove a shape");
    System.out.println("Enter 4 to translate a shape");
    System.out.println("Enter 5 to translate all shapes");
    System.out.println("Enter 6 to exit the program");
  }
  
  /**
   * pShapeChoice
   * This method will print out the selection of all shapes
   */
  static public void pShapeChoice(){
    System.out.println("Enter 1 for Oval (Drawn from center point)");
    System.out.println("Enter 2 for Circle (Drawn from center point)");
    System.out.println("Enter 3 for Rectangle (Drawn from top left point)");
    System.out.println("Enter 4 for Square (Drawn from top left point)");
    System.out.println("Enter 5 for Triangle (Drawn from top point)");
    System.out.println("Enter 6 for Rhombus (Drawn from top point)");
    System.out.println("Enter 7 for Parallelogram (Drawn from top left point)");
  }
  
  /**
   * pArray
   * This method will print out allShapes (ArrayList of shapes)
   * with the relevant information
   */
  static public void pArray(){
    System.out.println("List of Shapes:");
    
    // Loop through allShapes
    for (int i = 0; i < allShapes.size(); i++){
      System.out.printf("# %d. ", i+1); // Print out the current shape number
      allShapes.get(i).pAll(); // Calls class method pAll which prints out the relevant info for each shape
    }
    System.out.print("\n");
  }
  
  /**
   * deleteShape
   * This method accepts one integer variable which is the index of 
   * the shape that will be deleted
   * @param n the index of the shape
   * @return true if index is in range, false otherwise
   */
  static public boolean deleteShape(int n){
    if ((allShapes.size() < n) || (n <= 0)){ // Check if index is valid
      return false;
    } else{
      allShapes.remove(n-1);
      return true;
    }
  }
  
  /**
   * tShape
   * This method accepts three integer variables and will translate a shape
   * some x and y units
   * @param n the index of the shape
   * @param xS the shift on the x axis
   * @param yS the shift on the y axis
   * @return true if index is in range, false otherwise
   */
  static public boolean tShape(int n, int xS, int yS){
    if ((allShapes.size() < n) || (n <= 0)){ // Check if index is valid
      return false;
    } else{
      // Using getters and setters to change the class variables
      allShapes.get(n-1).setX(allShapes.get(n-1).getX() + xS);
      allShapes.get(n-1).setY(allShapes.get(n-1).getY() - yS);
      return true;
    }
  }
      
  /** *** Main method *** **/
  public static void main(String[] args){  
    GeometryScreen gs = new GeometryScreen();
    Scanner input = new Scanner(System.in);
    boolean ifRun = true;
    
    System.out.println("Welcome to the Best Geometry Program!\n");
    
    /* Input Variable Declaration */
    int option, shapeChoice;
    int x, y, len, height, r, g, b;
    int delOption, transOption;
    int xShift, yShift;
    
    /* Main Loop */
    do {
      pMenu(); // Output the menu
      
      try{
        // Resetting r, g, b
        r = -1; 
        g = -1; 
        b = -1; 
        option = input.nextInt();
        
        if (option == 1){
          pArray(); // Output the current shapes + relevant information
        } else if (option == 2){
          pShapeChoice(); // Output the shape choices
          shapeChoice = input.nextInt();
          
          /* Splitting choices into respective groups
           * First group will be shapes with both length and height
           * Second group will be the circle (diameter)
           * Third group will be square and triangle (equal side lengths)
           */
          if ((shapeChoice == 1) || (shapeChoice == 3) || (shapeChoice == 6) || (shapeChoice == 7)){
            
            // Taking input for all required parameters
            System.out.println("Enter the x coordinate");
            x = input.nextInt();
            System.out.println("Enter the y coordinate");
            y = input.nextInt();
            System.out.println("Enter the length");
            len = input.nextInt();
            System.out.println("Enter the height");
            height = input.nextInt();
            
            // Handling colour input
            while ((r < 0) || (r > 255) || (g < 0) || (g > 255) || (b < 0) || (b > 255)){
              System.out.println("Please enter all colours properly");
              System.out.println("Enter the red colour (0-255)");
              r = input.nextInt();
              System.out.println("Enter the green colour (0-255)");
              g = input.nextInt();
              System.out.println("Enter the blue colour (0-255)");
              b = input.nextInt();
            }
            
            // Adding the shape into the ArrayList
            if (shapeChoice == 1){
              allShapes.add(new Ellipse(x, y, len, height, r, g, b));
            } else if (shapeChoice == 3){
              allShapes.add(new Rectangle(x, y, len, height, r, g, b));
            } else if (shapeChoice == 6){
              allShapes.add(new Rhombus(x, y, len, height, r, g, b));
            } else if (shapeChoice == 7){
              allShapes.add(new Parallelogram(x, y, len, height, r, g, b));
            }
          } else if (shapeChoice == 2){
            
            // Taking input for all required parameters
            System.out.println("Enter the x coordinate");
            x = input.nextInt();
            System.out.println("Enter the y coordinate");
            y = input.nextInt();
            System.out.println("Enter the diameter");
            len = input.nextInt();
            
            // Handling colour input
            while ((r < 0) || (r > 255) || (g < 0) || (g > 255) || (b < 0) || (b > 255)){
              System.out.println("Please enter all colours properly");
              System.out.println("Enter the red colour (0-255)");
              r = input.nextInt();
              System.out.println("Enter the green colour (0-255)");
              g = input.nextInt();
              System.out.println("Enter the blue colour (0-255)");
              b = input.nextInt();
            }
            
            // Adding the shape into the ArrayList
            allShapes.add(new Circle(x, y, len, r, g, b));
          } else if ((shapeChoice == 4) || (shapeChoice == 5)){
            
            // Taking input for all required parameters
            System.out.println("Enter the x coordinate");
            x = input.nextInt();
            System.out.println("Enter the y coordinate");
            y = input.nextInt();
            System.out.println("Enter the side length");
            len = input.nextInt();
            
            // Handling colour input
            while ((r < 0) || (r > 255) || (g < 0) || (g > 255) || (b < 0) || (b > 255)){
              System.out.println("Please enter all colours properly");
              System.out.println("Enter the red colour (0-255)");
              r = input.nextInt();
              System.out.println("Enter the green colour (0-255)");
              g = input.nextInt();
              System.out.println("Enter the blue colour (0-255)");
              b = input.nextInt();
            }
            
            // Adding the shape into the ArrayList
            if (shapeChoice == 4){
              allShapes.add(new Square(x, y, len, r, g, b));
            } else if (shapeChoice == 5){
              allShapes.add(new Triangle(x, y, len, r, g, b));
            }
          } else{
            System.out.println("That is not a valid shape\n");
          }
        } else if (option == 3){
          pArray(); // Output the current shapes + relevant information
          
          // Deletes the shape at the specified index
          System.out.println("Choose the shape number to delete");
          delOption = input.nextInt();
          if (!deleteShape(delOption)){
            System.out.println("That shape does not exist\n");
          } else{
            System.out.println("Deleted!\n");
          }
        } else if (option == 4){
          pArray(); // Output the current shapes + relevant information
          
          // Translates the shape at the specified index
          System.out.println("Choose the shape number to translate");
          transOption = input.nextInt();
          System.out.println("How many units would you like to shift on the x axis?");
          xShift = input.nextInt();
          System.out.println("How many units would you like to shift on the y axis?");
          yShift = input.nextInt();
          
          // Translate shape with method tShape
          if (!tShape(transOption, xShift, yShift)){
            System.out.println("That shape does not exist\n");
          } else{
            System.out.println("Translated!\n");
          }
        } else if (option == 5){
          // Translates all existing shapes
          System.out.println("How many units would you like to shift on the x axis?");
          xShift = input.nextInt();
          System.out.println("How many units would you like to shift on the y axis?");
          yShift = input.nextInt();
          
          // Loop through allShapes
          for (int i = 0; i < allShapes.size(); i++){
            tShape(i+1, xShift, yShift); // Call method tShape
          }
        } else if (option == 6){
          // Quit the program
          ifRun = false;
        } else{
          System.out.println("That is not a valid instruction...\n");
        }
        frame.repaint(); // Update the screen
      } catch (InputMismatchException e){
        System.out.println("Please input integers!\n");
        input.nextLine(); // Clears previous bad input
      }
    }while(ifRun);
    System.out.println("Thank you for using the Best Geometry Program!");
    input.close(); // Close the scanner
  }
  
  // This is an inner class - it has access to the static variables defined above
  public static class GeometryScreen {

    // Constructor - do not modify
    GeometryScreen() {
      frame = new JFrame("Geometry Drawing Program 1.0");
      
      // Create a new "custom" panel for graphics based on the inner class below
      JPanel graphicsPanel = new GraphicsPanel();
      
      // Add the panel and the frame to the window
      frame.getContentPane().add(graphicsPanel);
      
      // Set the frame to full screen 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(520,540);
      frame.setUndecorated(false);  // Set to true to remove title bar
      frame.setVisible(true);
    } 
    
    // This is an inner class which contains all the details about drawing to screen.
    public static class GraphicsPanel extends JPanel {

      /**
       * paintComponent
       * This method is used to draw the shapes onto the graphics panel
       * @param g the graphics object to draw with
       */
      public void paintComponent(Graphics g) {          
        setDoubleBuffered(true);   
        g.setColor(Color.BLACK);
        
        // Draw the X/Y Axis
        g.drawLine(250, 0, 250, 500);
        g.drawLine(0, 250, 500, 250);
        
        // Draw all the existing shapes in allShapes
        for (int i = 0; i < allShapes.size(); i++){
          allShapes.get(i).drawShape(g);
        }
      }
    }
  }
}