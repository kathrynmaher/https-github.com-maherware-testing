//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;

/**
    * Extends the critter class 
    * Creates the husky object to play out in the game
    */
public class CritterShell extends Critter {

   /**
    * Assigns the husky to a color
    * @return the color of the husky
    */
   public Color getColor() {
      return Color.YELLOW;
   }
   
   /**
    * Assigns information from the Husky to string
    * @return the percent of food the husky has eaten
    */
   public String toString() {
      return "H";
      }
   
   /**
    * Determines the attacking stratedgy of the husky
    * @return the plan of attack
    */   
   public Attack fight(String opponent) {
      return Attack.POUNCE;
      }
   
   /**
    * Determines the eating habits of the Husky
    * @return a boolean of whether the husky eats or not
    */   
   public boolean eat() {
      return false;
      }
      
   /**
    * Gets the direction of the husky moves
    * @return the direction the husky moves each time
    */ 
   public Direction getMove() {
      return Direction.EAST;
      } 
}