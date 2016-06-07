import java.util.concurrent.*;

/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class SemaphoreTally
{
    private volatile int tally;
    private Semaphore sem;
    
    public SemaphoreTally( )
    {
        tally = 0;   
        
        Incrementor first = new Incrementor();
        Incrementor second = new Incrementor();
        sem = new Semaphore(1);
        
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
        SemaphoreTally adder = new SemaphoreTally( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread
{
    @Override
    public void run( )
    {
        for(int k = 0; k < 200; k++)
        {
            try
            {
                sem.acquire();
            }
            catch(InterruptedException ex)
            {    
            }
            
            int num = tally;
            num++;                                    
            tally = num; 
            SleepUtilities.nap(1); 
            sem.release();
            
        }
    }
}
   
}

