
/**
 * Binary Searchに少し工夫を加えたサーチ                                             
 * 
 * @author chisaton
 * @version Spring 2016
 */

public class Search5
{
    public int searchIndex(String[] array, int first, int last, String str)
    {
        if(first > last) {
            return -1;
        }
        int middle = (first+last)/2;
        if(array[middle].isEmpty()) //調べた箇所が空だったら、そこから空ではない場所を左右両側から探す
        {
            int left = middle - 1;
            int right = middle + 1;
            while(true)
            {
                if(left < first && right > last) {
                    return -1;
                } else if (right <= last && !array[right].isEmpty()) {
                    middle = right;
                    break;
                } else if (left >= first && !array[left].isEmpty()) {
                    middle = left;
                    break;
                }
               right++;
               left--;
            }
        }
        
        if(str.equals(array[middle])) {
            return middle;
        } else if (array[middle].compareTo(str) < 0) { //右半分を探す
            return searchIndex(array, middle+1, last, str);
        } else {
            return searchIndex(array, middle, last-1, str);
        }
    }
    
    public int seaerch(String[] array, String str) {
        if(array == null || str == null || str == ""){  
           return -1;
        }
        return searchIndex(array, 0, array.length - 1, str);
    }
}