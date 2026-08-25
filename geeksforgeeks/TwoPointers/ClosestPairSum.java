/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/pair-in-array-whose-sum-is-closest-to-x1124
author: parag kumar goyal
TC: O(nlogn) where n is the size of the array
*/

class Solution {
    public ArrayList<Integer> closestPair(int[] arr, int target) {
       
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];

            // Check if this pair is closer than the closest
            // pair so far
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res.clear();
                res.add(arr[left]);
                res.add(arr[right]);
            }

            // If this pair has less sum, move to greater
            // values
            if (currSum < target)
                left++;

            // If this pair has more sum, move to smaller
            // values
            else if (currSum > target)
                right--;

            // If this pair has sum = target, return it
            else
                return res;
        }

        return res;
    
    }
}