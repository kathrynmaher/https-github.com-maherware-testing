//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;

/**
 * Extends the critter class 
 * Creates the bird class to play out in the game
 */
public class Bird extends Critter {
   
   /**
    * Instance variable of the previous direction 
    */
   private Direction lastMove;
   
   /**
    * Instance variable for an integer counter to increment throughout 
    */
   private int counter;
   
   /**
    * Constructor for Bird 
    * Assigns an initial value to counter
    */
   public Bird() {
      counter = 0; 
   }
   
   /**
    * Assigns the bird to a color
    * @return the color of the blue
    */
   public Color getColor() {
      return Color.BLUE;
   }
   
   /**
    * Assigns information from the bird to string
    * @return a string distinguishing the bird
    */
   public String toString() {
      if (lastMove == Direction.EAST) {
         return ">";
         }
      else if (lastMove == Direction.SOUTH)  {
         return "V";
         }
      else if (lastMove == Direction.WEST) {
         return "<";
         }
      else {
         return "^";
         }
   }
   
   /**
    * Determines the attacking stratedgy of the bird
    * @return the plan of attack
    */     
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {//attack made dependent on opponent
         return Attack.SCRATCH;
         }
      else {
         return Attack.POUNCE;
         }
   }
   
   /**
    * Determines the eating habits of the bird
    * @return a boolean of whether the bird eats or not
    */     
   public boolean eat() {
      return false;
   }
   
   /**
    * Gets the direction the bird moves
    * @return the direction the bird moves each time
    */    
   public Direction getMove() {
      if (counter < 3) {
         counter++;
         lastMove = Direction.NORTH;
         }
      else if (3 <= counter && counter < 6) {
         counter++;
         lastMove = Direction.EAST;
         }
      else if (6 <= counter && counter < 9) {
         counter++;
         lastMove = Direction.SOUTH;
         }
      else if (9 <= counter && counter < 12) {
         counter++;
         lastMove= Direction.WEST;
         }
      else {
         counter = 1;
         lastMove = Direction.NORTH;
         }
   return lastMove;
   }
}