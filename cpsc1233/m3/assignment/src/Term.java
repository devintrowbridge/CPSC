import java.util.Comparator;

public class Term implements Comparable<Term> {
    public String m_query = "";
    public long m_weight = 0;

    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) throws NullPointerException, IllegalArgumentException {
        if (query == null) throw new NullPointerException("Null Term query");
        if (weight < 0) throw new IllegalArgumentException("Negative Term weight");
        m_query = query;
        m_weight = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term lha, Term rha) {
                return Long.compare(rha.m_weight, lha.m_weight);
            }
        };
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) throws IllegalArgumentException {
        if (length <= 0) throw new IllegalArgumentException("Length less than 1");
        return new Comparator<Term>() {
            @Override
            public int compare(Term lha, Term rha) {
                String rha_substr = rha.m_query;
                String lha_substr = lha.m_query;
                if (length < rha.m_query.length()) {
                    rha_substr = rha_substr.substring(0, length);
                }
                if (length < lha.m_query.length()) {
                    lha_substr = lha_substr.substring(0, length);
                }
                return lha_substr.compareTo(rha_substr);
            }
        };
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
        return m_query.compareTo(other.m_query);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
        return m_query + "\t" + m_weight;
    }

}