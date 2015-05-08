//Kate Maher

public class TeamPlayer extends Player
{
   private String position;
   
   public TeamPlayer()
   {
      this.position = position;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   public void setPosition(String newPosition)
   {
      position = newPosition;
   }
   
   public TeamPlayer(String name, boolean status, String position)
   {
      super(name, status);
      setPosition(position);
   }
   
   public TeamPlayer(String name, String position)
   {
      this(name, false, position);
   }
   
   public String toString()
   {
      return "Name: " + playerName + ", Availability: " + playerStatus + ", Position: " + position;
   }
   
   public boolean equals(Object other)
   {
      if ( other instanceof TeamPlayer)
      {
         TeamPlayer p = (TeamPlayer) other;
         return position.equals(p.position); 
      }
      return false;
   }
}