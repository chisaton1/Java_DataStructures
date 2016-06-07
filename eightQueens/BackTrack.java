import java.util.*;
public class BackTrack 
{
    protected Application app;
    /**
     * Initializes this BackTrack object from an application.
     * 
     * @param app the application 
     *
     * 再帰の演習。入力された数の升目に応じて、縦横被らずにクイーンを置く
     */    
     public BackTrack (Application app) 
     {
         this.app = app;        
     } // constructor

     /**
       * Attempts to reach a goal through a given position.
       * 
       * @param pos the given position.
       * 
       * @return true if the attempt succeeds; otherwise, false.
       */        
     public boolean tryToReachGoal (Position pos) // important
     {                
         
         Iterator<Position> itr = app.iterator (pos);
         while (itr.hasNext())
         {
              pos = itr.next();
              if (app.isOK (pos)) // EMPTY, inside of grid, and a Queen can be put in this position
              {
                  app.markAsPossible (pos); // put a Queen
                  if (app.isGoal (pos) || tryToReachGoal (pos)) // recursion                
                       return true;
                  app.markAsDeadEnd (pos); // This position is not good to put a Queen, so replace QUEEN with EMPTY 
              } // pos may be on a path to a goal
         } // while 
         return false;
    } // method tryToReachGoal
} // class BackTrack
