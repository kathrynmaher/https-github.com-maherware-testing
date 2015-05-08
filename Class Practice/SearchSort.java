//Kate Maher
//Dr. Bricker
//Class Fun

public class SearchSort {

   public static void main(String[] args) {
      int[] nums = {1, 2, 3};
      int value = -1;
      findNum(nums, value);
   }
   
   public static int findNum(int[] nums, int value) {
      int indexConcurrence = -1;
      if (nums.length > 0) {
          for (int ii= 0; ii<nums.length; ii++) {
            if (nums[ii] == value) {
               indexConcurrence = ii;
            }
          }
      }
      return indexConcurrence;
   }

}