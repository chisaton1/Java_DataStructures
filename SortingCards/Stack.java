
/**
 * Lists the Stack's methods
 * 
 * @author chisaton
 * @version Fall 2015
 */

public interface Stack<E>
{
    /**
     * examine the top of the stack without removing the top item
     * @return the top of the stack
     */
    E peek();
    
    /**
     * push the element onto the top of the stack
     * @param element the item to push onto the stack
     */
    void push(E element);
    
    /**
     * remove (and return) the item on the top of the stack
     * @return the item that was removed from the top of the stack
     */
    E pop();
    
    /**
     * get the number of items on the stack
     */
    int size();
    
    /**
     * return true if the stack is empty; otherwise return false
     * @return true if the stack is empty; otherwise return false
     */
    boolean isEmpty();
}
