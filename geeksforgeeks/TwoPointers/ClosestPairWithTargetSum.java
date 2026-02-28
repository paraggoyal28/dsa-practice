/*
problem; https://www.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1
author; parag kumar goyal
TC; O(N + M), where N is the size of arr1 and M is size of arr2
SC; O(1) 
*/

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int n = arr1.length;
        int m = arr2.length;
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = m-1;
        
        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            
            int diff = Math.abs(sum - x);
            
            if (diff < minDiff) {
                minDiff = diff;
                res = new ArrayList<>(List.of(arr1[i], arr2[j]));
            }
            
            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        
        return res;
    }
}