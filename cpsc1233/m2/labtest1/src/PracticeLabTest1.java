import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Practice lab test 1.
 */
public class PracticeLabTest1 {

    //-----------------------------------------------------------
    //   P R O B L E M   O N E

    /**
     * Returns the number of positive integers in the given array.
     */
    public static int countPositives(int[] a) {
        int rtn = 0;
        for(int num : a) {
            if (num > 0) rtn++;
        }
        return rtn;
    }



    //-----------------------------------------------------------
    //   P R O B L E M   T W O

    /**
     * Returns the number of even integers in the given array.
     */
    public static int countEvens(int[] a) {
        int rtn = 0;
        for(int num : a) {
            if ((num % 2) == 0) rtn++;
        }
        return rtn;
    }



    //-----------------------------------------------------------
    //   P R O B L E M   T H R E E

    /**
     * Returns a collection that contains all the values in Collection parameter `set` 
     * that are strictly less than the parameter `toElement` with respect to the total order 
     * defined by the Comparator parameter `order`. 
     *
     * Example:
     *
     * set = [2, 4, 6, 8, 10] 
     * toElement = 9
     * order = (a Comparator that defines ascending numeric order)
     * return value = [4, 6, 8]
     *
     */
    public static <T> Collection<T> headSet(Collection<T> set,
                                            T toElement,
                                            Comparator<T> order) {
        Collection<T> result = new ArrayList<T>();
        for (T element : set) {
            if (order.compare(element,toElement) < 0) result.add(element);
        }
        return result;
    }



    //-----------------------------------------------------------
    //   P R O B L E M   F O U R

    /**
     * Returns a Collection that contains all the values in the given 
     * collection parameter that are equal to key according to NATURAL ORDER
     * (compareTo). 
     *
     * Example:
     *
     * collection = [2, 4, 6, 8, 2, 10] 
     * key = 2
     * return value = [2, 2]
     *
     */
    public static <T extends Comparable<T>> Collection<T> getMatches(Collection<T> collection, T key) {
        Collection<T> result = new ArrayList<T>();
        for (T element : collection) {
            if (key.compareTo(element) == 0) result.add(element);
        }
        return result;
    }



}