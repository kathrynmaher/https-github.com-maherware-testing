//Kate Maher
//Dr. Bricker
//Computer Science 3
//Assignment 11: Milestone 1

import java.util.*;
import java.awt.*;

/**
 * Class that manages the titles in an array list
 */
public class TileManager {
   
   /**
    * Instance variable for array list 
    */
   private ArrayList<Tile> tileList;
   
   /**
    * Constructor for the TileManager 
    */
   public TileManager() {
      tileList = new ArrayList<Tile>();
   }
   
   /**
    * Adds tile to the tile list array
    * @param rect new tile 
    */
   public void addTile(Tile rect) {
      tileList.add(rect);
   }
   
   /**
    * Draws the tiles
    * @param g drawing utenstil to draw the tiles
    */
   public void drawAll(Graphics g) {
      for (int ii= 0; ii<tileList.size(); ii++) {
         Tile tileElement = tileList.get(ii);
         tileElement.draw(g);
         }
   }
   
   /**
    * Raises the first tile to the top of the screen if touched
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    */
   public void raise(int x, int y) 
   {
      Tile tileElement = goldenTile(x, y);
      if (tileElement != null) {//checks to see if tileElement is null
         tileList.remove(tileElement);//removes tile
         tileList.add(tileElement);//adds to the end
      }
   }
   
   /**
    * Lowers the first tile touched
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    */
   public void lower(int x, int y) 
   {
      Tile tileElement = goldenTile(x, y);
      if (tileElement != null) {//checks to see if null
         tileList.remove(tileElement);//removes element
         tileList.add(0, tileElement);//adds it to beginning of list
      }
   }
   
   /**
    * Deletes the first tile touched
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    */
   public void delete(int x, int y)
   {
      Tile tileElement = goldenTile(x, y);
      if (tileElement != null) {//checks to see if element is null
         tileList.remove(tileElement);//if not it removes element
      }
   }
   
   /**
    * Deletes all tiles that touch the x & y coordinates where the mouse is
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    */
   public void deleteAll(int x, int y)
   {
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         if (doesTouch(x, y, tileElement))//determines if it touches and if so deletes
         {
            tileList.remove(tileElement);
            //ii--;
         }
      }  
   }
   
   /**
    * Lowers the first tile touched
    * @param width the width of the screen
    * @param height the height of the screen
    */
   public void shuffle(int width, int height)
   {
      Collections.shuffle(tileList);//shuffles array list
      for (int ii= tileList.size(); ii> 0; ii--)//decreases by the last element in the array
      {
         Tile tileElement = tileList.get(ii-1);//gets the element
         int widthTile = tileElement.getWidth();//new variable of the width height
         int heightTile = tileElement.getHeight();
         Random r = new Random();//new random object
         int newWidth = r.nextInt((width-widthTile)-1);//new random width
         int newHeight = r.nextInt((height-heightTile)-1);//new random height
         tileElement.setY(newHeight);//sets the height
         tileElement.setX(newWidth);//sets the width
      }       
   }
   
   /**
    * Determines if the tile touches the x/y point
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    * @param rect the Tile element to see if it touches
    */
   public boolean doesTouch(int x, int y, Tile rect)
   {
      int tileXCords = rect.getX()+rect.getWidth();
      int tileYCords = rect.getY()+rect.getHeight();
      return (x >= rect.getX() && x <= tileXCords && y >= rect.getY() && y <= tileYCords) ;
   }
   
   /**
    * Determines first tile to touch the x and y point
    * @param x the xcoordinate where the mouse is
    * @param y the ycoordinate where the mouse is
    * @return element if it does touch 
    */
   public Tile goldenTile(int x, int y) 
   {
      for (int ii= tileList.size()-1; ii>= 0; ii--)
      {
         System.out.println("ii = " + ii); 
         Tile tileElement = tileList.get(ii);
         if (doesTouch(x, y, tileElement))//calls doesTouch to see if it touches
         {
            System.out.println("ii = " + ii + " " + tileElement);
            return tileElement;
         }
      }
      return null;
   }
}