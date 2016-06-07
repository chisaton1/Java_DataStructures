/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class FirstTally
{
    private volatile int tally;
    
    public FirstTally( )
    {
        tally = 0;
        
        Incrementor first = new Incrementor();
        Incrementor second = new Incrementor();
        
        first.start( );
        try{           
            first.join( );
        }
        catch(InterruptedException e){
            System.out.println("InterruptedException while waiting for first");
        }

        
        second.start( );        
        try{           
            second.join( );
        }
        catch(InterruptedException e){
            System.out.println("InterruptedException while waiting for second");
        }
        
        System.out.println(tally);
        
    }
    
    public static void main(String[ ] args)
    {
        FirstTally adder = new FirstTally( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread // or implements runnable
{
       
    public void run( )
    {
        for(int k = 0; k < 200; k++)
        {
            int num = tally;
            num++;             
            SleepUtilities.nap(1);            
            tally = num; 
        }
    }
}
   
}

