import java.util.HashMap;
/**
 * 
 * 
 * @author chisaton
 * @version Fall 2015
 */
public class HashMapdemo
{
   private HashMap<String, String> myMap;
    
    public HashMapdemo()
    {
       myMap = new HashMap<String, String>();
       String amy = "amy";
       String bob= "bob";
       myMap.put(amy, "1/1/2001");
       myMap.put(bob, "2/2/2002");
       System.out.println("amy's hashcode is " + ((amy.hashCode()%16)-1));
       System.out.println("bob's hashcode is " + ((bob.hashCode()%16)-1));
    }
    
    public void add10More()
    {
         myMap.put("a", "a");
         myMap.put("b", "b");
         myMap.put("c", "c");
         myMap.put("d", "d");
         myMap.put("e", "e");
         myMap.put("f", "f");
         myMap.put("g", "g");
         myMap.put("h", "h");
         myMap.put("i", "i");
         myMap.put("j", "j");
    }
    
    public void add1()
    {
        myMap.put("k", "k");
    }
}
