import java.util.LinkedList;
import java.util.EmptyStackException;
/**
 * PureStack which is impremented by LinkedList.
 * 
 * LinkedListを用いてStackを実装する
 *
 * @author chisaton
 * @version Fall 2015
 */
public class PureStack<E>
{
    private LinkedList<E> list;
    /**
     * Make new instance of LinkedList<E>
     */
    public PureStack()
    {
        list = new LinkedList<E>();
    }
    
    /**
     * Pushes an element onto the top of this stack.
     * the worstTime(n) is O(n) and averageTime(n) is constant.
     * 
     * @param element: the element to be pushed onto this stack.
     * @return the element argument.
     */
    public E push(E element)
    {
        list.add(element);
        return element;
    }
    
    /**
     * Removes the element at the top of this stack andreturns that element.
     * The worstTime(n) and averageTime(n) are constant.
     * 
     * @return the element at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E pop()
    {
        if(list.size() == 0) throw new EmptyStackException();
        return list.removeLast();
    }
    
    /**
     * Returns the element at the top of this stack without removing it from the stack.
     * The worstTime(n) and averagetime(n) are constant.
     * 
     * @return the element at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E peek()
    {
        if(list.size() == 0) throw new EmptyStackException();
        return list.peekLast();
    }
    
    /**
     * Remove (Clear) all elements from this stack.
     */
    public void empty()
    {
        list.clear();
    }
}
