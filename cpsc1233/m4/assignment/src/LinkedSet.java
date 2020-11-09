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
 * @author YOUR NAME (you@auburn.edu)
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
        if (element == null || contains(element)) return false;
        Node n = new Node(element);
        if (isEmpty()) {
            front = n;
            rear = n;
            ++size;
            return true;
        }

        Node p = front;
        for (int i = 0; i < size; ++i) {
            if (element.compareTo(p.element) > 0) p = p.next;
            else if (element.compareTo(p.element) < 0) {
                n.next = p;
                n.prev = p.prev;
                n.prev.next = n;
                n.next.prev = n;
                ++size;
                return true;
            }
        }

        return false;
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
        if (element == null || !contains(element)) return false;

        Node p = front;
        for (int i = 0; i < size; ++i) {
            if (element.compareTo(p.element) != 0) p = p.next;
            else {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                --size;
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
        Node p = front;
        for (int i = 0; i < size; ++i) {
            if (element.compareTo(p.element) == 0) return true;
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
        Iterator<T> this_it = iterator();
        Iterator<T> s_it = s.iterator();

        // iterate  over this
        while (this_it.hasNext()) {
            if (!s.contains(this_it.next())) return false;
        }

        // iterate over other set
        while (s_it.hasNext()) {
            if (!this.contains(s_it.next())) return false;
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
        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();
        Set<T> rtn_set = new LinkedSet<T>();

        while (this_it.hasNext()) rtn_set.add(this_it.next());
        while (s_it.hasNext()) rtn_set.add(s_it.next());

        return rtn_set;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s){
        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();
        Set<T> rtn_set = new LinkedSet<T>();

        T this_current = this_it.next();
        T s_current = s_it.next();
        rtn_set.add(this_current);
        rtn_set.add(s_current);

        while (this_it.hasNext() || s_it.hasNext()) {
            if (this_current.compareTo(s_current) < 0) {
                rtn_set.add(this_current);
                this_current = this_it.next();
            }
            else { // if(this_current.compareTo(s_current) >= 0)
                rtn_set.add(s_current);
                s_current = s_it.next();
            }
        }

        return rtn_set;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) {
        Iterator<T> this_it = this.iterator();
        Set<T> rtn_set = new LinkedSet<T>();

        while (this_it.hasNext()) {
            T current = this_it.next();
            if (s.contains(current)) rtn_set.add(current);
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
        Iterator<T> this_it = this.iterator();
        Iterator<T> s_it = s.iterator();
        Set<T> rtn_set = new LinkedSet<T>();


        return rtn_set;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) {
        Iterator<T> this_it = this.iterator();

        Set<T> rtn_set = new LinkedSet<T>();

        while (this_it.hasNext()) {
            T current = this_it.next();
            if (!s.contains(current)) rtn_set.add(current);
        }

        return null;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) {
        return null;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = front;

            public boolean hasNext() {
                return current.next != null;
            }

            public T next() {
                if (current == null && !isEmpty()) {
                    current = front;
                    return (T) current;
                }
                if (hasNext()) {
                    current = current.next;
                    return (T) current;
                }
                return null;
            }
        };
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            Node current = null;

            public boolean hasNext() {
                return current.prev != null;
            }

            public T next() {
                if (current == null && !isEmpty()) {
                    current = rear;
                    return (T) current;
                }
                if (hasNext()) {
                    current = current.prev;
                    return (T) current;
                }
                return null;
            }
        };
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {

    }





    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////

    public class powerSetIterator implements Iterator<Set<T>> {
        Set<T> current = null;
        int iterations = 0;

        public powerSetIterator() {

        }

        public boolean hasNext() {
            // If current and set are equal, we've reach the end
            return !LinkedSet.this.equals(current);
        }

        public Set<T> next() {
            Set<T> rtn_set = new LinkedSet<T>();
            Iterator<T> it = iterator();

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
