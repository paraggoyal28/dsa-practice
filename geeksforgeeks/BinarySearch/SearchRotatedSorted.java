/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/greedy-gfg-160/problem/circular-tour-1587115620
author: parag kumar goyal
TC: O(log n), where n is the number of elements to search
SC: O(1)
 */

public class SearchRotatedSorted {
    public static int getTargetIndex(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] <= arr[end]) {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr2 = {7, 8, 10, 1, 3, 5};

        System.out.printf("Index of 3 in arr: %d\n", getTargetIndex(arr, 3));
        System.out.printf("Index of 7 in arr: %d\n", getTargetIndex(arr, 7));
        System.out.printf("Index of 1 in arr2: %d\n", getTargetIndex(arr2, 1));
        System.out.printf("Index of 10 in arr2: %d\n", getTargetIndex(arr2, 10));
        System.out.printf("Index of 20 in arr2: %d\n", getTargetIndex(arr2, 20));
    }
}
