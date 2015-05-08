//Kate Maher
//Dr. Bricker
//February 5, 2015
//Computer Science III
//Assignment 9: Scheduler
//This assignment uses oject oriented techniques to determine a common aspects of a students schedule

import java.io.*;
import java.util.*;
import java.awt.*;

/**
 * This class mocks determining common schedule elements
 */
public class School
{
   /**Alge
    * Class constant for the minimum grade of the student
    */
   public static final int MINGRADE = 9;
  
   /**
    * Class constant for the maximum grade of the student
    */
   public static final int MAXGRADE = 12;
   
   /**
    * Class constant for the minimum number of courses of the student
    */
   public static final int MINCOURSES = 1;
   
   /**
    * Class constant for the maximum number of courses of the student
    */
   public static final int MAXCOURSES = 8;
   
   /**
    * Takes two students and prompts for information
    * Then compares their schedules
    */
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in); //constructing scanner 
      String gradePrompt = "What is the student's grade (9, 10, 11, 12)? ";//prompt for the users grade
      String coursePrompt = "How many courses is this student taking (" + MINCOURSES + "-" + MAXCOURSES + ")? ";//prompt for the students courses
      String namePrompt = "What is the student's name (firstname lastname)? ";//prompt for the student's name
      //String firstname = "";//initializes first name as an empty string
      //String lastname = "";//initializes last name as an empty string
      String fullname1 = userName(input, namePrompt);//prompts user for full name
      int grade1 = correctUserInput(input, gradePrompt, MINGRADE, MAXGRADE);//calls user input to get student's grade
      int maxClasses1 = correctUserInput(input, coursePrompt, MINCOURSES, MAXCOURSES);//determines courses for student
      Student s1 = studentComplete(fullname1, grade1, MAXCOURSES);//method creating the student
      userCourses(input, maxClasses1, s1);//adds values to an array
      String fullname2 = userName(input, namePrompt);
      int grade2 = correctUserInput(input, gradePrompt, MINGRADE, MAXGRADE);//calls user input to get student's grade
      int maxClasses2 = correctUserInput(input, coursePrompt, MINCOURSES, MAXCOURSES);
      Student s2 = studentComplete(fullname2, grade2, MAXCOURSES);
      userCourses(input, maxClasses2, s2);
      //System.out.println();
      compareUserValues(s1, s2, MAXCOURSES, fullname1, fullname2);//compares user values
      
   }
   
   /**
    * Gets the user input as an integer
    * @param input takes user input
    * @param prompt prompts the user for desired question
    * @param minNumber is the arbitrary minimum number
    * @param maxNumber is the arbitrary maximum number
    * @return the integer guess value of the user
    */  
   public static int correctUserInput(Scanner input, String prompt, int minNumber, int maxNumber)
   {
      int number = maxNumber+400; //initializes guess to something outside the range so it runs
      while (number < minNumber || number > maxNumber)
      {
         System.out.print(prompt); //input.next();
         while(!input.hasNextInt())//while loop to ensure input is integer
         {
            System.out.println("Input is not valid, you need to enter a number");//prompts for user input
            System.out.print(prompt);
            input.nextLine();//takes user input
         }
         number = input.nextInt();//assigns the next input to the number
         input.nextLine();
         if (number < minNumber || number > maxNumber)//makes sure input is in range
         {
         System.out.println("Input is not valid, you need to enter a number between " + minNumber + " and " + maxNumber);
         }
      }
      return number; //returns guess value
   }
   
   /**
    * Gets the full username of the person
    * @param input takes the user input to use
    * @param prompt specific prompt to ask for the user name
    */
   public static String userName(Scanner input, String prompt)
   {
      System.out.print(prompt);//prompts for user ame
      String name = input.nextLine();  
      return name; //returns name
   }
   
   /**
    * Separates the student fullname into first name and last name
    * Creates a new student and returns it 
    * @param fullname the full name of the user as inputted
    * @param grade an int of the student's grade
    * @param maxCourse int of the max number of classes for the studetn
    */
   public static Student studentComplete(String fullname, int grade, int maxCourse)
   {
      String lastname = "";//creates an empty string for last name
      Scanner linescan = new Scanner(fullname);
      String firstname = linescan.next();//takes the first name
      if (linescan.hasNextLine()) {
         lastname = linescan.nextLine();
         }
      Student perfectChild = new Student(firstname, lastname, grade, maxCourse);//creates a new student with the determined values
      return perfectChild;//returns the created student (while also using a fun name!!)
   }
   
   /**
    * Puts the courses of the user into an array
    * @param input scanner to get the next line each time of the user
    * @param maxClasses total classes offered for the student
    * @param p an arbitary student created earlier
    */
   public static void userCourses(Scanner input, int maxClasses, Student p)
   {
      String userClass = "";
      for (int ii = 1; ii <= maxClasses; ii++) {//for loop that runs through and asks for the class anmes
         System.out.print("Course " + ii + " name? ");
         if (input.hasNextLine()) {
            userClass = input.nextLine();
            }
         else {
            userClass = "";
            }
         p.addCourse(userClass, ii-1);
      }
      System.out.println();
   }
   
   /**
    * Compares the classes of the user at points in their array
    * @param s1 the first student object
    * @param s2 the second student object
    * @param maxClasses the total classses possible for the user
    * @param fullname1 the earlier stated full name of the first student
    * @param fullname2 the earlier stated full name of the second student 
    */
   public static void compareUserValues(Student s1, Student s2, int maxClasses, String fullname1, String fullname2)
   {
      String coursePeriods = "";//creates and empty string of course periods
      String fixedCourses;
      String[] student1 = s1.getCourses();//gets the previously created array from Student
      String[] student2 = s2.getCourses();
      int equalClasses = 0;
      
      for (int ii= 0; ii<maxClasses; ii++) {
         if (student1[ii].equals(student2[ii])) {//checks if they have commmon frees
            //int jj = ii + 1;
            coursePeriods = coursePeriods + (ii+1) + ", " ;
            equalClasses = equalClasses + 1;
            //System.out.println(coursePeriods); //provides check on courses period
            }
         else {
               //coursePeriods = "  ";
         }
      }
      //fixedCourses = coursePeriods.substring(0, coursePeriods.length()-2);//takes out the last two values on the string of similar courses
      System.out.println("Student " + fullname1 + " is taking courses " + Arrays.toString(student1));
      System.out.println("Student " + fullname2 + " is taking courses " + Arrays.toString(student2));
      if (Math.abs(equalClasses-0) < .01) {//prints correct final output using if/else statements depending on if they have shared classes
         System.out.println("The students have no shared classes.");
      }
      else {
         System.out.println("The students have the same classes in periods " + coursePeriods.substring(0, coursePeriods.length()-2));
      }
      
   }
}