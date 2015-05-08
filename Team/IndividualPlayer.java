//Kate Maher

public class IndividualPlayer extends Player
{
   private Record r;
   
   public IndividualPlayer()
   {
      this("", false);
   }
   
   public IndividualPlayer(String name, boolean availability)
   {
      this(name, false, new Record());
      
   }
   
   public IndividualPlayer(String name, boolean availability, Record record)
   {
      super(name, availability);
      setRecord(record);
   }
   
   public Record getRecord()
   {
      return r;
   }
   
   public void setRecord(Record record)
   {
      r = record;
   }
   
   public boolean equals(Object other)
   {
      if ( other instanceof IndividualPlayer)
      {
         IndividualPlayer p = (IndividualPlayer) other;
         return r.equals(p.r); 
      }
      return false;
   }
   
   public int getWins() {
      return r.getWins();
   }
   
   public int getLosses() {   
      return r.getLosses();
   }
   
   public void setWins(int w) {
      r.setWins(w);
   }
   
   public void setLosses(int w) {
      r.setLosses(w);
   }
   
   public void won() {
      r.won();
   }
   
   public void lost() {
      r.lost();
   }
   
   public double getPercenet() {
      return r.getPercent();
   }
   
   public int isBetterThan(Record c) {
      return r.isBetterThan(c);
   }
}