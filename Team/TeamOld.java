//Kate Maher

import java.awt.*;

public abstract class TeamOld extends Player {

   private List<Player> roster;
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYING_NUM;
   private int counter = 0;

   public TeamOld(int rosterSize, int playNum) {
      if (rosterSize < 0 || playNum < 0) {
         throw new IllegalArgumentException();
         }
      else {
         this.MAX_ROSTER_SIZE = rosterSize;
         this.MIN_PLAYING_NUM = playNum;
         }
   }
   
   public String toString() {
      String teamNames = "";
      for (int ii= 0; ii< counter; ii++) {
          teamNames += roster[ii];
          teamNames += "\n";
         }
      return teamNames;
   }
   
   public void addPlayer(Player c) 
	{
      if (roster.length == MAX_ROSTER_SIZE) {
         throw new IllegalArgumentException();
         }
      else {
         roster[counter] = c;  
         counter++;
         }
	}
   
   public boolean removePlayer(String name)
   {
      if (counter >= 1) {
         for (int ii= 0; ii < counter; ii++)
         {
            if (roster[ii].equals(name)) {
               roster[counter] = null;
               return true;
               }
            }
         }
      else {
         throw new IllegalArgumentException();
         }
         return false;
   }
   
   public Player findPlayer(String name)
   {
      Player player = null;
      for (int ii= 0; ii< roster.length; ii++) {
         if (roster[ii] != null && roster[ii].getName().equals(name)) {
            player = roster[ii];
            }
         else {
            player = null;
            }
      }
      return player;
   }
   
   public int getRosterSize() {
      return counter;
      }
   
   public void updatePlayerStatus(String name, boolean newStatus) {
      for (int ii= 0; ii< roster.length; ii++) {
         if (roster[ii] != null && roster[ii].getName().equals(name)) {
            roster[ii].setStatus(newStatus);
            }
         }
   }
   
   public boolean canFieldTeam() {
      if (roster.length >= MIN_PLAYING_NUM) {
         return true;
         }
      else {
         return false;
         }
   }
   
   public abstract boolean shouldFieldATeam();
}
