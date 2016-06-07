/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
　*
　* スレッドのrace condition(競合状態)を知り、それを解決するための演習
　*
　**/

public class SleepUtilities
{

	/**
	 * Nap between zero and duration seconds.
	 */
	public static void nap(int duration) {
        	int sleeptime = (int) (duration * 10 * Math.random() );
        	try { Thread.sleep(sleeptime); }
        	catch (InterruptedException e) {
        	   System.out.println("nap caught an interrupted exception");
            }
	}

}
