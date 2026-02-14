/*
problem: https://www.geeksforgeeks.org/problems/max-min-height--170647/1
author: parag kumar goyal
TC: O(nlog(m)) where n is the number of flowers and m is the search space from minHeight to minHeight + k
SC: O(n) where n is number of flowers to measure the watering effect

The idea is to use binary search on the minimum achievable height instead of checking 
every height. The search range goes from the initial minimum height to the minimum height 
plus all available watering days (k), assuming we use all efforts on the smallest flowers. 
For each midpoint, we simulate the watering process to see if it's possible to raise 
every flower to at least that height using k days and a watering window of size w. 
Since the number of required days increases with the target height, the problem has a 
monotonic property, making binary search an efficient choice.
*/

static boolean isPossible(int[] arr, int k, int w, int maxHeight) {

    int n = arr.length;
    int[] water = new int[n];

    for (int i = 0;i < n; ++i) {
        
        // Add previous watering effect
        if (i > 0) {
            water[i] = water[i-1];
        }

        int currHeight = arr[i] + water[i];

        // Remove watering effect beyond window w
        if (i >= w) {
            currHeight -= water[i-w];
        }

        // if current height less than required
        if (currHeight < maxHeight) {
            int add = maxHeight - currHeight;
            water[i] += add;
            k -= add;

            // if days become negative, not possible
            if (k < 0) {
                return false;
            }
        }
    }

    return true;
}

static int maxMinHeight(int[] arr, int k, int w) {

    int n = arr.length;

    int low = arr[0];
    for (int i = 1; i < n; ++i) {
        low = Math.min(low, arr[i]);
    }

    int high = low + k;
    int ans = low;

    // Binary search on answer
    while (low <= high) {
        int mid = low + (high - low)/2;

        if (isPossible(arr, k, w, mid)) {
            ans = Math.max(ans, mid);
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}
