import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Autocomplete {
    private List<Term> m_terms = new ArrayList<Term>();

    /**
     * Initializes a data structure from the given array of terms.
     * This method throws a NullPointerException if terms is null.
     */
    public Autocomplete(Term[] terms) throws NullPointerException {
        if (terms == null) throw new NullPointerException("Null terms array");

        m_terms = new ArrayList<Term>(Arrays.asList(terms));
        m_terms.sort(null);
    }

    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     * This method throws a NullPointerException if prefix is null.
     */
    public Term[] allMatches(String prefix) throws NullPointerException {
        if (prefix == null) throw new NullPointerException("Prefix is null");

        // Generate a primitive array of the terms
        Term[] terms_arr = new Term[m_terms.size()];
        terms_arr = m_terms.toArray(terms_arr);

        // Get the start and end index of the terms matching the prefix
        int start_idx = BinarySearch.<Term>firstIndexOf(terms_arr, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));
        int end_idx = BinarySearch.<Term>lastIndexOf(terms_arr, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));

        // Populate a list with all of the terms between start and end then sort by weight
        List<Term> prefixList = new ArrayList<Term>();
        for (int i = start_idx; i <= end_idx; i++) {
            prefixList.add(m_terms.get(i));
        }
        prefixList.sort(Term.byDescendingWeightOrder());

        // Populate and return array
        Term[] rtn_arr = new Term[prefixList.size()];
        rtn_arr = prefixList.toArray(rtn_arr);
        return rtn_arr;
    }

}