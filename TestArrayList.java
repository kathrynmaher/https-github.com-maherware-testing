import java.util.*;

public class TestArrayList
{
   public static void main(String[] args)
   {
      ArrayList<String> foo = new ArrayList<String>();
      foo.add("Hello");
      foo.add("world");
      foo.add("Jack");
      foo.add("!!!!");
      foo.add("!");
      System.out.println(foo);
      foo.remove(3);
      System.out.println(foo);
      foo.remove("Jack");
      System.out.println(foo);
      System.out.println("The array now has " + foo.size() + " elements");
      
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(4);
      list.add(6);
      int product = list.get(0) * list.get(1);
      System.out.println("product = " + product);
      
      list.add(5);
      list.add(10);
      list.add(0);
      list.add(-1);
      list.add(4);
      System.out.println("before " + list);
      Collections.sort(list);
      System.out.println("after " + list);
   }
}