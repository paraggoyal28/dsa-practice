/*
problem: https://www.geeksforgeeks.org/problems/max-absolute-difference4114/1
author: parag kumar goyal
TC: O(n), SC: O(n)
*/

class Solution {

    private int[] buildLeftMax(int[] arr) {
        int n = arr.length;

        int curr = arr[0];
        int best = arr[0];
        
        int[] leftMax = new int[n];

        leftMax[0] = best;
        
        for (int i = 1; i < n; ++i) {
            
            curr = Math.max(curr + arr[i], arr[i]);

            best = Math.max(curr, best);

            leftMax[i] = best;
        }

        return leftMax;
    }

    private int[] buildRightMax(int[] arr) {

        int n = arr.length;

        int curr = arr[n-1];
        int best = arr[n-1];

        int[] rightMax = new int[n];

        rightMax[n-1] = best;

        for (int i = n-2; i >= 0; --i) {

            curr = Math.max(curr + arr[i], arr[i]);

            best = Math.max(best, curr);

            rightMax[i] = best;
        }

        return rightMax;
    }

    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;

        int[] leftMax = buildLeftMax(arr);
        int[] rightMax = buildRightMax(arr);

        int[] inverted = arr.clone();

        for (int i = 0; i < n; ++i) {
            inverted[i] *= (-1);
        }

        int[] leftMin = buildLeftMax(inverted);
        int[] rightMin = buildRightMax(inverted);

        // Convert values back to minimum subarray sum
        for (int i = 0; i < n; ++i) {
            leftMin[i] *= (-1);
            rightMin[i] *= (-1);
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n-1; ++i) {

            // either find maximum subarray on left and minimum subarray on right
            int option1 = Math.abs(leftMax[i] - rightMin[i+1]);


            // or minimum subarray on left and maximum subarray on right
            int option2 = Math.abs(leftMin[i] - rightMax[i+1]);

            res = Math.max(res, Math.max(option1, option2));
        }

        return res;
    }
}