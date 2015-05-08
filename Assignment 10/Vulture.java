//Kate Maher
//February 23, 2015
//Computer Science 3

import java.awt.*;

/**
 * Extends the critter class 
 * Creates the vulture object to play out in the game
 */
public class Vulture extends Bird {
   
   /**
    * Instance variable for the hunger of the bird 
    */
   private int hunger;
   
   /**
    * Constructor for Vulture 
    * Assigns an initial value to hunger
    */
   public Vulture() {
      hunger = 1;   
   }
   
   /**
    * Assigns the vulture to a color
    * @return the color of the vulture
    */
   public Color getColor() {
      return Color.BLACK;
   }
   
   /**
    * Determines the eating habits of the vulture
    * @return a boolean of whether the vulture eats or not
    */     
   public boolean eat() {
      if (hunger == 1) {
         hunger = 0;
         return true;
         }
      else {
         return false;
         }
   }
   
   /**
    * Determines the attacking stratedgy of the vulture
    * @return the plan of attack for the vulture
    */     
   public Attack fight(String opponent) {
      hunger = 1;
      return super.fight(opponent);
      }  
}