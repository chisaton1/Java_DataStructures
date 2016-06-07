import java.util.concurrent.*;

/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class ThirdTallyVersion2
{
    private volatile int tally;
    
    public ThirdTallyVersion2( )
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
    
    public void updateTally()
    {
            int num = tally;
            num = num + 1;           
            SleepUtilities.nap(1);            
            tally = num;         
    }
    
    public static void main(String[ ] args)
    {
        ThirdTallyVersion2 adder = new ThirdTallyVersion2( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread
{
    @Override  
    public void run( )
    {
        for(int k = 0; k < 200; k++)
        {
            updateTally();
        }
    }
}
   
}

