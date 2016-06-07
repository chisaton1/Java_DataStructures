import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
/**
 * Queue which is implemented by LinkedList.
 *
 * LinkedListを用いてQueueを実装する
 * 
 * @author chisato
 * @version Fall 2015
 */
public class PureQueue<E>
{
    private LinkedList<E> list;
    /**
     *  Make new instance of LinkedList<E>
     */
    public PureQueue()
    {
        list = new LinkedList<E>();
    }
    
    /**
     * Inserts the specified element into this queue.
     * Returns true if it is success.
     */
    public boolean add(E e)
    {
        if(e == null)
        {
            throw new NullPointerException();
        }
        return list.add(e);
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     */
    public E element()
    {
        if(list.size() == 0)
        {
            throw new NoSuchElementException();
        }
        return list.element();
    }
    
    /**
     * Inserts the specified element into this queue
     */
    public boolean offer(E e)
    {
        if(e == null)
        {
            throw new NullPointerException();
        }
        return list.offer(e);
    }
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     */
    public E peek()
    {
        return list.peekFirst();
    }
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     */
    public E poll()
    {
        return list.pollFirst();
    }
    
    /**
     * Retrieves and removes the head of this queue.
     */
    public E remove()
    {
        if(list.size() == 0)
        {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }
}
