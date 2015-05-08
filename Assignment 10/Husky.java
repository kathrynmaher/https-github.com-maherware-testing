//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;
   
   /**
    * Extends the critter class 
    * Creates the husky object to play out in the game
    */
   public class Husky extends Critter {
   
   private int counter;
   
   public Husky() 
   {
      counter = 0; 
   } 
      
   /**
    * Assigns the husky to a color
    * @return the color of the husky
    */
   public Color getColor() {
      return Color.YELLOW;
   }
   
   /**
    * Assigns information from the Husky to string
    * @return a distinguishing string for the husky
    */
   public String toString() {
      return "H";
      }
   
   /**
    * Determines the attacking stratedgy of the husky
    * Seems like pounce of the four options given was the best
    * @return the plan of attack
    */   
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
         }
      else if (opponent.equals("V") || opponent.equals("<") || opponent.equals(">") || opponent.equals("^")) {
         return Attack.SCRATCH;
         }
      else {
         return Attack.POUNCE;
         }
      }
   
   /**
    * Determines the eating habits of the Husky
    * Gain points from eating - worth the sleep
    * @return a boolean of whether the husky eats or not
    */   
   public boolean eat() {
      if (counter < 200) {
         return false;
         }
      else {
         return true;
         }
   }
      
   /**
    * Gets the direction of the husky moves
    * Hoping luck plays a role :)
    * Might add the extra features given in Critter such as setAwake() or setNeighbor()
    * @return the direction the husky moves each time
    */ 
   public Direction getMove() {
      
      Direction direction;
      if ((counter % 2)== 0) {
         direction = Direction.NORTH;
      }
      else {
         direction = Direction.WEST;
      }
      counter++;
      return direction;
   }
   
}