import javax.swing.*;
import java.lang.Comparable;

/**
 * A standard playing card
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class Card implements Comparable<Card>
{
    private static final ImageIcon backSide = new ImageIcon("cards/b.gif");
    private Rank rank;
    private Suit suit;
    private String str;
    private boolean faceUp;
    private ImageIcon pic;

    /**
     * Constructor for objects of class Card
     */
    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
        str = rank.toString() + suit.toString();
        faceUp = false;
        pic = new ImageIcon("src/cards/" + str + ".gif");
    }
    
    /**
     * get the rank of this Card
     * @return the rank of this Card object
     */
    public Rank getRank()
    {
        return rank;
    }
    
    /**
     * get the suit of this Card object
     * @return the suit of this Card
     */
    public Suit getSuit()
    {
        return suit;
    }
    
    /**
     * get the String representation of this Card
     * @return the String representation of this Card.
     */
    public String toString()
    {
        return str;
    }
    
    /**
     * get the icon associated with this Card
     * @return the ImageIcon representing this Card
     */
    public ImageIcon getPicture()
    {
        if (faceUp)
            return pic;
        return backSide;
    }
    
    /**
     * determine whether this Card is currently face up or not
     * @return true if the card is face up; otherwise return false
     */
    public boolean isFaceUp()
    {
        return faceUp;
    }
    
    /**
     * set whether the card is face down or face up
     * @parm isFaceUp (true if the card is face up otherwise false) 
     */
    public void setFaceUp(boolean isFaceUp)
    {
        faceUp = isFaceUp;
    }
    
    /**
     * get the width of the card's picture
     */
    public int getPicWidth()
    {
        return pic.getIconWidth();   
    }
    
    /**
     * get the height of the card's picture
     */
    public int getPicHeight()
    {
        return pic.getIconHeight();
    }
    
    /**
     * will allow us to sort cards with Ace low and in order of 
     * Clubs, Diamonds, Hearts, Spades.
     */
    public int compareTo(Card card)
    {
        Rank rank = this.getRank();
        Suit suit = this.getSuit();
        if(suit.toString().equals(card.getSuit().toString())) // if two cards have same suits
        {
            return rank.getValue() - card.getRank().getValue(); // compare with these ranks
        }
        else
        {
            // compare with these ACKII codes (alphabetical order)
            return suit.toString().charAt(0) - card.getSuit().toString().charAt(0);
        }
    }
}
