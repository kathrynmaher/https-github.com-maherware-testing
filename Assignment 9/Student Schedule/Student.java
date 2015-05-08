//Kate Maher
//Dr. Bricker
//February 5, 2015
//Computer Science III
//Assignment 9: Scheduler
//This assignment uses oject oriented techniques to determine a common aspects of a students schedule

import java.io.*;
import java.util.*;

public class Student 
{
   /**
    * instance variable string of first name
    */
   public String first;
   
   /**
    * instance variable string of last name
    */
   public String last;
   
   /**
    * instance variable int of grade
    */
   public int grade;
   
   /**
    * instance variable int of maxClasses
    */
   public int maxClasses = 8;
   
   /**
    * instance variable string array of courses 
    * assigned initially all to free
    */
   public String[] courses = {"Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free"}; 
   
   /**
    * instance variable int counts repetition
    */
   public int counter;

   /**
    * Assigns instance variables to a Student object 
    * @param first string of the first name
    * @param last string of the last name
    * @param grade int of the grade of the student
    * @param maxClasses the max number of periods in the schedule 
    */  
   public Student(String first, String last, int grade, int maxClasses)
   {
      setInfo(first, last, grade);
      this.maxClasses = maxClasses;  
   }
   
   /**
    * Sets up the student with arbitrary values
    */
   public Student()
   {
      this("Jane", "Doe", 6, 8);
   }
   
   /**
    * Gets the first name and returns it
    * @return string of first name of ther user
    */
   public String getFirstName()
   {
      return first;
   }
   
   /**
    * Gets the last name and returns it
    * @return string of the last name of the user
    */
   public String getLastName()
   {
      return last;
   }
   
   /**
    * Gets the full name and then returns it
    * @return String of the users full name
    */
   public String getFullName()
   {
      return first + " " + last;
   }
   
   /**
    * Gets the grade and then returns it
    * @return int of the grade of user
    */
   public int getGrade()
   {
      return grade;
   }
   
   /**
    * Gets the courses of the student and returns
    * @return an array holding the users courses
    */
   public String[] getCourses()
   {
      return courses;
   }
   
   /**
    * Sets the info for some of the instance variables
    * @param first string holding the first name of the user
    * @param last string holding last name of the user
    * @param grade int of the grade of person
    */
   public void setInfo(String first, String last, int grade)
   {
      this.first = first;
      this.last = last;
      this.grade = grade;
   }
   
   /**
    * Converts parts of Student to a string
    * @return string of user values
    */
   public String toString()
   {
      return grade + ":" + " " + first + " " + last + " " + Arrays.toString(courses);
   }
   
   /**
    * Compares each aspect of student
    * Uses correct equals statement for the type
    * @param s new arbitrary student
    */
   public boolean equals(Student s)
   {
      return (first.equals(s.first) && last.equals(s.last) && Math.abs(this.grade-s.grade) < .01 && Math.abs(this.maxClasses-s.maxClasses) < .01);
   }
   
   /**
    * adds courses depending on whether person has a free or is at the max amount of classes
    * @return int of user courses
    */
   public int addCourse(String course, int period)
   {
      if (courses[period] == "Free") {
         if (period < maxClasses) {
            courses[period] = course;
            counter = counter + 1;
         }
      }
      else {
      }
      return counter;
   }
   
   
}