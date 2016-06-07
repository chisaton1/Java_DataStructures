import java.io.Serializable;
/**
 * Each of instances of this class stored E item and two BinaryNode<E>
 * It allows to use the Serialization.
 *h
 * YesかNoで答えていき、最終的に動物を当てるプログラム
 * 二分木の実装演習
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class BinaryNode<E> implements Serializable
{
    private E item;
    private BinaryNode<E> right;
    private BinaryNode<E> left;
    /**
     * One constructor of BinaryNode<E> which has one argument.
     */
    public BinaryNode(E item)
    {
        this(item, null, null);
    }
    
    /**
     * Another constructor of BinaryNode<E> which has three arguments.
     */
    public BinaryNode(E item, BinaryNode<E> right, BinaryNode<E> left)
    {
       this.item = item;
       this.right = right;
       this.left = left;
    }
    
    /**
     * Set the argument to E item
     */
    public void setitem(E animalName)
    {
        item = animalName;
    }
    
    /**
     * Set the argument to BinaryNode<E> right
     */
    public void setRight(BinaryNode<E> right)
    {
        this.right = right;
    }
    
    /**
     * Set the argument BinaryNode<E> left
     */
    public void setLeft(BinaryNode<E> left)
    {
        this.left = left;
    }
    
    /**
     * Return E item
     */
    public E getItem()
    {
        return item;
    }
    
    /**
     * Return BinaryNode<E> right
     */
    public BinaryNode<E> getRight()
    {
        return right;
    }
    
    /**
     * Return BinaryNode<E> left
     */
    public BinaryNode<E> getLeft()
    {
        return left;
    }
}
