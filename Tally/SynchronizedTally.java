import java.util.concurrent.*;

/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class SynchronizedTally
{
    private volatile int tally;
    
    public SynchronizedTally( )
    {
        tally = 0;   
        
        Incrementor first = new Incrementor("A");
        Incrementor second = new Incrementor("B");
        
        first.start( );       
        second.start( ); 
        
        try{   
            first.join( );
            second.join( );
        }
        catch(InterruptedException e){
            System.out.println("SynchronizedTally caught an InterruptedException");
        }
        
        System.out.println(tally);
        
    }
    
    // note: the synchronized method must be something that is shared among the threads
    public synchronized void updateTally()
    {
        int num = tally;
        num = num + 1;
        SleepUtilities.nap(1);
        tally = num;
    }
    
    public static void main(String[ ] args)
    {
        SynchronizedTally adder = new SynchronizedTally( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread
{
    private String name;
    
    public Incrementor(String id)
    {
        super(id);
        name = id;
    }
    
    @Override
    public void run( )
    {
        for(int k = 0; k < 200; k++)
            updateTally();               
    }

}
   
}

