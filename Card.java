/**
 * @version date (in_ISO_8601) format: 2019-04-23
 * @author Carly Kehoe
 */


/**
 * a card has three class variables:
 * rank of the card
 * suit of the card
 * whether it is face up or not
 */
public class Card {
     private Rank rank;
     private Suit suit;
     private boolean faceUp;
    
    /**
     *
     * @param rank the rank of the card
     * @param suit the suit of the card
     * Constructs a new Card with the given rank and suit
     * newly constructed cards are face up by default
     */
     public Card(Rank rank, Suit suit) {
         faceUp = true;
         this.rank = rank;
         this.suit = suit;
     }
    
    /**
     *
     * @return the rank of the card (Ace - King)
     */
     public Rank getRank() {
         return rank;
     }
    
    /**
     *
     * @return the suit of the card (Clubs, etc)
     */
     public Suit getSuit() {
         return suit;
     }
    
    /**
     * @return the status of the card
     */
     public boolean isFaceUp() {
         return faceUp;
     }
    
    /**
     * @return true if card is a black card, false if not
     */
     public boolean isBlack() {
         return (suit == Suit.CLUBS || suit == Suit.SPADES);
     }
    
    /**
     * Sets the card to either face up or face down
     */
     public void flip() {
         faceUp = !faceUp;
     }
    
}
