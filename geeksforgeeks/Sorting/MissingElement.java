/*
problem: https://www.geeksforgeeks.org/problems/missing-element-in-range/1
author: parag kumar goyal
TC: O(NlogN + (range))
SC: O(1)
*/

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> missingValues = new ArrayList<>();
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        int current = low;
        
        for (int itr = 0; itr < n; ++itr) {
            if (arr[itr] < current) continue;
            
            while (current <= high && current < arr[itr]) {
                missingValues.add(current);
                current += 1;
            }
            
            if (current == arr[itr]) current += 1;
            
            if (current > high) break;
        }
        
        while (current <= high) {
            missingValues.add(current);
            current += 1;
        }
        
        return missingValues;
    }
}