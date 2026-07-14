/*
problem: https://www.geeksforgeeks.org/problems/find-smallest-non-zero-number4510/1
Given an array arr[], find the smallest number x such that when x is processed sequentially with each element of the array (from index 0 to n-1), it never becomes negative, under the following conditions:

If x is greater than the current array element, x is increased by the difference between x and the array element.
If x is less than or equal to the current array element, x is decreased by the difference between the array element and x.

Solution Approach: 
Work backwards from last element to first. At each step, compute minimum required value before processing current element using formula: need = (need + arr[i] + 1) / 2.

Initialize need = 0
Traverse array from right to left and update need = (need + arr[i] + 1) / 2
Return need
How does this formula work?
There are two cases that arise for every arr[i] and we get the same result in both cases as described below.

x > arr[i]: In this case, x becomes x = x + (x - arr[i]) = 2x - arr[i]
x <= arr[i]: In this case, x becomes x = x - (arr[i] - x) = 2x - arr[i]
Why do we traverse in reverse direction? The backward approach works because at each position it computes the smallest value required before (not after) processing the current element to guarantee that all subsequent values remain non-negative.

Suppose after processing arr[i], we need at least need. Before processing arr[i], let the required value be before.

after = 2 * before - arr[i] [Explained above]
2 * before - arr[i] >= need
before >= (need + arr[i]) / 2
Since before must be an integer before = ((need + arr[i] + 1) / 2)

author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    
    
    
    public int find(int[] arr) {
        // code here
        int need = 0;
        
        for (int i = arr.length - 1; i >= 0; --i) {
            need = (need + arr[i] + 1)/2;
        }
        
        return need;
    }
}
