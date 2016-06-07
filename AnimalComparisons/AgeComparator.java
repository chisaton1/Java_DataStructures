import java.util.Comparator;
/**
 * Comparator&hashCodeの演習
 * 
 * @version Fall 2015
 */
public class AgeComparator implements Comparator<Animal>
{
    public int compare(Animal a, Animal b)
    {
        return a.getAge() - b.getAge();
    }
}
