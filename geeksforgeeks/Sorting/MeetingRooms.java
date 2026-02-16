/*
problem: https://www.geeksforgeeks.org/problems/attend-all-meetings/1
author: parag kumar goyal
TC: O(NlogN)
SC: O(1)
*/

import java.util.Arrays;

class Solution {
    public static boolean canAttend(int[][] arr) {
        // 1. Handle edge cases: if there are 0 or 1 meetings, no conflict is possible.
        if (arr == null || arr.length <= 1) {
            return true;
        }

        // 2. Sort the meetings based on their start times.
        // Using Integer.compare to avoid potential subtraction overflow.
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Iterate through the sorted meetings and check for overlaps.
        for (int i = 0; i < arr.length - 1; i++) {
            // If the next meeting starts before the current one ends, return false.
            // Note: If start == end, it is NOT considered an overlap per problem rules.
            if (arr[i + 1][0] < arr[i][1]) {
                return false;
            }
        }

        // 4. If no overlaps are found, the person can attend all meetings.
        return true;
    }
}