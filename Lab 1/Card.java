// Kate Maher
// Computer Science 3
// Poker- In-Class Assignment


public class Card {
   
   public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
   public final static int HEARTS = 1;
   public final static int DIAMONDS = 2;
   public final static int CLUBS = 3;
   public final static int JOKER = 4;
   
   public final static int ACE = 1;      // Codes for the non-numeric cards.
   public final static int JACK = 11;    //   Cards 2 through 10 have their
   public final static int QUEEN = 12;   //   numerical values for their codes.
   public final static int KING = 13;

	public final static int MAX_CARDS = (Card.CLUBS - Card.SPADES + 1) * (Card.KING - Card.ACE + 1) + 2; 
	
   
   /**
   * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
   * CLUBS, or JOKER.  The suit cannot be changed after the card is
   * constructed.
   */
   private final int suit;
   
   /**
   * The card's value.  For a normal cards, this is one of the values
   * 1 through 13, with 1 representing ACE.  For a JOKER, the value
   * can be anything (usually 1 or 2).  The value cannot be changed 
   * after the card is constructed.
   */
   private final int value;
   
   /**
   * Creates a Joker, with 1 as the associated value. Uses the 
   * other constructor to actual set the suit and value. 
   */
   public Card() 
	{
      this(1, JOKER);
   }
   
   /**
   * Creates a card with a specified suit and value.
   * @param theValue the value of the new card.  For a regular card (non-joker),
   * the value must be in the range 1 through 13, with 1 representing an Ace.
   * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.
   * For a Joker, the value can be anything.
   * @param theSuit the suit of the new card.  This must be one of the values
   * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER.
   * @throws IllegalArgumentException if the parameter values are not in the
   * permissible ranges
   */
   public Card(int theValue, int theSuit) 
	{
      if (theSuit == DIAMONDS || theSuit == SPADES || theSuit == HEARTS || theSuit == CLUBS) {
         if (theValue <= 13 || theValue >= 1) {
            this.suit = theSuit;
            this.value = theValue;
         }
         else {
            throw new IllegalArgumentException();
         }
      }
      else if (theSuit == JOKER) {
         this.suit = theSuit;
         this.value = theValue;
         }
      else {
         throw new IllegalArgumentException();
         }
   }
   
   /**
   * Returns the suit of this card.
   * @returns the suit, which is one of the constants Card.SPADES,
   * Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER
   */
   public int getSuit() 
	{
      return suit;
   }
   
   /**
   * Returns the value of this card.
   * @return the value, which is one the numbers 1 through 13, inclusive for
   * a regular card, and which can be any value for a Joker.
   */
   public int getValue() 
	{
      return value;
   }
   
   /**
   * Returns a String representation of the card's suit.
   * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
   * or "Joker".
   */
   public String getSuitAsString() 
	{
      if (suit == SPADES) {
         return "Spades";
         }
      else if (suit == HEARTS) {
         return "Hearts";
         }
      else if (suit == DIAMONDS) {
         return "Diamonds";
         }
      else if (suit == CLUBS) {
         return "Clubs";
         }
      else if (suit == JOKER) {
         return "Joker";
         }
      else {
         return "You messed up";
         }
   }
   
   /**
   * Returns a String representation of the card's value.
   * @return for a regular card, one of the strings "Ace", "2",
   * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the
   * string is always a numerical.
   */
   public String getValueAsString() 
   {
      if (value == JACK) {
         return "Jack";
         }
      else if (value == QUEEN) {
         return "Queen";
         }
      else if (value == KING) {
         return "King";
         }
      else if (value == ACE) {
         return "Ace";
         }
      else {
         return "" + value + "";
         }
   }
	
	/**
	 * Checks to see if two cards are equal
	 * @param Card other
	 */
	public boolean equals(Card other)
	{
	   return ((other.suit == suit) && (other.value == value));
	}
	 
   
   /**
   * Returns a string representation of this card, including both
   * its suit and its value.  Sample return values
   * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
   * "Joker #1", "Joker #2" (meaning "Joker #<value>")
   */
   public String toString() 
   {
      if (suit == JOKER) {
         return "Joker #" + value;
         }
      else {
         return getValueAsString() +" of " + getSuitAsString();
         }
    }
   
   
} // end class Card
