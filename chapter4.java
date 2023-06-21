//package homework; 


/*
Homework: R 4.9
public static int example1(int[] arr){
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j++){
        total += arr[j];
        return total;
    }
}
    Line 7: Assigning the length of the array to the variable n takes constant time, O(1).
    Line 8: Initializing the variable total to 0 takes constant time, O(1).
    Line 9: The for loop iterates from 0 to n-1,
performing a constant-time operation (adding arr[j] to total) in each iteration. 
Since the loop iterates n times, the time complexity of the loop is O(n).
    Line 10: Returning the total value takes constant time, O(1).
Overall, the time complexity of this code is dominated by the for loop, 
which has a time complexity of O(n).
Therefore, the big-Oh characterization of the running time of this example1 function is O(n),
where n represents the length of the input array.
 */


 /*
Homework: R 4.10
public static int example2(int[] arr){
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j += 2){
        total += arr[j];
        return total;
    }
}
    Line 29: Assigning the length of the array to the variable n takes constant time, O(1).
    Line 30: The for loop iterates from 0 to n-1, incrementing j by 2 in each iteration. 
Since the loop iterates n/2 times (skipping odd indices), the time complexity of the loop is O(n/2).
    Line 31: Adding arr[j] to the total takes constant time, O(1).
    Line 32: Returning the total value takes constant time, O(1).
The time complexity of example2 is O(n), where n is the length of the input array. 
The code iterates through the array, but only considers every other element.
However, in big-O notation, we simplify the complexity to O(n) by dropping any constants and lower-order terms.
 */


 /*
Homework: R 4.11
public static int example2(int[] arr){
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j++){
        for (int k = 0; k <= j; k++){
            total += arr[j];
            return total;
        }
    }
}
    Line 49: Assigning the length of the array to the variable n takes constant time, O(1).
    Line 50: The outer loop iterates from 0 to n-1, performing a constant-time operation (the inner loop) in each iteration. Since the outer loop iterates n times, the time complexity of the outer loop is O(n).
    Line 51: The inner loop iterates from 0 to j, performing a constant-time operation (adding arr[j] to total) in each iteration. The number of iterations for the inner loop increases with each iteration of the outer loop. When the outer loop is at its maximum value (n-1), the inner loop will iterate n times. The worst-case time complexity of the inner loop can be approximated as O(n) when considering the maximum number of iterations.
    Line 52: Adding arr[j] to the total takes constant time, O(1).
    Line 53: Returning the total value takes constant time, O(1). 
The time complexity of the code is O(n^2) due to the nested loops. 
This means that the running time grows quadratically with the input size, 
where n represents the length of the input array.
 */