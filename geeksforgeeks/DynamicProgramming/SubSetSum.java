/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/dynamic-programming-gfg-160/problem/subset-sum-problem-1611555638
author: parag kumar goyal
TC: O(n * sum)
SC: O(sum)
 */



public class SubSetSum {
    private static boolean isSubsetSum(int arr[], int sum) {
        if (arr == null || arr.length == 0) return false;

        boolean[] dp = new boolean[sum + 1];

        // 0 sum always possible
        dp[0] = true;

        for (int num : arr) {
            for (int s = sum; s >= num; --s) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 12, 34, 23};
        int target = 27;
        System.out.println("Is possible to form 22? " + isSubsetSum(arr, target));
    }
}
