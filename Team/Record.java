//Kate Maher

public class Record
{
   private int wins;
   private int losses;
   //private int percent;
   
   public Record()
   {
      wins = 0;
      losses = 0;
   }
   
   public int getWins()
   {
      return wins;
   }
   
   public int getLosses()
   {
      return losses;
   }
   
   public void setWins(int newWins)
   {
      wins = newWins;   
   }
   
   public void setLosses(int newLosses)
   {
      losses = newLosses;
   }
   
   public int won()
   {
      wins = wins + 1;
      return wins;
   }
   
   public int lost()
   {
      losses = losses + 1;
      return losses;
   }
   
   public double getPercent()
   {
      double percent = ((double) wins)/(wins+losses);
      return percent;
   }
   
   public String toString()
   {
      return wins + " wins, " + losses + " losses";
   }
   
   public boolean equals(Object other)
   {
      if ( other instanceof Record)
      {
         Record p = (Record) other;
         return Math.abs(wins - losses) < .01; 
      }
      return false;
   }
   
   public int isBetterThan(Record otherRecord)
   {
      
      if  (this.getPercent() > otherRecord.getPercent()) {
         return 1;
      }
      else if ( Math.abs(otherRecord.getPercent()- this.getPercent()) < .01 )
      {
         return 0;
      }
      else {
         return -1;
      }
   }
   
}