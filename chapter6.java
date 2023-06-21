//package homework;

import java.util.*;
class Permutation {

    static class StackFrame {
        int[] currentPermutation;
        int nextNumber;

        public StackFrame(int[] currentPermutation, int nextNumber) {
            this.currentPermutation = currentPermutation;
            this.nextNumber = nextNumber;
        }
    }

    static List<int[]> generatePermutations(int n) {
        List<int[]> result = new ArrayList<>();
        Deque<StackFrame> stack = new ArrayDeque<>();

        stack.push(new StackFrame(new int[0], 1));

        while (!stack.isEmpty()) {
            StackFrame frame = stack.pop();

            if (frame.nextNumber > n) {
                // We've generated a valid permutation, so add it to the result list
                result.add(frame.currentPermutation);
            } else {
                for (int i = 0; i <= frame.currentPermutation.length; i++) {
                    int[] newPermutation = new int[frame.currentPermutation.length + 1];

                    System.arraycopy(frame.currentPermutation, 0, newPermutation, 0, i);
                    newPermutation[i] = frame.nextNumber;
                    System.arraycopy(frame.currentPermutation, i, newPermutation, i+1, frame.currentPermutation.length - i);

                    stack.push(new StackFrame(newPermutation, frame.nextNumber + 1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<int[]> permutations = generatePermutations(3);

        for (int[] permutation : permutations) {
            System.out.println(Arrays.toString(permutation));
        }
    }
}
/*
^^ CODE ABOVE ^^:
Homework: C-6.21 Describe a nonrecursive algorithm for enumerating all permutations 
of the numbers {1,2,...,n} using an explicit stack.
Solution :
Initialize a stack and an array with numbers from 1 to n.
While the stack is not empty, pop a permutation from the stack.
If the permutation is complete, add it to the output list.
    For each unused number, create a new permutation 
by appending it to the current permutation and push it onto the stack.
Once the stack is empty, the output list contains all permutations.
This nonrecursive algorithm systematically generates permutations 
by using a stack to simulate recursion and explicitly keeps track of the current state.
 */

 

 

/*

 import java.util.Stack;

 public class chapter6<E> {
     private Stack<E> front;
     private Stack<E> back;
 
     public chapter6() {
         front = new Stack<>();
         back = new Stack<>();
     }
 
     public void enqueueFront(E item) {
         front.push(item);
     }
 
     public void enqueueBack(E item) {
         back.push(item);
     }
 
     public E dequeueFront() {
         if (front.isEmpty()) {
             while (!back.isEmpty()) {
                 front.push(back.pop());
             }
         }
         return front.isEmpty() ? null : front.pop();
     }
 
     public E dequeueBack() {
         if (back.isEmpty()) {
             while (!front.isEmpty()) {
                 back.push(front.pop());
             }
         }
         return back.isEmpty() ? null : back.pop();
     }
 
     public boolean isEmpty() {
         return front.isEmpty() && back.isEmpty();
     }
 
     public int size() {
         return front.size() + back.size();
     }
 }

^^ Code above ^^:
Homework: C-6.31 Describe how to implement the deque ADT using two stacks as the only instance
variables. What are the running times of the methods?
Solution: 
Use one stack for the front of the deque and another stack for the back.
enqueueFront adds an element to the front stack.
enqueueBack adds an element to the back stack.
dequeueFront removes and returns an element from the front stack.
 If empty, move elements from the back stack to the front stack.
dequeueBack removes and returns an element from the back stack.
 If empty, move elements from the front stack to the back stack.
isEmpty checks if both stacks are empty.
size returns the sum of the sizes of the front and back stacks.
    The running times are as follows:
enqueueFront and enqueueBack: O(1) (constant time).
dequeueFront and dequeueBack: Amortized O(1) (constant time).
isEmpty and size: O(1) (constant time).
*/



/*

import java.util.Stack;

public class chapter6 {
    public static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();

        String[] parts = postfix.split(" ");
        for (String part : parts) {
            switch (part) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int right = stack.pop(); // Important to remember the order for subtraction
                    int left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int denominator = stack.pop(); // Order is important for division too
                    int numerator = stack.pop();
                    stack.push(numerator / denominator);
                    break;
                default:
                    stack.push(Integer.parseInt(part));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "5 2 + 8 3 - * 4 /";
        System.out.println("The result of the postfix expression is: " + evaluate(postfix));
    }
}
^^ CODE ABOVE ^^:
Homework: P-6.35 Implement a program that can input an expression in postfix notation 
(see Exercise C-6.19) and output its value.
C-6.19 : 
Postfix notation is an unambiguous way of writing an arithmetic expression without parentheses. 
It is defined so that if “(exp1)op(exp2)” is a normal fully parenthesized expression 
whose operation is op, the postfix version of this is “pexp1 pexp2 op”, 
where pexp1 is the postfix version of exp1 and pexp2 is the postfix version 
of exp2. The postfix version of a single number or variable is just that number
or variable. So, for example, the postfix version of “((5 + 2) ∗ (8 − 3))/4” is “5
2 + 8 3 − ∗ 4 /”. Describe a nonrecursive way of evaluating an expression in
postfix notation
*/