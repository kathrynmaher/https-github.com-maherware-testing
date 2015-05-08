//Kate Maher
//Dr.Bricker

import java.util.*;

/**
 * Tests the efficiency of different sorter methods
 */
public class Empirical {

   /**
    * Class constant for easy comparison when it is insertion sort
    */
   public static final int INSERTIONSORT = 1;
   
   /**
    * Class constant for easy comparison when it is selection sort
    */
   public static final int SELECTIONSORT = 2;
   
   /**
    * Class constant for easy comparison when it is merge sort
    */
   public static final int MERGESORT = 3;
   
   /**
    * Class constant for easy comparison when it is array.sort
    */
   public static final int ARRAYSSORT = 4;

   /**
    * Runs the program and prints out the times for each type of sort
    */
   public static void main(String[] args) {
      int[] sizesArray = {1000, 5000, 10000, 20000, 50000}; //initializing all the array
      int[] increasingArray = new int[sizesArray[sizesArray.length-1]];
      int[] decreasingArray = new int[sizesArray[sizesArray.length-1]];
      for (int ii = 0; ii < sizesArray[sizesArray.length-1]; ii++) {
         increasingArray[ii] = ii+1;
         decreasingArray[ii] = sizesArray[sizesArray.length-1]-ii;
      }
      int[] randomArray = Sorters.createArray(sizesArray[sizesArray.length-1]);
      long[] storingTimes = new long[sizesArray.length];
      
      printTable(sizesArray, "Increasing", increasingArray, storingTimes);//executes the program
      printTable(sizesArray, "Decreasing", decreasingArray, storingTimes);
      printTable(sizesArray, "Random", randomArray, storingTimes);
   }
   
   /**
    * Sorts the values based on the list and sort type
    * @param list list of values to be sorted
    * @param sortType the class constant used to sort the value
    * @return a long of the amount of time it took to sort
    */
   public static long calculateTime(int[] list, int sortType) {
      System.gc();
      long beginTime = System.currentTimeMillis();
      if (sortType == INSERTIONSORT) { //comparison statements
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
   
   /**
    * Goes through each array and determines the whole line of times
    * @param testingArray the array that will be tested w the different sorting types
    * @param sizesArray an array with all the values within it
    * @param storingTimes an array holding each time
    * @param name is the name of the current type of array being tested
    * @param sortType is the type of sorting being used
    */
   public static void runTimes(int[] testingArray, int[] sizesArray, long[] storingTimes, String name, int sortType) {
      for (int ii= 0; ii < sizesArray.length; ii++) { //for loop to determine the whole line
         int[] tempArray = Arrays.copyOfRange(testingArray, 0, sizesArray[ii]);
         storingTimes[ii] = calculateTime(tempArray, sortType);
      }
      System.out.printf("%15s\t", name); //then prints the whole line suing print f
      for(int jj = 0; jj < storingTimes.length; jj++) {
          System.out.printf("%d\t", storingTimes[jj]);
      }
      System.out.printf("\n");
   } 
   
   /**
    * Prints an entire group on the table
    * @param times is each of the values of part of the original array being tested
    * @param type is whether or not we are doing increasing, decreasing, or random
    * @param storingTimes the new values when creating the time for each line
    * @param sizesArray 
    */
   public static void printTable(int[] times, String type, int[] arrayType, long[] storingTimes) {
      System.out.printf("%15s\t", type);
      for(int ii = 0; ii < times.length; ii++) {
         System.out.printf("%d\t", times[ii]);
         }
         System.out.printf("\n");
      runTimes(arrayType, times, storingTimes, "selectionSort", SELECTIONSORT);//runs each line
      runTimes(arrayType, times, storingTimes, "insertionSort", INSERTIONSORT);
      runTimes(arrayType, times, storingTimes, "mergeSort", MERGESORT);
      runTimes(arrayType, times, storingTimes, "Arrays.sort", ARRAYSSORT);
      System.out.println();
   }
}