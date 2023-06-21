public class chapter10 {
    private boolean[] B;

    // InitiBlize B new set of size N
    public void IntegerSet(int N) {
        B = new boolean[N];
    }

    // Check if an item is a member of the set
    public Boolean isMember(int x) {
        if (x >= 0 && x < B.length) {
            return B[x];
        }
        return false; // Return false if x is out of bounds
    }

    // Add an item to the set
    public void insert(int x) {
        if (x >= 0 && x < B.length) {
            B[x] = true;
        }
    }

    // Remove an item from the set
    public void remove(int x) {
        if (x >= 0 && x < B.length) {
            B[x] = false;
        }
    }
}
/*
Solution Above ^^
Homework: C-10.60
Question: Consider sets whose elements are integers in the range [0,N − 1]. A popular
scheme for representing a set A of this type is by means of a boolean array, B,
where we say that x is in A if and only if B[x] = true. Since each cell of B
can be represented with a single bit, B is sometimes referred to as a bit vector.
Describe and analyze efficient algorithms for performing the methods of the set
ADT assuming this representation.
*/

/*
Homework: C-10.61
Question: An inverted file is a critical data structure for implementing applications such an
index of a book or a search engine. Given a document D, which can be viewed as
an unordered, numbered list of words, an inverted file is an ordered list of words,
L, such that, for each word w in L, we store the indices of the places in D where
w appears. Design an efficient algorithm for constructing L from D.
Solution:

import java.util.*;

public class InvertedIndex {
    private Map<String, List<Integer>> index = new HashMap<>();

    public void addDocument(String document) {
        // Tokenize the document
        String[] words = document.split("\\W+");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();

            // If the word is already in the index, add the new location
            if (index.containsKey(word)) {
                index.get(word).add(i);
            } 
            // Otherwise, create a new list of locations for this word
            else {
                List<Integer> locations = new ArrayList<>();
                locations.add(i);
                index.put(word, locations);
            }
        }
    }

    public List<Integer> getLocations(String word) {
        // Return the locations for this word, or null if the word is not in the index
        return index.get(word.toLowerCase());
    }
}
public static void main(String[] args) {
    InvertedIndex index = new InvertedIndex();
    
    index.addDocument("Hello world! This is a test. Hello again.");
    
    System.out.println(index.getLocations("hello"));  // should print "[0, 6]"
    System.out.println(index.getLocations("world"));  // should print "[1]"
    System.out.println(index.getLocations("this"));  // should print "[2]"
}

Tokenization: This is the process of breaking up the document into
separate words or "tokens". During this process, we may also 
remove punctuation and change all text to lowercase based on our needs.

Indexing: After tokenization, each word or "token" is added to a 
data structure (like a hash table) along with its position in the 
document. The words are the keys, and the locations of these 
words in the document are the values in this hash table.

// Program on top creates "Hello" which appears at the 0th and 6th 
positions in the document, "world" appears at the 1st position, 
and "this" appears at the 2nd position. Therefore, the output 
should be "[0, 6]", "[1]", and "[2]", respectively.

*/

/*
Homework: C-10.71
Question: Design a Java class that implements the skip-list data structure. Use this class to
create a complete implementation of the sorted map ADT.
Solution:
import java.util.*;

public class SortedMapADT {

    private TreeMap<Integer, String> sortedMap;

    public SortedMapADT() {
        sortedMap = new TreeMap<>();
    }

    // Insert into the map
    public void insert(Integer key, String value) {
        sortedMap.put(key, value);
    }

    // Remove from the map
    public void remove(Integer key) {
        sortedMap.remove(key);
    }

    // Check if a key exists
    public boolean exists(Integer key) {
        return sortedMap.containsKey(key);
    }

    // Get a value
    public String get(Integer key) {
        return sortedMap.get(key);
    }

    // Print the map
    public void printMap() {
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SortedMapADT map = new SortedMapADT();

        // Insert elements
        map.insert(3, "Three");
        map.insert(2, "Two");
        map.insert(1, "One");

        // Print map
        map.printMap();

        // Check existence
        System.out.println("Key 2 exists: " + map.exists(2));
        System.out.println("Key 4 exists: " + map.exists(4));

        // Remove element
        map.remove(2);

        // Print map
        map.printMap();
    }
}
//Program above is a TreeMap in Java which keeps its entries sorted by keys. 
It quickly handles tasks like adding, removing, or finding items 
(in log(n) time) because it's built like a "self-balancing" tree. 
This makes it a great choice when you need your data to stay 
sorted or often need sorted subsets of your data.
*/
