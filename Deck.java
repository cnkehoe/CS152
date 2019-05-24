/**
 * @version date (in_ISO_8601 format): 2019-04-23
 * @author Carly Kehoe
 */

public class Deck{
    /**
     * Deck has 2 class variables
     * an array of cards
     * an int to represent how many cards are in the deck
     */
    
    private Card[] cards;
    private int numCards;
    
    /**
     * Creates a new empty deck of cards
     */
    public Deck() {
        cards = new Card[52];
        numCards = 0;
    }
    
    /**
     * Adds a card to the first empty index in the card array (top of the deck)
     * @param card the card that will be added to the deck
     */
    public void add(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                numCards = i + 1;
                break;
            }
        }
    }
    
    /**
     * FIlls the deck with all the cards in a standard deck of cards
     */
    public void fill() {
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();
        int count = 0;
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                cards[count] = new Card(ranks[r], suits[s]);
                numCards++;
                count++;
            }
        }
    }
    
    /**
     * Returns a selected card in the deck
     * @param n the card the retrieve
     * @return the nth card in the deck
     */
    public Card getCardAt(int n) {
        if (n < 0 || n > 51) {
            return null;
        }
        else {
            return cards[n];
        }
    }
    
    /**
     * Moves the top card from the top of the deck to the top of the other deck
     * @param other the other deck to which to add the card
     */
    public void move(Deck other) {
        other.add(cards[size() - 1]);
        cards[size() - 1] = null;
        numCards--;
    }
    
    /**
     * Moves the top n cards from the top of the deck to the top of the other deck
     * @param other the other deck to which to add the card(s)
     * @param n the number of cards being moved
     */
    public void move(Deck other, int n) {
        Card[] selection = new Card[n];
        int index = 0;
        for (int i = size() - n; i < size(); i++) {
            selection[index] = cards[i];
            cards[i] = null;
            index++;
        }
        numCards -= n;
        for (int i = 0; i < selection.length; i++) {
            other.add(selection[i]);
        }
        }
    
    /**
     * Returns the number of cards currently in the deck
     * @return number of cards in the deck
     */
    public int size() {
        return numCards;
        }
    
    /**
     * Returns the top card on the deck, or null if the deck is empty
     * @return the top card of the deck
     */
    public Card getTopCard() {
        if (size() == 0) {
            return null;
        }
        else {
            return cards[size() - 1];
        }
        
        }
    
    /**
     * From what I can gather, this is an implementation of a Fisher-Yates shuffle.
     * I found the algorithm here: https://www.dotnetperls.com/shuffle-java
     * and I asked my cousin for additional suggestions on shuffling arrays (he wasn't that helpful)
     * Note: apparently this is a REALLY dinky way to shuffle an array bc it's super slow
     * but it works, sooooooooo
     */
    public void shuffle() {
        for (int i = size() - 1; i > 0; i--) {
            int rand = (int)(Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        }
        
       
    
    

}
