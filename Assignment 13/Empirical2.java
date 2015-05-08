//Kate Maher
//Dr. Bricker

import java.util.*;

public class Empirical2 {

   public static final int INSERTIONSORT = 1;
   public static final int SELECTIONSORT = 2;
   public static final int MERGESORT = 3;

   public static void main(String[] args) {
      int[] sizesArray = {1000, 5000, 10000, 20000, 50000};
 
      int[] increasingArray = new int[sizesArray[sizesArray.length-1]];
      int[] decreasingArray = new int[sizesArray[sizesArray.length-1]];
      for (int ii = 0; ii < sizesArray[sizesArray.length-1]; ii++) {
         increasingArray[ii] = ii+1;
         decreasingArray[ii] = sizesArray[sizesArray.length-1]-ii;
      }
      int[] randomArray = Sorters.createArray(sizesArray[sizesArray.length-1]);
      
      // testing for printing initial arrays
      //System.out.println(Arrays.toString(increasingArray)); 
      //System.out.println(Arrays.toString(decreasingArray));
      //System.out.println(Arrays.toString(randomArray));
      
      long[] storingTimes = new long[sizesArray.length];
      runTimes(increasingArray, decreasingArray, randomArray, sizesArray, storingTimes);
      System.out.println(Arrays.toString(storingTimes));
   }
   
   public static long calculateTime(int[] list, int sortType) {
      System.gc();
      long beginTime = System.currentTimeMillis();
      if (sortType == INSERTIONSORT) {
         Sorters.insertionSort(list);
      }
      else if (sortType == SELECTIONSORT) {
         Sorters.selectionSort(list);
      }
      else if (sortType == MERGESORT) {
         Sorters.mergeSort(list);
      }
      long endTime = System.currentTimeMillis();
      return endTime - beginTime;
      //storingTimes[ii] = (endTime  - beginTime);
   }
   
   public static void runTimes(int[] increasingArray, int[] decreasingArray, int[] randomArray, int[] sizesArray, long[] storingTimes) {
      for (int ii= 0; ii < sizesArray.length; ii++) {
         int[] tempArray = Arrays.copyOfRange(increasingArray, 0, sizesArray[ii]);
         //long[] increasingTimes = new long[sizesArray.length-1]; 
         storingTimes[ii] = calculateTime(tempArray, INSERTIONSORT);
      }
      System.out.printf("%15s\t", "Increasing");
      for(int jj = 0; jj < storingTimes.length; jj++) {
          System.out.printf("%d\t", storingTimes[jj]);
      }
      System.out.printf("\n");
   }
         
         //int[] tempArray2 = Arrays.copyOfRange(increasingArray, 0, sizesArray[ii]);
         //System.out.printf("%15s\t", calculateTime(tempArray2, SELECTIONSORT));
         
      //}
      //use sort type instead and call this 3 three times
  
}