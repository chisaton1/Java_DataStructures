import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * In CardSorter Class, there are six sort methods:
 *  ArrayList<Card> mergeSort(Deck deck, int n)
 *  ArrayList<Card> mergeSort(Deck deck, int n, Comparator<Card> comp)
 *  Card[ ] quickSort(Deck deck, int n)
 *  Card[ ] quickSort(Deck deck, int n, Comparator<Card> comp)
 *  ArrayList<Card> heapSort(Deck deck, int n)
 *  ArrayList<Card> heapSort(Deck deck, int n, Comparator<Card> comp)
 *
 * 様々なトランプのソートをするメソッド
 *
 * @author chisaton
 * @version Fall 2015
 */
public class CardSorter
{
    /**
     * Sorts (following CompareTo method in Card class) cards in the deck using mergeSort
     */
    public static ArrayList<Card> mergeSort(Deck deck, int n)
    {
       ArrayList<Card> list = new ArrayList<Card>(n); 
       while(!deck.isEmpty())
       {
           list.add(deck.pop());
       }
       Collections.sort(list); // use CompareTo method in the Card class
       return list;
    }
    
    /**
     * Sorts (following Comparator<Card> instruction) cards in the deck using mergeSort
     */
    public static ArrayList<Card> mergeSort(Deck deck, int n, Comparator<Card> comp)
    {
       ArrayList<Card> list = new ArrayList<Card>(n); 
       while(!deck.isEmpty())
       {
            list.add(deck.pop());
       }
       Collections.sort(list, comp); // use AcerHighComparator class which implements Comparator class
       return list;
    }
    
    /**
     * Sorts (following CompareTo method in Card class) cards in the deck using quickSort
     */
    public static Card[] quickSort(Deck deck, int n)
    {
       Card[] cardArray = new Card[n];
       int index = 0;
       while(!deck.isEmpty())
       {
            cardArray[index] = deck.pop();
            index++;
       }
       Arrays.sort(cardArray);
       return cardArray;
    }
    
    /**
     * Sorts (following Comparator<Card> instruction) cards in the deck using quickSort
     */
    public static Card[] quickSort(Deck deck, int n, Comparator<Card> comp)
    {
       Card[] cardArray = new Card[n];
       int index = 0;
       while(!deck.isEmpty())
       {
            cardArray[index] = deck.pop();
            index++;
       }
       Arrays.sort(cardArray, comp);
       return cardArray;
    }
    
    /**
     * Sorts (following CompareTo method in Card class) cards in the deck using heapSort
     */
    public ArrayList<Card> heapSort(Deck deck, int n)
    {
       PriorityQueue<Card> sortedList = new PriorityQueue();
       while(!deck.isEmpty())
       {
            sortedList.add(deck.pop());
       }  
       ArrayList<Card> list = new ArrayList<Card>(n);
       while(sortedList.size() != 0)
       {
           list.add(sortedList.poll());
       }
       return list;
    }
    
    /**
     * Sorts (following Comparator<Card> instruction) cards in the deck using heapsort
     */
    public ArrayList<Card> heapSort(Deck deck, int n, Comparator<Card> comp)
    {
       PriorityQueue<Card> sortedList = new PriorityQueue(comp);
       while(!deck.isEmpty())
       {
            sortedList.add(deck.pop());
       }  
       ArrayList<Card> list = new ArrayList<Card>(n);
       while(sortedList.size() != 0)
       {
           list.add(sortedList.poll());
       }
       return list;
    }
}
