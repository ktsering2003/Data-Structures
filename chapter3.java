//package homework;

/*
Homework: R 3.5
If we remove lines 51 and 52:
The last() method will give the wrong result when the list is empty.
The addLast(E e) method will not work correctly when adding to an empty list.

In the main method, the second and third calls to
System.out.println("Last item: " + list.last()); 
show the issues caused by not resetting the tail to null when the list is empty.
We commented out the part of the code that sets tail to null when the list is empty.
This creates two problems:
    If we ask for the last item when the list is empty (last() method), 
we get the old last item, not null.
    If we try to add a new last item to an empty list (addLast(E e) method), 
the program tries to add it after the old last item, which isn't in the list anymore, 
causing an error.
Summary, without those lines of code, the list gets confused when it's empty,
remembering an item that isn't there anymore, 
and causing errors when you try to add a new item.

*/
public class chapter3<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        // Below is the line we added back to correctly handle tail
        // if (size == 0)
        // tail = null; // We reset tail to null when list is empty
        return answer;
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        chapter3<Integer> list = new chapter3<>();
        list.addLast(10);
        System.out.println("Last item: " + list.last()); // Should print: Last item: 10
        list.removeFirst();
        System.out.println("Last item: " + list.last()); // Should print: Last item: null
        list.addLast(20);
        System.out.println("Last item: " + list.last()); // Should print: Last item: 20
    }
}

/*
Homework: R 3.8
Imagine you have two people at the start of a linked list: one is a slow walker 
(we'll call them slow), and the other is a fast runner (fast).
Both start moving together, but the slow person takes one step at a time, 
while the fast one takes two steps at a time.
They continue like this until the fast runner reaches the end of the list.
At that point, the slow walker will be halfway through the list- 
they'll be at the middle node!
If the list has an even number of nodes, 
the middle is the one slightly to the left of the center because the slow walker is 
slower and will always be a bit behind the exact center.
As for time, this method is pretty quick. 
It's like running a race only once, so we say it has a time complexity of O(n), 
where n is the number of nodes in the list.
And since we're only using two people (or pointers), the space it takes up is constant. 
No matter how long the list is, we only need our two people. 
So, the space complexity is O(1). //algorithm uses a fixed amount of memory. 
This is called "constant space complexity." Since algorithmn doesn't change with the size of the input
 */

/*
Homework: C 3.27
    Singly Linked List:
Find the nodes before x and y.
Make them point to y and x respectively.
Then, swap the nodes x and y are pointing to.
    Doubly Linked List:
Do the same steps as in singly linked list.
Also swap the nodes that point back to x and y.
In both cases, you are just changing what some pointers are pointing to.
    For time taken: swapping in a doubly linked list might take a tiny bit longer 
because you are changing more pointers, 
but it's so little extra time that you wouldn't really notice.
  */