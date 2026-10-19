/*
problem: https://www.geeksforgeeks.org/dsa/minimum-number-swaps-required-sort-array/
author: parag kumar goyal
TC: O(NlogN)
SC: O(N)
 */

import java.util.Arrays;
import java.util.HashMap;

public class MinSwapsToSort {
    private static int minSwapsNeeded(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;

        boolean[] visited = new boolean[n];

        HashMap<Integer, Integer> originalPos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            originalPos.put(arr[i], i);
        }

        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < n; ++i) {

            // the original position of arr[i] is actually sorted
            // or the arr[i] already part of a cycle
            if (visited[i] || originalPos.get(arr[i]) == i) {
                continue;
            }

            int j = i, swaps = 0;

            while (!visited[j]) {
                visited[j] = true;

                j = originalPos.get(arr[j]);
                swaps++;
            }

            if (swaps > 0)  {ans += swaps - 1;}
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 6, 2, 3};
        System.out.printf("Minimum swaps needed to sort: %d\n", minSwapsNeeded(arr));

        int[] arr2 = {2, 4, 5, 1, 3};
        System.out.printf("Minimum swaps needed to sort: %d\n", minSwapsNeeded(arr2));
    }
}
