/*
problem: Given an array of integers, return the length of the longest subsequence such
that when the subsequence is sorted in non-decreasing order, the sum of the differences
between adjacent elements is even
TC: O(N)
SC: O(N)
author: parag kumar goyal
 */

public class LongestSubsequenceEvenDifference {
    private static int lengthOfLongestSubsequenceWithEvenSumDifference(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minEvenValue = Integer.MAX_VALUE, minOddValue = Integer.MAX_VALUE;
        int maxEvenValue = Integer.MIN_VALUE, maxOddValue = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num % 2 == 0) {
                minEvenValue = Math.min(minEvenValue, num);
                maxEvenValue = Math.max(maxEvenValue, num);
            } else {
                minOddValue = Math.min(minOddValue, num);
                maxOddValue = Math.max(maxOddValue, num);
            }
        }

        int evenRange = 0, oddRange = 0;
        for (int num : nums) {
            if (minEvenValue != Integer.MAX_VALUE && num >= minEvenValue && num <= maxEvenValue) {
                evenRange += 1;
            } else if (minOddValue != Integer.MAX_VALUE && num >= minOddValue && num <= maxOddValue) {
                oddRange += 1;
            }
        }

        return Math.max(evenRange, oddRange);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 1, 7, 3, 94, 3, 9, 34, 784, 34};
        System.out.println("The length of longest subsequence such that the sum of " +
                "difference between the numbers when sorted in non-decreasing is even: " +
                lengthOfLongestSubsequenceWithEvenSumDifference(nums));

    }

}
