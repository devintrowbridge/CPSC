import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods
 * on arrays of ints.
 *
 * @author   YOUR NAME (YOU@auburn.edu)
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  TODAY
 *
 */
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) throws IllegalArgumentException,
                                                                           NoSuchElementException {
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty()) throw new NoSuchElementException();

        T lowest = coll.iterator().next();
        for (T element : coll) {
            if (comp.compare(element, lowest) < 0) {
                lowest = element;
            }
        }
        return lowest;
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) throws IllegalArgumentException{
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty()) throw new NoSuchElementException();

        T highest = coll.iterator().next();;
        for (T element : coll) {
            if (comp.compare(element, highest) > 0) {
                highest = element;
            }
        }
        return highest;
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) throws IllegalArgumentException{
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty() || k <= 0) throw new NoSuchElementException();

        T kmin;
        List<T> b = new ArrayList<T>(coll);
        if (k == 1) {
            kmin = min(coll, comp);
        }
        else {
            java.util.Collections.sort(b, comp);
            removeDuplicates(b);
            if (k > b.size()) {
                throw new NoSuchElementException();
            }
            kmin = b.get(k - 1);
        }

        return kmin;
    }


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) throws IllegalArgumentException{
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty() || k <= 0) throw new NoSuchElementException();

        T kmax;
        List<T> b = new ArrayList<T>(coll);
        if (k == 1) {
            kmax = max(coll, comp);
        }
        else {
            java.util.Collections.sort(b, comp);
            removeDuplicates(b);
            if (k > b.size()) {
                throw new NoSuchElementException();
            }
            kmax = b.get(b.size() - k);
        }

        return kmax;
    }


    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                          Comparator<T> comp) throws IllegalArgumentException{
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty()                        ||
            comp.compare(low, high) > 0           ||
            comp.compare(low, max(coll,comp)) > 0 ||
            comp.compare(high, min(coll,comp)) < 0) throw new NoSuchElementException();


        // Populate rtn coll
        Collection<T> rtn_coll = new ArrayList<T>();
        for (T element : coll) {
            if ((comp.compare(element,low) >= 0) && (comp.compare(element, high) <= 0)) {
                rtn_coll.add(element);
            }
        }

        return rtn_coll;
    }


    /**
     * Returns the smallest value in the Collection coll that is greater than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the ceiling value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the ceiling value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) throws IllegalArgumentException {
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty() || comp.compare(key, max(coll, comp)) > 0) throw new NoSuchElementException();

        T smallest = max(coll, comp);
        for (T element : coll) {
            if ((comp.compare(element, key) >= 0) && (comp.compare(element, smallest) < 0)) smallest = element;
        }
        return smallest;
    }


    /**
     * Returns the largest value in the Collection coll that is less than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the floor value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the floor value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) throws IllegalArgumentException {
        if (coll == null || comp == null) throw new IllegalArgumentException();
        if (coll.isEmpty() || comp.compare(key, min(coll, comp)) < 0) throw new NoSuchElementException();

        T largest = min(coll, comp);
        for (T element : coll) {
            if ((comp.compare(element, key) <= 0) && (comp.compare(element, largest) > 0)) largest = element;
        }
        return largest;
    }


    private static <T> int countDistinctValues(List<T> a) {
        int rtn = 1;
        T last = a.iterator().next();
        for (T elem : a) {
            if (elem != last) rtn++;
            last = elem;
        }
        return rtn;
    }

    private static <T> void removeDuplicates(List<T> a) {
        List<T> duplicates = new ArrayList<T>();
        for (T element : a) {
            if (!duplicates.contains(element)) duplicates.add(element);
        }
        a.clear();
        a.addAll(duplicates);
    }
}
