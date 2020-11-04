import java.util.Collections;
import java.util.Comparator;

public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) throws NullPointerException {
        if (a == null || key == null || comparator == null) throw new NullPointerException();

        int index = -1;

        int left = 0;
        int right = a.length - 1;
        for (int mid = a.length / 2; left <= right; mid = (right + left) / 2) {
            int result = comparator.compare(key, a[mid]);
            if (result > 0) left = mid + 1;
            else if (result < 0) right = mid - 1;
            else {
                index = mid;
                right = mid - 1;
            }
        }

        return index; // If we didn't find it return -1
    }

    /**
     * Returns the index of the last key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) throws NullPointerException {
        if (a == null || key == null || comparator == null) throw new NullPointerException();

        int index = -1;

        int left = 0;
        int right = a.length - 1;
        for (int mid = a.length / 2; left <= right; mid = (right + left) / 2) {
            int result = comparator.compare(key, a[mid]);
            if (result > 0) left = mid + 1;
            else if (result < 0) right = mid - 1;
            else {
                index = mid;
                left = mid + 1;
            }
        }

        return index;
    }
}