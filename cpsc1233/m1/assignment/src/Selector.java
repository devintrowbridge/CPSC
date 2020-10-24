import java.util.Arrays;

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
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) throws IllegalArgumentException{
        if (a == null || a.length == 0) throw new IllegalArgumentException();

        int lowest = a[0];

        for (int num : a) {
            if (num < lowest) {
                lowest = num;
            }
        }
        return lowest;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) throws IllegalArgumentException{
        if (a == null || a.length == 0) throw new IllegalArgumentException();
        int highest = a[0];

        for (int num : a) {
            if (num > highest) {
                highest = num;
            }
        }
        return highest;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) throws IllegalArgumentException{
        if (a == null || a.length == 0 || k < 1 || k > a.length) throw new IllegalArgumentException();
        int kmin = 0;
        int[] b = Arrays.copyOf(a, a.length);
        if (k == 1) {
            kmin = min(a);
        }
        else {
            Arrays.sort(b);
            b = removeDuplicates(b);
            if (k > b.length) {
                throw new IllegalArgumentException();
            }
            kmin = b[k - 1];
        }

        return kmin;
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) throws IllegalArgumentException{
        if (a == null || a.length == 0 || k < 1 || k > a.length) throw new IllegalArgumentException();
        int kmax = 0;
        int[] b = Arrays.copyOf(a, a.length);

        if (k == 1) {
            kmax = max(a);
        }
        else {
            Arrays.sort(b);
            b = removeDuplicates(b);
            if (k > b.length) {
                throw new IllegalArgumentException();
            }
            kmax = b[b.length - k];
        }

        return kmax;
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) throws IllegalArgumentException{
        if (a == null || a.length == 0) throw new IllegalArgumentException();
        // Get count of numbers in range
        int count = 0;
        for (int num : a) {
            if (num >= low && num <= high) ++count;
        }

        // Populate rtn array
        int[] rtn_arr = new int[count];
        int i = 0;
        for (int num : a) {
            if (num >= low && num <= high) {
                rtn_arr[i++] = num;
            }
        }

        return rtn_arr;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) throws IllegalArgumentException {
        if (a == null || a.length == 0 || key > max(a)) throw new IllegalArgumentException();
        int smallest = max(a);

        for (int num : a) {
            if ((num >= key) && (num < smallest)) smallest = num;
        }
        return smallest;
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) throws IllegalArgumentException {
        if (a == null || a.length == 0 || key < min(a)) throw new IllegalArgumentException();
        int largest = min(a);

        for (int num : a) {
            if ((num <= key) && (num > largest)) largest = num;
        }
        return largest;
    }


    private static int countDistinctValues(int[] a) {
        int rtn = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) rtn++;
        }
        return rtn;
    }

    private static int[] removeDuplicates(int[] a) {
        int[] b = new int[countDistinctValues(a)];
        b[0] = a[0];
        for (int i = 1, j = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) b[j++] = a[i];
        }
        return b;
    }
}
