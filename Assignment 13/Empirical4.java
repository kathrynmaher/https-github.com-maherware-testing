//Kate Maher
//Dr.Bricker

import java.util.*;

public class Empirical4 {

   public static final int INSERTIONSORT = 1;
   public static final int SELECTIONSORT = 2;
   public static final int MERGESORT = 3;
   public static final int ARRAYSSORT = 4;

   public static void main(String[] args) {
      int[] sizesArray = {1000, 5000, 10000, 20000, 50000};
      int[] increasingArray = new int[sizesArray[sizesArray.length-1]];
      int[] decreasingArray = new int[sizesArray[sizesArray.length-1]];
      for (int ii = 0; ii < sizesArray[sizesArray.length-1]; ii++) {
         increasingArray[ii] = ii+1;
         decreasingArray[ii] = sizesArray[sizesArray.length-1]-ii;
      }
      int[] randomArray = Sorters.createArray(sizesArray[sizesArray.length-1]);
      long[] storingTimes = new long[sizesArray.length];
      
      printTable(sizesArray, "Increasing", increasingArray, sizesArray, storingTimes);
      printTable(sizesArray, "Decreasing", decreasingArray, sizesArray, storingTimes);
      printTable(sizesArray, "Random", randomArray, sizesArray, storingTimes);
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
      else if (sortType == ARRAYSSORT) {
         Arrays.sort(list);
      }
      long endTime = System.currentTimeMillis();
      return endTime - beginTime;
   }
   
   public static void runTimes(int[] testingArray, int[] sizesArray, long[] storingTimes, String name, int sortType) {
      for (int ii= 0; ii < sizesArray.length; ii++) {
         int[] tempArray = Arrays.copyOfRange(testingArray, 0, sizesArray[ii]);
         storingTimes[ii] = calculateTime(tempArray, sortType);
      }
      System.out.printf("%15s\t", name);
      for(int jj = 0; jj < storingTimes.length; jj++) {
          System.out.printf("%d\t", storingTimes[jj]);
      }
      System.out.printf("\n");
   } 
   
   public static void printTable(int[] times, String type, int[] arrayType, int[] sizesArray, long[] storingTimes) {
      System.out.printf("%15s\t", type);
      for(int ii = 0; ii < times.length; ii++) {
         System.out.printf("%d\t", times[ii]);
         }
         System.out.printf("\n");
      runTimes(arrayType, sizesArray, storingTimes, "selectionSort", SELECTIONSORT);
      runTimes(arrayType, sizesArray, storingTimes, "insertionSort", INSERTIONSORT);
      runTimes(arrayType, sizesArray, storingTimes, "mergeSort", MERGESORT);
      runTimes(arrayType, sizesArray, storingTimes, "Arrays.sort", ARRAYSSORT);
      System.out.println();
   }
}