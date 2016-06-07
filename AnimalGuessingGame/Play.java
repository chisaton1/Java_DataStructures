import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Class Play starts Animal guessing game.
 * The main method has try and catch block of IOException,
 * so the other methods just throws exception which is IOException.
 *
 * YesかNoで答えていき、最終的に動物を当てるプログラム
 * 二分木の実装演習
 * 
 * @author chisaton
 * @version Fall 2015
 */

public class Play
{
    private BinaryNode<String> rootNode;
    private BinaryNode<String> currentNode;
    private BinaryNode<String> previousNode;
    private BinaryNode<String> roots;
    private boolean yN = false; // no
    
    /**
     * Start the game!
     */
       public static void main(String[] args) 
    {
        try
        {
            Play game = new Play();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * The constructor of Play. 
     * It shows the message at the biginning of this game.
     * If this game has played before, loads the binary tree which saved before using Serialize.
     */
    public Play() throws IOException
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animal.ser"));
            roots = (BinaryNode<String>)ois.readObject();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        if(roots == null)
        {
            currentNode = new BinaryNode<String>("a giraffe");
        }
        else
        {
            rootNode = roots;
            previousNode = roots;
            currentNode = roots;
        }
        System.out.println("Welcome to the Animal Guessing Game!");
        start();
    }
    
    /**
     * This method is a part of outputting questions for players.
     * Keep asking animals' feature questions until currentNode has animal name as an Item.
     * Once hits the currentNode, asks the animal name.
     */
    public void start() throws IOException
    {
        System.out.println("Think of an animal and I will try to guess it.");
        while(currentNode.getRight() != null && currentNode.getLeft() != null)
        {
            askQuestion();
            if(yesOrNo())
            {
                yN = true;
                previousNode = currentNode;
                currentNode = currentNode.getLeft();
            }
            else
            {
                yN = false;
                previousNode = currentNode;
                currentNode = currentNode.getRight();
            }
        }
        askAnimal();
        if(yesOrNo()) // if this guessing is correct
        {
            System.out.println("I'm genius!");
        }
        else
        {
            getAnmialAndQuestion();
        }
    }
    
    /**
     * This method is just a part of asking whether this currentNode's animal is correct or not.
     */
    public void askAnimal()
    {
        System.out.println("Is it " + currentNode.getItem() + "?");
    }
     
    /**
     * This method is also a part of asking for players, but this asks the feature of animals.
     */
    public void askQuestion()
    {
        System.out.println(currentNode.getItem()); //Does it ... ? Is it ... ?
    }
    
    /**
     * Since there are many yes or no questions in this code, this method is used when
     * needs yes or no answers. Returns true if players answer "yes". Otherwise returns false.
     * Ifthe palyer answers the other (not yes or no), asks again.
     */
    public boolean yesOrNo() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String yesOrNo = new String(in.readLine());
        if(yesOrNo.equals("yes"))
        {
            return true;
        }
        else if(yesOrNo.equals("no"))
        {
            return false;
        }
        else
        {
            System.out.println("Please input yes or no");
            return yesOrNo(); // return itself 
        }
    }
    
    /**
     * Gets an animal's name and a question.
     * Passes them to setUpNewQuestion method which sets them up in the binary tree.
     */
    public void getAnmialAndQuestion() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What animal were you thinking of?");
        String animal = new String(in.readLine());
        System.out.println("Enter a question having a yes answer for " + animal +
        " that will allow me to distinguish between " + currentNode.getItem() + " and " + animal + ":");
        String question = new String(in.readLine());
        setUpNewQuestion(animal, question);
        askPlayAgain();
    }
    
    /**
     * Asks the player wants to play again or not. If yes, resets currentNode and
     * previousNode and calls start method again. Otherwise, uses Deserialize in order to
     * save this binrary tree and finishes this program.
     */
    public void askPlayAgain() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Thanks! Do you want to play again?");
        if(yesOrNo())
        {
            currentNode = rootNode;
            previousNode = rootNode;
            start();
        }
        else // keep rooNode
        {
             try
            {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.ser"));
                oos.writeObject(rootNode);
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Gets an animal's name and a question as arguments and set the binary tree.
     * There are three patterns here.
     * One is the fisrt time sets the arguments because the first time is a little bit irregular.
     * One is sets them up to right node of the tree.
     * One is sets them up to left node of the tree.
     */
    public void setUpNewQuestion(String animal, String question)
    {
      if(rootNode != null && !yN) //no
      {
          BinaryNode<String> questionNode = new BinaryNode<String>(question, currentNode, new BinaryNode<String>(animal));
          previousNode.setRight(questionNode); // sets right node
      }
      else if(rootNode != null && yN) //yes
      {
          BinaryNode<String> questionNode = new BinaryNode<String>(question, currentNode, new BinaryNode<String>(animal));
          previousNode.setLeft(questionNode); // sets left node
      }
      else // the first time sets (rootNode == null)
      {
          BinaryNode<String> leftNode = new BinaryNode<String>(animal);
          rootNode = new BinaryNode<String>(question, currentNode, leftNode);
      }
    }
}
