import java.util.*;

/**
 * a Deck of playing cards
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class Deck extends StackOfCards
{   
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        ArrayList<Card> list = new ArrayList<Card>(52); 
        for(Suit s: Suit.values())
            for(Rank r: Rank.values())
                list.add(new Card(r, s));
                
        Collections.shuffle(list);
        for(Card c: list)
            push(c);
    }

    public void shuffle()
    {
        ArrayList<Card> list = new ArrayList<Card>();
        while(!this.isEmpty())
        {
            list.add(pop());
        }
        Collections.shuffle(list);
        for(Card c: list)
            push(c);
    }
}
