public class chapter7<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size = 0;

    public chapter7() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[i];
    }

    public E set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldElement = data[i];
        data[i] = e;
        return oldElement;
    }

    public void add(E e) {
        if (size == data.length) { // resize array if necessary
            resize(data.length * 2);
        }
        data[size] = e;
        size++;
    }

    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        E removedElement = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j+1];
        }
        data[size - 1] = null;
        size--;

        // resize if necessary
        if (size > DEFAULT_CAPACITY && size < data.length / 4) {
            resize(data.length / 2);
        }

        return removedElement;
    }

    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

/*
^^ Solution Above ^^
Homework C-7.29: 
Revise the array list implementation given in Section 7.2.1
so that when the actual elements, n, in the array goes below N/4,
where N is the array capacity, the array shrinks to half its size.
 */


/*
Homework C-7.31: 
Give a formal proof that any sequence of n push or pop operations
(that is, insertions or deletions at the end) on an initially empty
dynamic array takes O(n) time, if using the strategy described in Excerise C-7.29

Solution: 
For push operations, although sometimes we need to resize the 
array (which takes O(n) time), this happens only after a certain 
number of operations, specifically after every doubling of the 
array's size. So, the cost of resizing is spread out over these 
operations, making the average time (or "amortized" time) O(1)
per operation.

For pop operations, the same logic applies. Resizing occurs less 
frequently as the number of elements decreases. The array only 
shrinks when it's one quarter full. So again, the cost of resizing
is spread over several operations, resulting in an amortized time
of O(1) per operation.

So, in both cases (push or pop), even with the occasional resizing,
many sequence of n operations will take O(n) time overall. 
This is what we mean when we say the operations are O(1) on 
average, or "amortized O(1)".
 */

/*
Homework C-7.32:
Consider a variant of Excerise C-7.29, in which an array of capacity
N is resized to capacity precisely that of elements, any time the 
number of elements in the array goes strictly below N/4. Give a formal 
proof that any sequence of n push or pop operations on an initially
empty dynamic array takes 0(n) time.

Solution: 
Push Operations: Normally, adding an element is quick, O(1). 
But when the array is full and we need to double its size, it 
takes longer, O(n), because all elements must be copied over. 
This "extra cost" is spread out over many future additions, so on 
average, each push operation still only takes O(1) time.

Pop Operations: Removing an element also usually takes O(1) time. 
But when the array is less than a quarter full, we shrink its 
size to match the number of elements, taking O(n) time. Similar 
to push, this cost is spread out over future removals, so on 
average, each pop operation is also O(1).

Thus, over n operations (a combination of push or pop), the total 
time taken is n * O(1), which simplifies to O(n). So, regardless 
of how the array resizes, any sequence of n operations takes O(n) 
time overall.

 */

 