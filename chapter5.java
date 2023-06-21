//package homework;

public class chapter5 {
  // Homework: R-5.10 recursive algorithm to sum 2d array of integers
  public static int recursiveSum2D(int[][] a, int row, int col) {
      int sum = 0;
      if(row==0) return 0;
      for(int i=0;i<col;i++)
      {
          sum+= a[row-1][i];
      }
      return sum + recursiveSum2D(a, row-1, col);
  }

  /*
   Homwork: C-5.16 
   * Describe a recursive algorithm for solving the Towers of Hanoi
puzzle for arbitrary n.
Solution: 
If there is only one disk (n=1), move it directly from the source peg to the destination peg.
Otherwise, follow these steps recursively:
Move n-1 disks from the source peg to the auxiliary peg using the destination peg 
as a temporary peg.
Move the largest disk (nth disk) from the source peg to the destination peg.
Move the n-1 disks from the auxiliary peg to the destination peg using the source peg 
as a temporary peg.
*/
     public static void solveTowersOfHanoi(int n, char from, char to, char free) {
      if (n == 1) {
          System.out.println("Move disk 1 from disk " + from + " to disk " + to);
          return;
      }
      solveTowersOfHanoi(n-1, from, free, to);
      System.out.println("Move disk " + n + " from disk " + from + " to disk " + to);
      solveTowersOfHanoi(n-1, free, to, from);
  }

/*
    Homework: P-5.28
    Write a program for solving summation puzzles by enumerating and testing all
possible configurations. Using your program, solve the three puzzles given in
Section 5.3.3.

*/

    public static void main(String[] args) {
      int[][] arr = {{1,2,3},{4,5,6}}; // 21
      System.out.println(recursiveSum2D(arr, 2, 3));
      solveTowersOfHanoi(3, 'A', 'C', 'B');

  }
}


/*
     Homework: P-5.29
     * Provide a nonrecursive implementation of the drawInterval method for the English ruler project of Section 5.1.2. There should be precisely 2c − 1 lines of
output if c represents the length of the center tick. If incrementing a counter from
0 to 2c − 2, the number of dashes for each tick line should be exactly one more
than the number of consecutive 1’s at the end of the binary representation of the
counter.
using a stack...
private static void drawInterval(int centralLength) {
  Stack<Integer> stack = new Stack<>();
  stack.push(centralLength);
  while (stack.isEmpty() == false) {
      int currentLength = stack.pop();
      if (currentLength >= 1) {
          stack.push(currentLength - 1);
          stack.push(currentLength - 1);
          drawLine(currentLength);
      }
  }
}
*/
