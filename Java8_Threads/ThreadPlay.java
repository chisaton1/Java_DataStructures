import java.util.concurrent.*;
/**
 * Java8で新たに導入されたラムダ式を試す
 * 
 * @author chisaton
 * @version Spring 2016
 */
public class ThreadPlay
{
   /*
    * demonstrate the use of a lambda expression to define the run method of a new 
    */
   public void demo1()
   {
       Runnable task = () -> {
           String threadName = Thread.currentThread().getName();
           System.out.println("Hello " + threadName);
       };

    task.run();

    Thread thread = new Thread(task);
    thread.start();

    System.out.println("Done!");
   }
   
   /*
    * Demonstrate ExecutorService
    */
   public void demo2()
   {
       ExecutorService executor = Executors.newSingleThreadExecutor();
       
       executor.submit(() -> { // submit this to the execute
          String threadName = Thread.currentThread().getName();
           System.out.println("Hello " + threadName);
        });

   }
}
