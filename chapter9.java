import datastructures.ArrayList;

public class chapter9<K extends Comparable<K>, V> {

    protected static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }

        public V getValue() { return value; }
    }
// other methods:
    private ArrayList<Entry<K, V>> heap = new ArrayList<>();

    private void swap(int j, int p) {
    }

    private int compare(chapter9.Entry<K, V> entry, chapter9.Entry<K, V> entry2) {
        return 0;
    }

    private int parent(int j) {
        return 0;
    }

    protected void upheap(int j) {
        while (j > 0) {   // continue until reaching root (or break statement)
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) break;  // heap property verified
            swap(j, p);
            j = p;  // continue from the parent's location
        }
    }
 /*
Code Below:
if the current index j is not the root and if the entry at index j is 
less than its parent. If both conditions are true, we swap the entry at 
index j with its parent and then recursively call upheap on the parent 
index p. This process continues until we either reach the root of the heap 
or the parent is less than the child, which means the heap property is 
restored.
*/
    protected void upheapRecursive(int j) {
        int p = parent(j);
        if (j > 0 && compare(heap.get(j), heap.get(p)) < 0) {
            swap(j, p);
            upheapRecursive(p);
        }
    }
}
/*
Solution Above ^^
Homework C-9.29
Question: Give an alternative implementation of the HeapPriorityQueue’s upheap method
that uses recursion (and no loop).
*/

/*
Homework C-9.31
Question: Assume that we are using a linked representation of a complete binary tree T, and
an extra reference to the last node of that tree. Show how to update the reference
to the last node after operations insert or remove in O(logn) time, where n is the
current number of nodes of T. Be sure to handle all possible cases, as illustrated
in Figure 9.12.
Solution:

Insertion:
When you insert a node in a complete binary tree, you add it at 
the leftmost free spot on the deepest level. This new node is now 
the 'last' node. Simply update your 'last' reference to point to 
this node.

Removal:
If you remove a node (typically the root in a heap), 
you replace it with the 'last' node. Then update your 'last' 
reference to point to the new 'last' node, which is now the 
rightmost node on the deepest level.
Both operations have a time complexity of O(logn) due to the 
'up-heap' or 'down-heap' process, where you may have to traverse 
up or down the tree to maintain the tree's properties.
*/

/*
Homework C-9.34
Question: Given a heap H and a key k, give an algorithm to compute all the entries in H
having a key less than or equal to k. For example, given the heap of Figure 9.12a
and query k = 7, the algorithm should report the entries with keys 2, 4, 5, 6, and 7
(but not necessarily in this order). Your algorithm should run in time proportional
to the number of entries returned, and should not modify the heap.
Solution:

import java.util.*;

public class Main {
    private static class Node {
        int key;
        Node left, right;
        
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public static List<Integer> keysLessThanOrEqualToK(Node node, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(node != null) {
            queue.add(node);
        }
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            if (currentNode.key <= k) {
                result.add(currentNode.key);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println(keysLessThanOrEqualToK(root, 7));
    }
}
*/

/*
Homework C-9.37
Question: Suppose two binary trees, T1 and T2, hold entries satisfying the heap-order property (but not necessarily the complete binary tree property). Describe a method
for combining T1 and T2 into a binary tree T, whose nodes hold the union of
the entries in T1 and T2 and also satisfy the heap-order property. Your algorithm
should run in time O(h1 + h2) where h1 and h2 are the respective heights of T1
and T2
Solution:

In-Order Traversal: Perform this on both trees T1 and T2 to 
create two sorted lists.

Merge: Merge the two sorted lists into one sorted list.

Tree Creation: Use the sorted list to create a new binary tree.
This whole process will take O(h1 + h2) time. The new binary tree will satisfy the heap-order property, but it won't necessarily be a complete binary tree.
*/