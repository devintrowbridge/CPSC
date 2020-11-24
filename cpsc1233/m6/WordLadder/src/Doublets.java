import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Provides an implementation of the WordLadderGame interface. The lexicon
 * is stored as a HashSet of Strings.
 *
 * @author Devin Trowbridge (dkt0003@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    private HashSet<String> lexicon;

    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
            lexicon = new HashSet<String>();
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }

    @Override
    public int getHammingDistance(String str1, String str2) {
        if (str1.length() != str2.length()) return -1;

        int distance = 0;

        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) ++distance;
        }

        return distance;
    }

    @Override
    public List<String> getMinLadder(String start, String end) {
        Deque<Node<String>> queue = new ArrayDeque<>();
        List<String> ladder = new LinkedList<>();

        if(start.equals(end)) {
            ladder.add(start);
            return ladder;
        }

        HashSet<String> touched = new HashSet<>();

        // Add the root to all our lists
        Node<String> root = new Node<>(start);
        touched.add(start);
        queue.addLast(root);

        // Continuously add strings to the queue until we find the end
        while (!queue.isEmpty()) {
            Node<String> current = queue.removeFirst();

            // If we found the end, generate the path to root and return it
            if (current.element.equals(end)) {
                List<String> path = current.pathToRoot();
                Collections.reverse(path);
                return path;
            }

            // Add all the neighbors we haven't looked at yet to the queue
            for (String neighbor : getNeighbors(current.element)) {
                // if neighbor hasn't been touched yet
                if (touched.add(neighbor)) {
                    Node<String> n = current.addChild(neighbor);
                    queue.add(n);
                }
            }
        }

        return ladder;
    }

    @Override
    public List<String> getNeighbors(String word) {
        if (word == null) return null;

        List<String> neighbors = new LinkedList<>();

        for (String str : lexicon) {
            if (str.length() == word.length()) {
                int distance = getHammingDistance(word, str);
                if (distance == 1) neighbors.add(str);
            }
        }

        return neighbors;
    }

    @Override
    public int getWordCount() {
        return lexicon.size();
    }

    @Override
    public boolean isWord(String str) {
        if (str == null) return false;
        return lexicon.contains(str);
    }

    @Override
    public boolean isWordLadder(List<String> sequence) {
        if (sequence == null) return false;
        if (sequence.size() == 0) return false;
        if (!isWord(sequence.get(0))) return false;

        // For each string in the sequence, except the last...
        for (int i = 0; i < sequence.size() - 1; ++i) {
            String current = sequence.get(i);
            String next = sequence.get(i+1);

            // Make sure next is a word in the lex
            if (!isWord(next)) return false;

            // Get and check the Hamming distance
            int distance = getHammingDistance(current, next);
            if (distance != 1) return false;
        }

        return true;
    }

    private class Node<T> {
        Node<T> parent;
        List<Node<T>> children;
        T element;

        Node (T element) {
            children = new ArrayList<>();
            this.element = element;
        }

        Node<T> addChild(T child) {
            Node<T> n = new Node<>(child);
            n.parent = this;
            children.add(n);
            return n;
        }

        List<T> pathToRoot() {
            List<T> path = new LinkedList<>();
            path.add(element);

            Node<T> p = parent;
            while (p != null) {
                path.add(p.element);
                p = p.parent;
            }

            return path;
        }
    }
}

