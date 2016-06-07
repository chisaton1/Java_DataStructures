
/**
 * Comparator&hashCodeの演習
 * 
 * @version Fall 2015
 */
public class Animal
{
   private String name;
   private int age;
   private int weight;

    public Animal(String name, int age, int weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int compareTo(Animal a)
    {
        int compVal = weight - a.weight;
        if(compVal == 0)
        {
            compVal = age - a.age;
        }
        if(compVal == 0)
        {
            name.compareTo(a.name);
        }
        return weight - a.weight;
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Animal))
        {
            return false;
        }
        Animal a = (Animal)obj;
        if(weight == a.weight && age == a.age && name.equals(a.name))
        {
            return true;
        }
        return false;
    }
    
    public int hashCode()
    {
        int result = 17;
        result = 37 * age + result;
        result = 37 * weight + result;
        result = 37 * name.hashCode() + result;
        return result;
    }
}
