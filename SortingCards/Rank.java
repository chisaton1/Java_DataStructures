
/**
 * The rank of a standard playing card (ace is low)
 * 
 * @author chisaton
 * @version Fall 2008
 */
public enum Rank
{
    ACE(1,"A"), TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"), 
    EIGHT(8,"8"), NINE(9,"9"), TEN(10,"T"), JACK(11,"J"), QUEEN(12,"Q"), KING(13,"K");

    private int value; // the value in the range 1 .. 13 for A .. K
    private String str; // the string representation
    
    
    /**
     * Constructor for a Rank object
     * @param value the value in the range 1 through 13
     * @param str the String representation of the Rank
     */
    Rank(int value, String str)
    {
        this.value = value;
        this.str = str;
    }
    
    /**
     * returns the rank as a String
     * @return the string representation of this rank
     */
    public String toString()
    {
        return str;
    }
    
    /**
     * returns the faceValue of the rank as an int in the range 1 .. 13 for Ace .. King
     * @return the corresponding valaue of the rank in the range 1 .. 13 (inclusive)
     */
    public int getValue()
    {
        return value;
    }
}
