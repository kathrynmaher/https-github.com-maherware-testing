//Kate Maher
//CS3
//Assignment 12

import java.util.*;
import java.awt.*;

/**
 * Class to work with the song
 */
public class Melody2 {

   /**
    * Instance variable to hold the notes of the song
    */
   private Queue<Note> song;
   
   /**
    * Initializes the melody class
    * @param song queue holding the notes in the song
    */
   public Melody2(Queue<Note> song) {
      this.song = song;
   }
   
   /**
    * Gets the length of the song
    * @return double of the length
    */
   public double getLength() {
      double songLength = 0.0;
      boolean stillRepeat = false;
      for (int ii = song.size()-1; ii >= 0; ii--) {
         Note element = song.remove();
         song.offer(element);
         //System.out.println("Is repeat: " + element.isRepeat() + " repeating: " + stillRepeat);
         if (stillRepeat) {
            songLength = (2*element.getDuration()) + songLength;
            }
         else {
            songLength = element.getDuration() + songLength;
            }  
         if (element.isRepeat()) {
            if (!stillRepeat) {
               songLength = element.getDuration() + songLength;
               stillRepeat = true;
               }
            else {
               stillRepeat = false;
               }
         }
         // if (stillRepeat) {
//             songLength = (2*element.getDuration()) + songLength;
//             }
//          else {
//             songLength = element.getDuration() + songLength;
//             }   
      }
      return songLength;   
   }
   
   /**
    * Changes the tempo
    * @param tempo holds the tempo in the song
    */
   public void changeTempo(double tempo) {
      for (int ii=song.size(); ii>0; ii--) {
         Note element = song.remove();
         double newDuration = element.getDuration()/tempo; 
         element.setDuration(newDuration);
         song.offer(element);
      }
   }
   
   /**
    * Reverses all the notes in the melody
    */
   public void reverse() {
      Stack<Note> replaceSong = new Stack<Note>();
      //Queue<Note> replaceSong = new LinkedList<Note>(); //initialize w a queue to keep the same
      for (int ii= song.size(); ii>0; ii--) {
         Note element = song.remove();
         replaceSong.push(element);   
      }
      for (int ii= replaceSong.size(); ii>0; ii--) {
         Note element = replaceSong.pop();
         song.offer(element);
      }
   }
   
   /**
    * Adds notes from another melody to the song
    * @param other the melody holding additional notes to add
    */
   public void append(Melody2 other) {
      for (int ii = other.song.size(); ii>0; ii--) {
         Note element = other.song.remove();
         song.offer(element);
      }
   }
   
   /**
    * Puts the notes to a string
    * @return the notes from the song
    */
   public String toString() {
      String fullSong = "";
      for (int ii = song.size(); ii > 0; ii--) {
         Note element = song.remove();
         fullSong = fullSong+ "\n" + element;
         song.offer(element);
      }
      return fullSong + "\n";
   }
   
   /**
    * Plays the song
    */
   public void play() {
      boolean stillRepeat = false;
      //Queue<Note> repeat = new Queue<Note>();
      for (int ii = song.size()-1; ii >= 0; ii--) {
         Note element = song.remove();
         song.offer(element);
         //System.out.println("Is repeat: " + element.isRepeat() + " repeating: " + stillRepeat);
         if (stillRepeat) {
            element.play();
//             for (int ii= q.size()-1; ii>= 0; ii--) {
//                Note element = q.remove();
//                q.play();
//                q.offer(element);
            }  
         else {
            element.play();
            }  
         if (element.isRepeat()) {
            if (!stillRepeat) {
               element.play();
               stillRepeat = true;
               }
            else {
               stillRepeat = false;
               }
         }
      
      }
   }
}