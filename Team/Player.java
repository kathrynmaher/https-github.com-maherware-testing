//Kate Maher

public class Player implements Comparable<Player>
{
   public String playerName;
   public boolean playerStatus;
   //private String position;
   
   public Player(String playerName, boolean playerStatus)
   {
      this.playerName = playerName;
      this.playerStatus = playerStatus;  
   }
   
   public String getName()
   {
      return playerName;
   }
   
   public void setName(String newName)
   {
      playerName = newName;
   }
   
   public Boolean getStatus()
   {
      return playerStatus;
   }
   
   public void setStatus(Boolean newStatus)
   {
      playerStatus = newStatus;
   }
   
   public Player(String name)
   {
      name = playerName;
      playerStatus = false;
   }
   
   public Player()
   {
      this("", false);
   }
   
   public String toString()
   {
      return "Name: " + playerName + ", Availability: " + playerStatus;
   }
   
   public boolean equals(Object other)
   {
      if ( other instanceof Player)
      {
         Player p = (Player) other;
         return playerName.equals(p.playerName); 
      }
      return false;
   }
   
   public int compareTo(Player other)
   {
      return compareTo(other);
   }
   
   public void sort()
   {
      //c.shuffle();
   }   

}