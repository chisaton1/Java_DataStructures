/**
*
* スレッドのrace condition(競合状態)を知り、それを解決するための演習
*
*
**/

public class SecondTally
{
    private volatile int tally;//変数のキャッシュを防ぐだけ
    
    public SecondTally( )
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
        SecondTally adder = new SecondTally( );
    }

//-------------  An embedded class -------------
 private class Incrementor extends Thread
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

