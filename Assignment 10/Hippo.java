//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Extends the critter class 
 * Creates the hippo to play out in the game
 */
public class Hippo extends Critter {
   
  /**
   * Instance variable int of whether or not the hippo is hungry
   */
   private final int hunger;
   
   /**
   * Instance variable counter to increase with hunger
   */
   private int counter;
   
   /**
   * Random direction that will be used later on
   */
   private Direction randomDirection;
   
   /**
   * Instance variable to increase with each move
   */
   private int move;
   
   /**
    * Constructor for hippo object 
    */
   public Hippo(int hunger) {
      this.hunger = hunger;
      counter = 0;
      move = 5;
   }
   
   /**
    * Assigns the hippo to a color dependent on if it's hungry
    * @return the color of the hippo
    */
   public Color getColor() {
      if ((hunger-counter) < 0) {
         return Color.GRAY;
         }
      else {
         return Color.WHITE;
         }
   }
   
   /**
    * Assigns information from the hippo to string
    * @return a string distinguishing the hippo
    */
   public String toString() {
      if ((hunger-counter) >  0) {//subtracts the hunger from the counter place
         return "" + (hunger-counter) + "";
         }
      else {
         return "0";
         }
   }
   
   /**
    * Determines the attacking stratedgy of the hippo
    * @return the plan of attack for the hippo
    */     
   public Attack fight(String opponent) {
      if ((hunger-counter) < 0) { //eating strategy is dependment on hunger
         return Attack.SCRATCH;
         }
      else {
         return Attack.POUNCE;
         }
   }
   
   /**
    * Determines the eating habits of the hippo
    * @return a boolean of whether the hippo eats or not
    */     
   public boolean eat() {
      if (counter < hunger) {
         counter++;
         return true;
         }
      else {
         return false;
         }
   }
   
   /**
    * Gets the direction the hippo moves
    * @return the direction the hippo moves each time
    */    
   public Direction getMove() 
   {
      if (move >= 0 && move < 4) {
         move++;
         return randomDirection;
         }
      else {
         move = 0;
         Random random = new Random();
         int direction = random.nextInt(4);
         if (direction == 0) { //if statements to determine direction 
            randomDirection = Direction.NORTH;
            }
         else if (direction == 1) {
            randomDirection = Direction.EAST;
            }
         else if (direction == 2) {
            randomDirection = Direction.SOUTH;
            }
         else {
            randomDirection = Direction.WEST;
            }
         }
         return randomDirection;
    }
}