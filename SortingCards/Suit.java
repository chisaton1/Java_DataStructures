
/**
 * Suit of a standard playing card
 * 
 * @author chisaton
 * @version Fall 2015
 */
public enum Suit
{
    CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");
    
    private String str;
    
    Suit(String str)
    {
        this.str = str;
    }
    
    /**
     * return the single letter representation of this suit
     * @return the letter for the suit
     */
    public String toString()
    {
        return str;
    }
}
