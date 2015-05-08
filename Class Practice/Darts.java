
import java.util.*;
import java.awt.*;

public class Darts {

   public static void main(String[] args) {
      Set<Point> tosses = new HashSet<Point>();
      tosses.add(new Point(10,10));
      tosses.add(new Point(-58, 100));
      tosses.add(new Point(15, -30));
      tosses.add(new Point(100, -45));
      tosses.add(new Point(2, -4));
      System.out.println(tosses);
      
      tosses.remove(new Point(10,10));
      System.out.println(tosses);
      System.out.println(tosses.contains(new Point(-58,100)));
      System.out.println(tosses.size());
      
      System.out.println("Iterating through the Set:");
      Iterator<Point> toserIter = tosses.iterator();
      while (tossesIter.hasNext())
      {
         Point toss = tossesIter.next();
         System.out.println(toss);
      }
   }

}