import java.util.*;

/**
 * Implementation of some methods in SinglyLinkedList.
 * (lastIndexOf(Object o), indexOf(Object o), remove(int index), remove(Object o), get(int index))
 * 
 * 単方向リストの実装
 *
 * @author chisato
 * @version Fall 2015
 */
public class SinglyLinkedList<E> extends AbstractCollection<E> 
          implements List<E>
{
  protected Entry<E> head;  // reference to the first entry in the list                     
  /**
   * Initializes this SinglyLinkedList object to be empty, with elements to be of 
   * type E.
   */
  public SinglyLinkedList()
  {
    head = null;
  } // constructor
  
  /**
   *  Determines if this SinglyLinkedList object has no elements.
   *
   *  @return true -  if this SinglyLinkedList object has no elements; otherwise,
   *                          false.  
   */
  public boolean isEmpty ()  
  {
    return head == null;
  } // method isEmpty
  
  /**
   *  Adds a specified element to the front of this SinglyLinkedList object.
   *
   *  @param element - the element to be appended.   
   *
   */
  public void addToFront (E element) 
  {
    Entry<E> newEntry = new Entry<E>();
    newEntry.element = element;
    newEntry.next = head;
    head = newEntry;
  } // method addToFront
  
  /**
   *  Returns a SinglyLinkedListIterator object to iterate over this
   *  SinglyLinkedList object.
   *
   */  
  public Iterator<E> iterator()//ConcurrentModificationException
  {
    return new SinglyLinkedListIterator();
  } // method iterator
  
  /**  
   *  Determines the number of elements in this SinglyLinkedList object.
   *  The worstTime(n) is O(n).
   *
   *  @return the number of elements.
   */
  public int size() 
  {
    int count = 0;
    for (Entry<E> current = head; current != null; current = current.next)
      count++;
    return count;
  } // method size
  
  /** 
   *  Determines if this SinglyLinkedList object contains a specified element.
   *  The worstTime(n) is O(n).
   *
   *  @param obj - the specified element being sought.
   *
   *  @return true - if this SinglyLinkedList object contains element; otherwise,
   *                false. 
   *
   */
  public boolean contains (Object obj) 
  {
    if (obj == null)
    {
      for (Entry<E> current = head; current != null; current = current.next)
        if (obj == current.element)
          return true;
    } // if obj == null
    else   
      for (Entry<E> current = head; current != null; current = current.next)
        if (obj.equals (current.element))
          return true;
    return false;
  } // method contains    

  public ListIterator<E> listIterator(int index)
  {
    throw new UnsupportedOperationException( );
  }  
 
  public ListIterator<E> listIterator()
  {
    throw new UnsupportedOperationException( );
  }

  /**
   * Returns the index of the last occurrence of the specified element in this list, 
   * or -1 if this list does not contain the element.
   */
  public int lastIndexOf(Object o)
  {
    //throw new UnsupportedOperationException( );
    int index = 1;
    int keepAnswer = -1;
    if(o == null)
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(current.element == null)
            {
                keepAnswer = index;
            }
            index++;
        }
    }
    else
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(o.equals(current.element))
            {
                keepAnswer = index;
            }
            index++;
        }
    }
    return keepAnswer;
  }

  /**
   * Returns the index of the first occurrence of the specified element in this list, 
   * or -1 if this list does not contain the element.
   */
  public int indexOf(Object o)
  {
    //throw new UnsupportedOperationException( );
    int index = 1;
    if(o == null)
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(current.element == null)
            {
                return index;
            }
            index++;
        }
    }
    else
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(o.equals(current.element))
            {
                return index;
            }
            index++;
        }
    }
    return -1;
  }

  /**
   * Removes the element at the specified position in this list.
   * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public E remove(int index)
  {
   if(index <= 0 || index > size())
   {
       throw new IndexOutOfBoundsException();
   }
   Entry<E> current = head;
   if(index == 1)
   {
       head = current.next;
       return current.element;
   }
   for(int i = 0; i < index - 2; i++)
   {
        current = current.next; //Go to node n-1
   }
   Entry<E> temp = current.next;
   current.next = current.next.next; //If current.next is a last node, current.next.next is null
   return temp.element;
  }

  public void add(int index, E element)
  {    
    throw new UnsupportedOperationException();
  } // method add (int index, E element)

  public E set(int index, E element)
  {
    throw new UnsupportedOperationException( );
  }

  /**
   * Returns the element at the specified position in this list.
   * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public E get(int index)
  {
   if(index <= 0 || index > size())
   {
       throw new IndexOutOfBoundsException();
   }
   Entry<E> current = head;
   for(int  i = 0; i < index-1; i++) {
       current = current.next;
   }
   return current.element;
  }

  public boolean addAll(Collection<? extends E> c)
  {
    throw new UnsupportedOperationException( );
  }

  public boolean addAll(int index, Collection<? extends E> c)
  {
    throw new UnsupportedOperationException( );
  }

  public Object[] toArray() 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  public <E>E[] toArray(E[] a)
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  /**
   * Removes the first occurrence of the specified element from this list, if it is present.
   */
  public boolean remove(Object o) 
  { 
    //throw new UnsupportedOperationException( );
    Entry<E> temp = head;
    if(o == null)
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(o == current.element)
            {
                if(current.equals(head)) //If the object, which is an argument, is a first node
                {
                    head = head.next;
                    return true;
                }
                temp.next = current.next; // OR temp.next = temp.next.next
                return true;
            }
            temp = current; //might use it next loop
        }   
    }
    else
    {
        for(Entry<E> current = head; current != null; current = current.next)
        {
            if(o.equals(current.element))
            {
                if(current.equals(head))
                {
                    head = head.next;
                    return true;
                }
                temp.next = current.next;
                return true;
            }
            temp = current;
        }
    }
    return false;
  }
  
  public boolean containsAll(Collection<?> c) 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  
  public boolean removeAll(Collection<?> c) 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  public boolean retainAll(Collection<?> c) 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  public List<E> subList(int fromIndex, int toIndex)
  { 
    throw new UnsupportedOperationException( ); 
  }
  public void clear() 
  {
    head = null; 
  }
  
  public boolean equals(Object obj) 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  public int hashCode() 
  { 
    throw new UnsupportedOperationException( ); 
  }
  
  
  protected class SinglyLinkedListIterator implements Iterator<E> 
  {
    protected Entry<E> next;
    
    /**
     *  The iterator has been initialized.
     */
    protected SinglyLinkedListIterator() 
    {
      next = head;
    } // constructor
    
    
    /** 
     *  Returns the element this Iterator object was (before this call) 
     *  positioned at, and advances this Iterator object.
     *                    
     *  @return - the element this Iterator object was positioned at.
     *
     *  @throws NoSuchElementException if this Iterator object was
     *                 not postioned at an element before this call.
     */                            
    public E next() 
    {
      E theElement = next.element;
      next = next.next;
      return theElement;
    } // method next
    
    
    /**
     *  Determines if this Iterator object is positioned at an element in this
     *  Collection.
     *
     *  @return true - if this Iterator object is positioned at an element; 
     *                otherwise, false.                        
     */                   
    public boolean hasNext() 
    {       
      return next != null;
    } // method hasNext
    
    /**
     *  Removes the element returned by the most recent call to next().
     *  The behavior of this Iterator object is unspecified if the underlying 
     *  collection is modified ( while this iteration is in progress) other than 
     *   by calling this remove() method.
     *
     *  @throws IllegalStateException - if next() had not been called before
     *                 this call to remove(), or if there had been an intervening call 
     *                 to remove() between the most recent call to next() and this 
     *                 call.
     **/
    public void remove() 
    { 
      throw new UnsupportedOperationException( ); 
    }
    
  } // class SinglyLinkedListIterator
  
  
  protected class Entry<E>
  {
    protected E element;
    protected Entry<E> next;
    
  } // class Entry
  
} // class SinglyLinkedList
