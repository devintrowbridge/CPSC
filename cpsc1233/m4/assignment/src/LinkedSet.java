import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Devin Trowbridge (dkt0003@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
    public boolean add(T element) {
        if (element == null) return false;
        Node n = new Node(element);

        // first item requires special care
        if (isEmpty()) {
            front = n;
            rear = n;
            ++size;
            return true;
        }

        Node p = front;
        while (p != null) {
            if (element.compareTo(p.element) < 0) {
                if (p == front) pushFront(element);
                else pushMid(element, p);
                return true;
            }
            else if (element.compareTo(p.element) > 0) p = p.next;
            else return false; // if they're equal return false since we don't allow dupes
        }

        // If we exit the loop without hitting any of the conditions, that means element is the
        // greatest value in the set, so we push it to the back
        pushBack(element);

        return true;
    }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
    public boolean remove(T element) {
        if (element == null) return false;
        if (size == 0)       return false;

        // last item requires special care
        if (size == 1 && element.compareTo(front.element) == 0) {
            front = null;
            rear  = null;
            --size;
            return true;
        }

        Node p = front;
        while (p != null) {
            if (element.compareTo(p.element) != 0) p = p.next;
            else {
                if      (p == front) popFront();
                else if (p == rear ) popBack();
                else                 popMid(p);
                return true;
            }
        }

        return false;
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
    public boolean contains(T element) {
        for (T this_element : this) {
            if (element.compareTo(this_element) == 0) return true;
        }
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) {
        if (s.isEmpty() && this.isEmpty()) return true;
        if (s.isEmpty() ^  this.isEmpty()) return false;
        if (s.size()    != this.size())    return false;

        Iterator<T> this_it = iterator();
        Iterator<T> s_it = s.iterator();

        // iterate  over this
        for (T element : this) {                        // O(N^2)
            if (!s.contains(element)) return false;
        }

        // iterate over other set
        for (T element : s) {                            // O(N^2)
            if (!this.contains(element)) return false;
        }

        return true;
    }

    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) {
        if (s.isEmpty() && this.isEmpty()) return true;
        if (s.isEmpty() ^  this.isEmpty()) return false;
        if (s.size()    != this.size())    return false;

        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();

        while (this_it.hasNext() && s_it.hasNext()) {
            if (this_it.next().compareTo(s_it.next()) != 0) return false;
        }

        return true;
    }

    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(Set<T> s){
        if (s.isEmpty()) return this;
        if (this.isEmpty()) return s;
        Set<T> rtn_set = new LinkedSet<T>();

        for (T element : this) rtn_set.add(element); // O(N^2)
        for (T element : s)    rtn_set.add(element); // O(N^2)

        return rtn_set;
    }

    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s){
        if (s.isEmpty()) return this;
        if (this.isEmpty()) return s;

        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();

        T this_current = this_it.next();
        T s_current = s_it.next();

        Set<T> rtn_set = new LinkedSet<T>();
        while (s_it.hasNext() && this_it.hasNext()) {
            if (this_current.compareTo(s_current) < 0) {
                rtn_set.add(this_current);
                this_current = this_it.next();
            }
            else { // if(this_current.compareTo(s_current) >= 0)
                rtn_set.add(s_current);
                s_current = s_it.next();
            }
        }

        // Add any remaining elements out of each set
        while (s_it.hasNext()) {
            rtn_set.add(s_current);
            s_current = s_it.next();
        }

        while (this_it.hasNext()) {
            rtn_set.add(s_current);
            this_current = this_it.next();
        }

        // Add the last element of each set
        rtn_set.add(this_current);
        rtn_set.add(s_current);

        return rtn_set;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) {
        Set<T> rtn_set = new LinkedSet<T>();
        if (s.isEmpty() || this.isEmpty()) return rtn_set;

        for (T element : this) {
            if (s.contains(element)) rtn_set.add(element);
        }

        return rtn_set;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
    public Set<T> intersection(LinkedSet<T> s) {
        Set<T> rtn_set = new LinkedSet<T>();
        if (s.isEmpty() || this.isEmpty()) return rtn_set;

        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();

        T this_current = this_it.next();
        T s_current = s_it.next();

        while (this_it.hasNext() && s_it.hasNext()) {
            if (this_current.compareTo(s_current) < 0) { // increment this
                this_current = this_it.next();
            }
            else if(this_current.compareTo(s_current) > 0) { // increment s
                s_current = s_it.next();
            }
            else { //add and increment both
                rtn_set.add(s_current);
                s_current = s_it.next();
                this_current = this_it.next();
            }
        }

        if (this_current.compareTo(s_current) == 0) rtn_set.add(s_current);

        return rtn_set;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) {
        Set<T> rtn_set = new LinkedSet<T>();
        if (this.isEmpty()) return rtn_set;
        if (   s.isEmpty()) return this;

        for (T element : this) {
            if (!s.contains(element)) rtn_set.add(element);
        }

        return rtn_set;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) {
        Set<T> rtn_set = new LinkedSet<T>();
        if (this.isEmpty()) return rtn_set;
        if (   s.isEmpty()) return this;

        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it    = s.iterator();

        // Already checked to make sure both sets have at least one element so
        // calling next before checking is permissible
        T this_element = this_it.next();
        T s_element = s_it.next();

        while(this_it.hasNext() && s_it.hasNext()) {
            if (this_element.compareTo(s_element) < 0) { // smaller than any element of either set
                rtn_set.add(this_element);
                this_element = this_it.next();
            }
            else if (this_element.compareTo(s_element) > 0) {
                s_element = s_it.next();
            }
            else {
                s_element = s_it.next();
                this_element = this_it.next();
            }
        }

        // If we hit the end of s before this, need to add the rest
        while (this_it.hasNext()) rtn_set.add(this_it.next());

        // Add the last element in this
        if (this_element.compareTo(s_element) != 0) rtn_set.add(this_element);

        return rtn_set;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() {
        return new AscendingIterator();
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return new DescendingIterator();
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {
        return new PowerSetIterator(this);
    }

    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////
    /**
     * Pushes an element onto the front of the list
     *
     * @param element element to push
     */
    private void pushFront(T element) {
        Node n = new Node(element);
        n.next = front;
        front.prev = n;
        front = n;
        ++size;
    }

    /**
     * Pushes an element into the middle of the list
     *
     * @param element element to push
     * @param nextNode node that comes immediately after the element
     */
    private void pushMid(T element, Node nextNode) {
        Node n = new Node(element);
        n.next = nextNode;
        n.prev = nextNode.prev;
        n.next.prev = n;
        n.prev.next = n;
        ++size;
    }

    /**
     * Pushes an element onto the back of the list
     *
     * @param element element to push
     */
    private void pushBack(T element) {
        Node n = new Node(element);
        rear.next = n;
        n.prev = rear;
        rear = n;
        ++size;
    }

    /**
     * Pops an element off the front of the list
     */
    private T popFront() {
        T rtnEl = front.element;
        front = front.next;
        front.prev = null;
        --size;
        return rtnEl;
    }

    /**
     * Pops an element off the middle of the list
     * @param n node to remove from the list
     */
    private T popMid(Node n) {
        T rtnEl = n.element;
        n.next.prev = n.prev;
        n.prev.next = n.next;
        --size;
        return rtnEl;
    }

    /**
     * Pops an element off the back of the list
     */
    private T popBack() {
        T rtnEl = rear.element;
        rear = rear.prev;
        rear.next = null;
        --size;
        return rtnEl;
    }

    ////////////////////
    // Nested classes //
    ////////////////////


    /**
     * Provides an implementation of and ascending iterator
     * over this set.
     *
     * @author Devin Trowbridge (dkt0003@auburn.edu)
     */
    public class AscendingIterator implements Iterator<T> {
        private Node current;

        AscendingIterator() {
            current = front;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T rtn_element = current.element;
            current = current.next;
            return rtn_element;
        }

        public void remove() {
            LinkedSet.this.remove(current.prev.element);
        }
    };

    /**
     * Provides an implementation of and descending iterator
     * over this set.
     *
     * @author Devin Trowbridge (dkt0003@auburn.edu)
     */
    public class DescendingIterator implements Iterator<T> {
        private Node current;

        DescendingIterator() {
            current = rear;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T rtn_element = current.element;
            current = current.prev;
            return rtn_element;
        }

        public void remove() {
            LinkedSet.this.remove(current.next.element);
        }
    };

    /**
     * Provides an implementation of an iterator over the power set of this set
     * A power set is the set of all subsets of a particular set.
     * There are 2^N members of the powerset where N is the number of elements in this set.
     *
     * @author Devin Trowbridge (dkt0003@auburn.edu)
     */
    public class PowerSetIterator implements Iterator<Set<T>> {
        private Set<T> set = new LinkedSet<>();
        private int current = 0;
        private int max = 1;
        private String paddingString;

        public PowerSetIterator(LinkedSet<T> inSet) {
            if (inSet == null) throw new NullPointerException();
            for (T element : inSet) {
                set.add(element);
                max *= 2; // 2^n elements in the powerset Everytime we add an element, multiply max by two
            }

            paddingString = "%" + set.size() + "s";
        }

        public boolean hasNext() {
            return current < max;
        }

        public Set<T> next() {
            if (!hasNext()) throw new NoSuchElementException();
            Set<T> rtn_set = new LinkedSet<T>();

            // Handle case where this is the empty set
            if (max == 1) {
                ++current;
                return rtn_set;
            }

            // Get the binary string representation of the current iteration
            String bitmask = Integer.toBinaryString(current++);
            bitmask = String.format(paddingString, bitmask).replace(' ', '0');

            Iterator<T> set_it = set.iterator();

            int i = 0;
            for (char c : bitmask.toCharArray()) {
                if (set_it.hasNext()) {
                    if (c == '1') {
                        rtn_set.add(set_it.next());
                    } else {
                        set_it.next();
                    }
                }
            }

            return rtn_set;
        }

    }


    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}
