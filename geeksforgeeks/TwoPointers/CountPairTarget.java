
/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/pair-with-given-sum-in-a-sorted-array4940
author: parag kumar goyal
TC: O(n), SC: O(1)

*/

class Solution {
    static int countPairs(int[] arr, int target)
    {
        int n = arr.length;
        int count = 0;

        // Initialize two pointers
        int left = 0, right = n - 1;

        while (left < right) {

            // If the current sum is smaller than the
            // target, move the left pointer to increase the
            // sum
            if (arr[left] + arr[right] < target) {
                left++;
            }

            // If the current sum is greater than the
            // target, move the right pointer to decrease
            // the sum
            else if (arr[left] + arr[right] > target) {
                right--;
            }

            // If the current sum is equal to the target
            else {

                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left];
                int ele2 = arr[right];

                // Count the occurrences of the left element
                while (left <= right && arr[left] == ele1) {
                    left++;
                    cnt1++;
                }

                // Count the occurrences of the right
                // element
                while (left <= right
                       && arr[right] == ele2) {
                    right--;
                    cnt2++;
                }

                // If both elements are the same, count the
                // number of ways to choose any two of them
                if (ele1 == ele2) {
                    count += (cnt1 * (cnt1 - 1)) / 2;
                }

                // Otherwise, every occurrence of the left
                // element can pair with every occurrence of
                // the right element
                else {
                    count += cnt1 * cnt2;
                }
            }
        }

        return count;
    }
}