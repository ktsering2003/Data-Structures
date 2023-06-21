public class chapter8<E> {
    private static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        // Node class other methods...
    }

    private Node<E> root = null;
    private int size = 0;

    // LinkedBinaryTree other methods...

    public void pruneSubtree(Node<E> p) {
        if (p == null) return;

        int subTreeSize = size(p); // calculate subtree size before removing
        if (p.parent != null) {
            if (p.parent.left == p) {
                p.parent.left = null;
            } else if (p.parent.right == p) {
                p.parent.right = null;
            }
        } else {
            root = null; // if p is root node
        }
        p = null; // remove p node
        size -= subTreeSize; // update size
    }

    private int size(Node<E> p) {
        if (p == null) return 0;
        else return 1 + size(p.left) + size(p.right);
    }
}

/*
Solution Above ^^
Homework: C-8.36
Question: Add support in LinkedBinaryTree for a method, 
pruneSubtree(p), that removes the entire subtree rooted at 
position p, making sure to maintain an accurate count
of the size of the tree. What is the running time of your 
implementation?
*/


/*
Homework: C-8.37
Question: Add support in LinkedBinaryTree for a method, swap(p, q), that has the effect of
restructuring the tree so that the node referenced by p takes the place of the node
referenced by q, and vice versa. Make sure to properly handle the case when the
nodes are adjacent.
Solution: 

public class LinkedBinaryTree<E> {
    private static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private Node<E> root = null;
    private int size = 0;

    public void pruneSubtree(Node<E> p) {
        if (p == null) return;

        int subTreeSize = size(p); // calculate subtree size before removing
        if (p.parent != null) {
            if (p.parent.left == p) {
                p.parent.left = null;
            } else if (p.parent.right == p) {
                p.parent.right = null;
            }
        } else {
            root = null; // if p is root node
        }
        p = null; // remove p node
        size -= subTreeSize; // update size
    }

    public void swap(Node<E> p, Node<E> q) {
        if (p == null || q == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }

        // Swap parent references
        Node<E> p_parent = p.parent;
        Node<E> q_parent = q.parent;

        if (p_parent != null) {
            if (p_parent.left == p) {
                p_parent.left = q;
            } else {
                p_parent.right = q;
            }
        } else {
            root = q;
        }

        if (q_parent != null) {
            if (q_parent.left == q) {
                q_parent.left = p;
            } else {
                q_parent.right = p;
            }
        } else {
            root = p;
        }

        p.parent = q_parent;
        q.parent = p_parent;

        // Swap children references
        Node<E> p_left = p.left;
        Node<E> p_right = p.right;
        Node<E> q_left = q.left;
        Node<E> q_right = q.right;

        if (p != q_parent) {
            q.left = p_left;
            q.right = p_right;
        }

        if (q != p_parent) {
            p.left = q_left;
            p.right = q_right;
        }

        if (p_left != null && p_left != q) p_left.parent = q;
        if (p_right != null && p_right != q) p_right.parent = q;
        if (q_left != null && q_left != p) q_left.parent = p;
        if (q_right != null && q_right != p) q_right.parent = p;
    }

    private int size(Node<E> p) {
        if (p == null) return 0;
        else return 1 + size(p.left) + size(p.right);
    }
}

*/

/*
Homework: C-8.47
Question: To implement the preorder method of the AbstractTree class, we relied on the
convenience of creating a snapshot. Reimplement a preorder method that creates
a lazy iterator. (See Section 7.4.2 for discussion of iterators.)
Solution:
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Tree<E> implements Iterable<E> {
    private Node<E> root;

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    public Iterator<E> iterator() {
        return new PreOrderIterator();
    }

    private class PreOrderIterator implements Iterator<E> {
        private Stack<Node<E>> stack = new Stack<>();

        public PreOrderIterator() {
            if (root != null) {
                stack.push(root);
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited!");
            }

            Node<E> res = stack.pop();
            if (res.right != null) {
                stack.push(res.right);
            }
            if (res.left != null) {
                stack.push(res.left);
            }
            return res.element;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
*/

/*
Homework: C-8.55
Question: Let T be a tree with n positions. Define the lowest common ancestor (LCA)
between two positions p and q as the lowest position in T that has both p and q
as descendants (where we allow a position to be a descendant of itself). Given
two positions p and q, describe an efficient algorithm for finding the LCA of p
and q. What is the running time of your algorithm?
Solution: 
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Solution {
    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = this.dfs(root.left, p, q) ? 1 : 0;
        int right = this.dfs(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = root;
        }

        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

*/