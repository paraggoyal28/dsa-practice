/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/maximum-product-subarray3604
author: parag kumar goyal
TC: O(n)
SC: O(1)
*/

class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;
        int maximumProduct = arr[0];
        int minimumProduct = arr[0];
        int globalMaxProduct = arr[0];
        
        for (int i = 1; i < n; ++i) {
            int num = arr[i];
            int temp = Math.max(num, 
                Math.max(maximumProduct * num, 
                minimumProduct * num));
            minimumProduct = Math.min(num,
               Math.min(minimumProduct * num, 
                    maximumProduct * num));
            maximumProduct = temp;
            globalMaxProduct = Math.max(globalMaxProduct,
                maximumProduct);
        }
        
        return globalMaxProduct;
    }
}