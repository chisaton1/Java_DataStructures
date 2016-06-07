import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class has a main method which searches the answer of N-queens using recursion.
 * Get an integer from users, pass the value to EightQueens' constuctor, and output the answer.
 *
 * 再帰の演習。入力された数の升目に応じて、縦横被らずにクイーンを置く
 * 
 * @author Chisato Nakamura
 * @version Fall 2015
 */
public class EightQueensMain
{
   public static void main (String[]args)
   {
       System.out.println("Input an integer");
       Scanner scan = new Scanner(System.in);
       try
       {
           int inputNumber = scan.nextInt();
           new EightQueensMain().searchAnswer(new EightQueens(inputNumber));
       }
       catch (InputMismatchException e)
       {
           System.out.println("It is wrong type:" + e);
       }
   }
   
   /**
    * Serach the answer of N-queens and output it.
    * The start position is (1,0) since it is easy to find the solution; however, if users
    * input 1 as an integer, can't start the position (1,0). Therefore, in this case, starts (0,0).
    * If there is no answer, outputs, "There is no answer..."
    */
   public void searchAnswer (EightQueens eightQueens)
    {
      Position start = new Position(1,0);
      if(eightQueens.howManyQueens == 1)
      {
          start = new Position();
      }
      eightQueens.markAsPossible (start); //Put 'Q' at start position
      BackTrack backTrack = new BackTrack (eightQueens);
      if (eightQueens.isGoal (start) || backTrack.tryToReachGoal (start))
      {
          System.out.println("Answer");
          System.out.println(eightQueens);
          return;
      }
      System.out.println("There is no answer...\n");
      return;        
    }
}
