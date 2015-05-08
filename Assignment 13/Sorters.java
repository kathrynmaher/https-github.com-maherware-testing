//Kate Maher
//Computer Science 3
//April 16, 2015
//Assignment 13: Milestone 1

import java.util.*;

/**
 * Takes arrays with values and lists the values
 */
public class Sorters {

   /**
    * Main method tests each of the other sorters method
    * @param args array 
    */
   public static void main(String[] args)
   {
      int i = 2;
      int j = 1;
      int size = 10;
      
      //testing selection sort & swap
      int[] list = createArray(size);
      System.out.println("Before selection sort: " + Arrays.toString(list));
      //int[] list = {2, 5, 6, 8, 7}; //testing
      try {
         swap(list, i, j);
      }
      catch (IllegalArgumentException e) 
      {
         System.out.println("Exception Thread");
      }
      selectionSort(list);
      System.out.println("After selection sort: " + Arrays.toString(list)); //testing
      System.out.println();
      
      //testing insertion sort
      list = createArray(size);
      System.out.println("Before insertion sort: " + Arrays.toString(list));
      insertionSort(list);
      System.out.println("After insertion sort: " + Arrays.toString(list)); //testing
      System.out.println();
      
      //testing merge
      int[] merge1 = {1, 7, 8};
      System.out.println("First merge list: " + Arrays.toString(merge1));
      int[] merge2 = {2, 3, 4};
      System.out.println("Second merge list: " + Arrays.toString(merge2));
      int[] newArray = new int[merge1.length + merge2.length];
      merge(newArray, merge1, merge2);
      System.out.println("Result after merge: " + Arrays.toString(newArray));
      System.out.println();
      
      //testing merge sort
      list = createArray(size);
      System.out.println("Before merge sort: " + Arrays.toString(list));
      mergeSort(list);
      System.out.println("Result after merge sort: " + Arrays.toString(list));
   }
   
   /**
    * Creates an array of a random size
    * @param size holds an int with random size
    */
   public static int[] createArray(int size) {
      if (size > 0) {
         int newArray[] = new int[size];
         Random r = new Random();
         for (int ii= 0; ii<size; ii++) {
            newArray[ii] = r.nextInt(size+1);
         }
         return newArray;    
      }
      else {
         throw new IllegalArgumentException("An error occured.");
      } 
   }  
   
   /**
    * Swaps values in an array depending on random ints in an index
    * @param list array holding values
    * @param i random integer to swap
    * @param j other random integer to swap
    */
   private static void swap(int[] list, int i, int j) {
      if (!(i >= 0 && i < list.length || j >= 0 && j < list.length)) {
         throw new IllegalArgumentException("Out of Bounds");
      }
      else if (i == j) {
         return;
      }
      else {
         int temp = list[i];
         int temp2 = list[j];
         list[i] = temp2;
         list[j] = temp;
      }
   }
   
   /**
    * Sorts values from smallest to greatest 
    * @param list array holding a list to switch values around
    */
   public static void selectionSort(int[] list) {
      for (int ii=0; ii < list.length; ii++) {
         int smallest = ii;
         for (int jj = ii+1; jj < list.length; jj++) {
            if (list[smallest] >= list[jj]) {
               smallest = jj;
            }
         }
         swap(list, ii, smallest);
      }
   }
   
   /**
    * Sorts values in a list based on values in array
    * @param list array holding values to be arranged
    */
   public static void insertionSort(int[] list)
   {
      int index = -1;
      int shift = -1;
      int tempValue = 0;
      for (index = 1; index < list.length; index++) {
         if (list[index] < list[index-1]) {
            tempValue = list[index];
            shift = index;
            do {//used website online to remind myself what a do while looks like
               list[shift] = list[shift-1];
               shift--;
            } while (shift > 0 && list[shift-1] > tempValue);
            list[shift] = tempValue;
         }
      }  
   }
   
   /**
    * Merges two separate arrays to combine a complete array
    * @param result new array holding both 
    * @param list1 array with random integer values
    * @param list2 array with random integer values
    */
   public static void merge(int[] result, int[] list1, int[] list2) {
      if (result.length != list1.length+list2.length) {
         throw new IllegalArgumentException("Out of Bounds");
      }
      int i1 = 0;
      int i2 = 0;
      int variable = result.length;
      for (int ii = 0; ii < variable; ii++) {
         if (i2 >= list2.length || (i1 < list1.length && list1[i1] < list2[i2])) {
            result[ii] = list1[i1];
            i1++;
         }
         else {
            result[ii] = list2[i2];
            i2++;
         }
      }   
   }
   
   /**
    * Merges and sorts the values of the combined list
    * @param list a merged list 
    */
   public static void mergeSort(int[] list) {
      if (list.length > 1) {
         int size1 = list.length/2;
         int size2 = list.length - size1;
         int list1[] = new int[size1];
         int list2[] = new int[size2];
         list1 = Arrays.copyOfRange(list, 0, size1);
         list2 = Arrays.copyOfRange(list, size1, list.length);
         mergeSort(list1);
         mergeSort(list2);
         merge(list, list1, list2);
      }
   }
 
}