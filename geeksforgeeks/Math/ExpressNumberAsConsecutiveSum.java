/*
Problem: https://www.geeksforgeeks.org/problems/count-of-sum-of-consecutives3741/1
Given a number n, find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.
author: parag kumar goyal

Let the first number of valid sequence having k elements sum equal to n is a.

The sequence a, (a+1), (a+2), ..., (a+k-1).

a + (a+1) + (a+2) + .... + (a+k-1) = n
k * a + ( 1 + 2 + .... + k-1 ) = n
a = (n - baseSum ) / k ; where baseSum = k * (k - 1) /2
For each k starting from 2 we keep checking till when our baseSum is less than n, if we get (n - baseSum) divisible by k we increase count by 1.

*/

public class Main {

    static int getCount(int n)
    {
        int count = 0;

        // k represents the number of elements in our consecutive sequence.
        // we need at least 2 numbers, so we start checking from k = 2.
        for (long k = 2; ; k++)
        {
            // baseSum is the sum of the first (k-1) numbers: 1 + 2 + ... + (k-1)
            long baseSum = (k * (k - 1)) / 2;

            // if the minimum possible sum of k elements is greater than or 
            // equal to n, no valid sequence of length k or greater can exist.
            if (baseSum >= n) {
                break; 
            }

            // if (n - baseSum) can be divided equally among the k elements,
            // it means a valid starting integer 'a' exists.
            if ((n - baseSum) % k == 0) {
                count++;
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n1 = 15;
        System.out.println(getCount(n1));
    }
}
