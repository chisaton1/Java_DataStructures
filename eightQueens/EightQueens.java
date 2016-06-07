import java.util.*;
/**
 * This solves the N-queens problems.
 *
 * 再帰の演習。入力された数の升目に応じて、縦横被らずにクイーンを置く
 *
 * 
 * @author chisaton
 * @version Fall 2015
 * 
 */
public class EightQueens implements Application
{
    private char[][] grid;
    protected int howManyQueens;
    private static final char EMPTY = 'E';
    private static final char QUEEN = 'Q';
    private static int numberOfQueens;
    /**
     * Initialize grid to all elements are EMPTY.
     */
    public EightQueens(int queens)
    {
        howManyQueens = queens;
        numberOfQueens = queens; // use it in its inner class
        grid = new char[howManyQueens][howManyQueens];
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid [0].length; column++) {
                grid[row][column] =  EMPTY;
            }
        }
    }
    
    /**
      * Determines if a given position is legal and has no a Queen.
      * @param pos - the given position.
      * @return true if pos is a legal position to put a Queen.
      */     
    public boolean isOK (Position pos)
    {
        int row = pos.getRow();
        int col = pos.getColumn();
        if(row >= 0 && row < grid.length &&
                col >= 0 && col < grid [0].length &&
                grid [row][col] == EMPTY) // Empty and inside of grid
        {
               for(int j = 0; j < howManyQueens; j++) //check there is no a Queen in the vertical
               {
                   if(grid[j][col] == QUEEN)
                   {
                       return false;
                   }
               }
               for(int i = 0; i < howManyQueens; i++) //check the horizontal
               {
                   if(grid[row][i] == QUEEN)
                   {
                       return false;
                   }
               } 
               int currentRow = row;
               int currentCol = col;
               while(currentRow > 0 && currentCol > 0) //chack the diagonally left upwards
               {
                   currentRow--;
                   currentCol--;
                   if(grid[currentRow][currentCol] == QUEEN)
                   {
                       return false;
                   }
               }
               currentRow = row;
               currentCol = col;
               while(currentRow < howManyQueens-1 && currentCol > 0) //chack the diagonally left downwards
               {
                   currentRow++;
                   currentCol--;
                   if(grid[currentRow][currentCol] == QUEEN)
                   {
                       return false;
                   }
               }
               return true;
        }
        return false;
    }
    
    /**
     * Indicates that a given position is possibly to be able to put a Queen, and decrement the 
     * number of Queens.
     * @param pos the position that has been marked as possibly to be able to put all Queens
     */
    public void markAsPossible (Position pos)
    {
        grid [pos.getRow()][pos.getColumn()] = QUEEN;
        numberOfQueens--;
    }

    /**
     * Indicates whether all Queens can be put in the grid.
     * @param pos the position that may or may not be one of the answers.
     * @return true if all Queens were put in the grid; false otherwise.
     */ 
    public boolean isGoal (Position pos)
    {
        return numberOfQueens == 0; // could put all queens
    }
     
    /**
     * Indicates that a given position is not good to be able to put all Queens; therefore,
     * replace 'Q' with 'E' and increment the number of Queens.
     * @param pos the position that has been marked as EMPTY again.
     */
    public void markAsDeadEnd (Position pos)
    {
        grid [pos.getRow()][pos.getColumn()] = EMPTY;
        numberOfQueens++;
    }

    /**
     * Converts this Application object into a String object.
     * @return the String representation of this Application object.
     * 
     * In order to prevent from genarating many String instances, uses StringBuilder class.
     */
    public String toString()
    {
       StringBuilder answer = new StringBuilder();
       for(int row = 0; row < grid.length; row++)
       {
           for(int column = 0; column < grid [0].length; column++)
           {
               answer.append(String.valueOf(grid[row][column]) + ' ');
           }
           answer.append("\n"); // next row
       }
       return answer.toString();
    }

    /**
     * Produces an Iterator object that starts at a given position.
     * @param pos the position the Iterator object starts at.
     * @return an Iterator object that accesses the positions directly
     *               available from pos.             
     */
    public Iterator<Position> iterator (Position pos)
    {
        return new MazeIterator (pos);
    }

      protected class MazeIterator implements Iterator<Position> 
      {
          protected int row, column, count;
          protected Position nextPosition = new Position();
          /**
           * Initializes this MazeIterator object to start at a given position.
           * @param pos the position the Iterator objects starts at.
           */
           public MazeIterator (Position pos)
           {
               row = pos.getRow();
               column = pos.getColumn();
               count = 0;
           } // constructor

          /**
           * Determines if this MazeIterator object can advance to another
           * position.
           * @return true if this MazeIterator object can advance; false otherwise.
           */
           public boolean hasNext () 
           {
               if(row == howManyQueens-1 && column == howManyQueens-1)
               {
                   return false;
               }
               return count < howManyQueens;
           } // method hasNext

          /**
           * Advances this MazeIterator object to the next position.
           * There are two possibly next position: one is to go to south (row+1), and another is
           * to go to next column
           * @return the position advanced to.
           */  
           public Position next () 
           {
                if(row == howManyQueens-1 && column != howManyQueens-1) // next column
                {
                    row = 0;
                    nextPosition = new Position(row, ++column);
                    count = 0;
                }
                else
                {
                    nextPosition = new Position(++row, column); //south
                    count++;
                }
                return nextPosition;
           } // method next
  
          public void remove () 
          { 
               // removal is illegal for a MazeIterator object
               throw new UnsupportedOperationException(); 
          } // method remove
        } // class MazeIterator
}