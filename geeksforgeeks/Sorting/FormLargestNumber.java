/*
problem: https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
author: parag kumar goyal
TC: O(NlogN * K) where N is the number of integers and K is the average number of digits
SC: O(N*K) 
*/

class Solution {
    public String findLargest(int[] arr) {
        int n = arr.length;
        String[] strNums = new String[n];
        
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(arr[i]);
        }

        // Sort using the greedy comparison
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", the whole result is "0"
        // to handle test case such as -> 0 0 0 0 0 
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    }
}