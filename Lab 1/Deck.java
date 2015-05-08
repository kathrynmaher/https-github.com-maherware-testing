// Kate Maher
// Computer Science 3

import java.util.*;

public class Deck {
   
   
   /** This variable is an array that holds the deck of Card.MAX_CARDS cards */
   private Card[] cards = new Card[Card.MAX_CARDS];
	
	/** This variable holds the number of cards that are left in the deck, after they have been dealt.
	 *  Can only go up to Cards.MAX_CARDS */
   private int counter = 0;
   
   /** 
	 *  Constructor.  Creates and initializes an unshuffled deck of cards using a doubly nested for loop over the 
	 *  the card suits (Card.SPADES .. Card.CLUBS) and the values (Card.ACE.. Card.KING). 
	 *  Then it adds the two jokers to the end, giving them value 1 and 2 respectively. 
	 *  The variable holding the number of cards left is set appropriately, then 
	 *  Finally it shuffles the deck using the DeckShuffler.shuffle method, if the parameter passed in is true. 
	 *  @param shuffle determines whether or not the deck should be shuffled. 
	 */
   public Deck(boolean shuffle)
   {
      for (int suit= Card.SPADES; suit <= Card.CLUBS; suit++) {
         for (int value= Card.ACE; value <= Card.KING; value++) {
            addCard(new Card(value, suit));
            }
         }
         addCard(new Card());
         addCard(new Card(2, Card.JOKER));
         if (shuffle) {
            DeckShuffler.shuffle(cards, counter);
            }
    }
	
	/**
	 * Adds a card to the top of the deck. This adds the card to the array and increments the 
	 * total number of cards. It will throw an IllegalArgumentException if the maxiumum 
	 * number of cards has already been added or if the card being passed in is null
	 * @param c The card to be added. 
	 */
	public void addCard(Card c) 
	{
      if (cards.length == counter) {
         throw new IllegalArgumentException();
         }
      else {
         cards[counter] = c;  
         counter++;
         }
	}

   
   /**
	 * As cards are dealt from the deck, the number of 
    * cards left decreases.  This function returns the 
    * number of cards that are still left in the deck.
	 * @return the number of cards still left in the deck
	 */ 
   public int cardsLeft() 
	{
      return counter;
   }
   
   /**
	 * Deals one card from the "top" of the deck and returns it. (The bottom of the deck is 0, 
	 * The top of the deck is the highest card). Sets the "top" card in the deck to null, 
	 * and decrements the number of cardsLeft to keep track. 
    * Throws an IllegalArgumentException if no more cards are left.
	 */
   public Card dealCard()
   {
      if (counter >= 1) {
         Card c = cards[counter-1];
         cards[counter-1] = null;
         counter--;
         return c;
         }
      else {
         throw new IllegalArgumentException();
         }
   }
   
   /**
	 * Returns a string representation of the current state of the deck, what's left of it. 
	 * each card is separated by a new line. 
    * The cards are printed in order from the bottom first of the deck to the top of the deck last. 
	 * @return a string representation of the current state what's left of the deck - 
    * with each card on a new line
	 */
	 
   public String toString()
   {
      String stringDeck = "";
      for (int ii= 0; ii< counter; ii++) {
          stringDeck += cards[ii];
          stringDeck += "\n";
         }
      return stringDeck;
   }
}
