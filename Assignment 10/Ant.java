//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;

/**
 * Extends the critter class 
 * Creates the ant class to play out in the game
 */
public class Ant extends Critter {
   
   /**
    * Boolean instance variable and walk south value 
    */
   private boolean walkSouth;
   
   /**
    * Instance variable of an int counter  
    */
   private int counter;
   
   /**
    * Extends the critter class 
    * Creates the ant object to play out in the game
    */
   public Ant(boolean walkSouth)
   {
      this.walkSouth = walkSouth;
      counter = 0;
   }
   
   /**
    * Assigns the ant to a color
    * @return the color of the ant
    */
   public Color getColor() {
      return Color.RED;
   }
   
   /**
    * Assigns information from the ant to string
    * @return a string distinguishing the ant
    */
   public String toString() {
      return "%";
   }
   
   /**
    * Determines the attacking stratedgy of the ant
    * @return the plan of attack
    */     
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   /**
    * Determines the eating habits of the ant
    * @return a boolean of whether the ant eats or not
    */     
   public boolean eat() {
      return true;
      
   }
   
   /**
    * Gets the direction the ant moves
    * @return the direction the ant moves each time
    */    
   public Direction getMove() {
      Direction direction;
      if ((counter % 2)== 0) {
         if (walkSouth == true) {
            direction = Direction.NORTH;
         }
         else {
            direction = Direction.SOUTH;
         }
      }
      else {
         direction = Direction.WEST;
      }
      counter++;
      return direction;
   }
}