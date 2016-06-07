import java.util.concurrent.*;

/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class ThirdTally
{
    private volatile int tally;
    
    public ThirdTally( )
    {
        tally = 0;   
        
        Incrementor first = new Incrementor();
        Incrementor second = new Incrementor();
        
        first.start( );       
        second.start( ); 
        
        try{   
            first.join( );
            second.join( );
        }
        catch(InterruptedException e){
        }
        
        System.out.println(tally);
        
    }
    
    public static void main(String[ ] args)
    {
        ThirdTally adder = new ThirdTally( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread
{
       
    public void run( )
    {
        for(int k = 0; k < 200; k++)
        {
            int num = tally;
            num = increment(num);            
            SleepUtilities.nap(1);            
            tally = num; 
        }
    }
    
    public synchronized int increment(int value)
    {
        return ++value;
    }
}
   
}

