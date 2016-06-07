import java.util.*;

/**
 * A StackOfCards 
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class StackOfCards implements Stack<Card>
{
    private Deque<Card> cards;
    
    /**
     * Constructor for objects of class StackOfCards
     */
    public StackOfCards()
    {
        cards = new LinkedList<Card>();
    }
    
    public StackOfCards(List<Card> cardList)
    {
        for(Card c: cardList)
            cards.add(c);
    }
    
    /**
     * return the card on top of the stack
     * @return the card on the top of the stack
     */
    public Card peek()
    {
        return cards.peekFirst();   
    }
    
    /**
     * remove (and return) the card on the top of the stack
     * @return the card that is removed from the top of the stack
     */
    public Card pop()
    {
        return cards.removeFirst();   
    }
    
    /**
     * push a card onto the top of the stack
     * @param card the card to be pushed
     */
    public void push(Card card)
    {
        cards.addFirst(card);   
    }
    
    /**
     * get the number of cards in the stack
     * @return the number of cards in the stack
     */
    public int size()
    {
        return cards.size();   
    }

    /**
     * return true if the stack is empty; otherwise return false
     * @return true if the stack is empty; otherwise return false
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
}
