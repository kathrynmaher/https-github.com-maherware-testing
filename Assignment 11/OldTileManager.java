//Kate Maher
//Dr. Bricker
//Computer Science 3
//Assignment 11: Milestone 1

import java.util.*;
import java.awt.*;

/**
 * Class that manages the titles in an array list
 */
public class OldTileManager {
   
   /**
    * Instance variable for array list 
    */
   private ArrayList<Tile> tileList = new ArrayList<Tile>();
   
   /**
    * Constructor for the TileManager 
    */
   public OldTileManager() {
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
   
   public void raise(int x, int y) 
   {
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         if (doesTouch(x, y, tileElement))
         {
            tileList.remove(tileElement);
            tileList.add(tileElement);
            break;
         }
      }
         
   }
   
   public void lower(int x, int y) 
   {
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         if (doesTouch(x, y, tileElement))
         {
            tileList.remove(tileElement);
            tileList.add(0, tileElement);
            break;
         }
      }
   }
   
   public void delete(int x, int y)
   {
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         if (doesTouch(x, y, tileElement))
         {
            tileList.remove(tileElement);
            break;
         }
      }
   }
   
   public void deleteAll(int x, int y)
   {
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         if (doesTouch(x, y, tileElement))
         {
            tileList.remove(tileElement);
         }
      }  
   }
   
   public void shuffle(int width, int height)
   {
      Collections.shuffle(tileList);
      for (int ii= tileList.size(); ii> 0; ii--)
      {
         Tile tileElement = tileList.get(ii-1);
         int widthTile = tileElement.getWidth();
         int heightTile = tileElement.getHeight();
         Random r = new Random();
         int newWidth = r.nextInt((width-widthTile)-1);
         int newHeight = r.nextInt((height-heightTile)-1);
         tileElement.setY(newHeight);
         tileElement.setX(newWidth);
      }      
         
   }
   
   public boolean doesTouch(int x, int y, Tile rect)
   {
      boolean touch = false;
      int tileXCords = rect.getX()+rect.getWidth();
      int tileYCords = rect.getY()+rect.getHeight();
      if (x >= rect.getX() && x <= tileXCords && y >= rect.getY() && y <= tileYCords) 
      {
         touch = true;
      }
      else 
      {
         touch = false;
      }
      return touch;
   }
}