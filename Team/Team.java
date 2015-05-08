//Kate Maher

import java.awt.*;
import java.util.*;

public abstract class Team extends Player {

   private ArrayList<Player> roster;
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYING_NUM;
   private int counter = 0;
   private String teamName; 
   private Record r;
 
   public Team(int rosterSize, int playNum) {
      if (rosterSize < 0 || playNum < 0) {
         throw new IllegalArgumentException();
         }
      else {
         this.MAX_ROSTER_SIZE = rosterSize;
         this.MIN_PLAYING_NUM = playNum;
         }
      this.r = new Record();
   }
   
   public ArrayList<Player> getRoster()
   {
      return roster;
   }
   
   public void setRoster(ArrayList<Player> newRoster) 
   {
      roster = newRoster;
   }
   
   public Record getRecord() {
      return r;
   }
   
   public void setRecord(Record newR) {
      r = newR;
   }
   
   public String getName() {
      return teamName;
   }
   
   public void setName(String newTeamName)
   {
      teamName = newTeamName;
   }
   
   public String toString() {
      String teamNames = "";
      for (int ii= 0; ii< counter; ii++) {
          teamNames += roster.get(ii);
          teamNames += "\n";
         }
      return teamNames;
   }
   
   public void addPlayer(Player c) 
	{
      if (roster.size() == MAX_ROSTER_SIZE) {
         throw new IllegalArgumentException();
         }
      else {
         roster.add(c); 
         counter++;
         }
	}
   
   public boolean removePlayer(String name)
   {
      if (counter >= 1) {
         for (int ii= 0; ii < counter; ii++)
         {
            if (roster.get(ii).equals(name)) {
               roster.set(counter, null);
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
      for (int ii= 0; ii< roster.size(); ii++) {
         if (roster.get(ii) != null && roster.get(ii).getName().equals(name)) {
            player = roster.get(ii);
            }
         else {
            player = null;
            }
      }
      return player;
   }
   
   public int getRosterSize() {
      return roster.size();
      }
   
   public void updatePlayerStatus(String name, boolean newStatus) {
      for (int ii= 0; ii< roster.size(); ii++) {
         if (roster.get(ii) != null && roster.get(ii).getName().equals(name)) {
            roster.get(ii).setStatus(newStatus);
            }
         }
   }
   
   public boolean canFieldTeam() {
      if (roster.size() >= MIN_PLAYING_NUM) {
         return true;
         }
      else {
         return false;
         }
   }
   
   public int compareTo(Player other) {
      return getName().compareTo(other.getName());
   }
   
   public abstract boolean shouldFieldATeam();
}
