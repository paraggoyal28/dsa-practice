/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/prefix-sum-gfg-160/problem/product-array-puzzle4525
author: parag kumar goyal
TC: O(n), SC: O(1)
*/

// if more than one zeros then the ans will be all zeros
static int[] productExceptSelf(int[] arr) {
    int zeros = 0, idx = -1, prod = 1;
    int n = arr.length;

    // Count zeros and track the index of the zero
    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            zeros++;
            idx = i;
        } else {
            prod *= arr[i];
        }
    }

    int[] res = new int[n];
    Arrays.fill(res, 0);

    // If no zeros, calculate the product for all elements
    if (zeros == 0) {
        for (int i = 0; i < n; i++) 
            res[i] = prod / arr[i];
    }
    // If one zero, set product only at the zero's index
    else if (zeros == 1)
        res[idx] = prod;

    return res;
}