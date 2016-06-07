import java.util.Comparator;
/**
 * AcesHighComparator is used when the ace is higher than the king (and in same order of suits)
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class AcesHighComparator implements Comparator<Card>
{
   public int compare(Card card1, Card card2)
   {
       int card1RankValue = card1.getRank().getValue();
       int card2RankValue = card2.getRank().getValue();
       if(card1.getSuit().toString().equals(card2.getSuit().toString())) // if two cards had same suits
       {
           if(card1RankValue == 1) // Ace is higher than King
           {
               card1RankValue = 14; 
            }
           if(card2RankValue == 1)
           {
               card2RankValue = 14; 
           }
           return card1RankValue - card2RankValue;
       }
       else // different suits
       {
           // using ASCII code to compare
           return card1.getSuit().toString().charAt(0) - card2.getSuit().toString().charAt(0);
       }
   }
}
