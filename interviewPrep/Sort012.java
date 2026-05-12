/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/sort-an-array-of-0s-1s-and-2s4231
TC: O(N)
SC: O(1)
Dutch National Flag
Counting Sort
*/

public class Solution {
    public void sort012(int[] arr) {
        int n = arr.length;
        int c0 = 0, c1 = 0, c2 = 0;

        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            } else {
                c2++;
            }
        }

        int idx = 0;
        for (int count = 0; count < c0; ++count) {
            arr[idx++] = 0; 
        }

        for (int count = 0; count < c1; ++count) {
            arr[idx++] = 1;
        }

        for (int count = 0; count < c2; ++count) {
            arr[idx++] = 2;
        }
    }

    private void swapNum(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void sort012DNF(int[] arr) {
        int mid = 0, low = 0, high = arr.length - 1;

        while (mid <= end) {
            if (arr[mid] == 0) {
                swapNum(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swapNum(arr, mid, end);
                end--;
            }
        }
    }
}



