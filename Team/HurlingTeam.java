//Kate Maher
//Kate Maher

import java.awt.*;

public class HurlingTeam extends Team {

   private Player[] roster;
   
   public HurlingTeam(int max, int min) {
      super (min, max);
      }
   
   public void updatePosition(String name, String newPosition) {
      Player p = findPlayer(name);
      if (p instanceof TeamPlayer) {
         ((TeamPlayer)p).setPosition(newPosition);
         }
   }
   
   public boolean shouldFieldATeam() {
      boolean canField = false;
      for (int ii= 0; ii <= roster.length; ii++) {
         if (roster[ii].equals("defender")) {
            canField = true;
            }
         else if (roster[ii].equals("forward")) {
            canField = true;
            }
         else if (roster[ii].equals("midfielder")) {
            canField = true;
            }
         else {
            canField = false;
            }
      }
      return canField;
   }
}