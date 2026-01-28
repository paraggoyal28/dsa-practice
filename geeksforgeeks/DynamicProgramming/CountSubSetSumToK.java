/*
problem: https://www.geeksforgeeks.org/problems/count-the-subset-with-sum-equal-to-k/1
author: parag kumar goyal
Constraints:
1 ≤ arr.size() ≤ 40
-107 ≤ arr[i], k ≤ 107
*/

/* DP solution 
TC: O(n*R) where n is size of array and R is range of numbers
SC: O(R)
*/
public int countSubset(int[] arr, int k) {
    int minSum = 0;
    int maxSum = 0;
    for (int num : arr) {
        if (num < 0) minSum += num;
        else maxSum += num;
    }

    // If target is out of the possible range, it's impossible
    if (k < minSum || k > maxSum) return 0;

    int offset = Math.abs(minSum);
    int range = maxSum - minSum;
    
    // dp[sum + offset]
    int[] dp = new int[range + 1];
    
    // Base case: 1 way to make sum 0
    dp[0 + offset] = 1;

    for (int num : arr) {
        int[] nextDp = new int[range + 1];
        for (int s = 0; s <= range; s++) {
            if (dp[s] > 0) {
                // Option 1: Exclude num
                nextDp[s] += dp[s];
                
                // Option 2: Include num
                int nextSum = s + num;
                if (nextSum >= 0 && nextSum <= range) {
                    nextDp[nextSum] += dp[s];
                }
            }
        }
        dp = nextDp;
    }

    return dp[k + offset];
}

/*
For large R such as for above problem
Meet-In-Middle algorithm is a better solution
TC: O(2^(n/2))
SC: O(2^(n/2))
*/


class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        
        // 1. Split array into two halves
        List<Integer> leftSums = getSubsetSums(arr, 0, n / 2 - 1);
        List<Integer> rightSums = getSubsetSums(arr, n / 2, n - 1);

        // 2. Use a Map to count frequencies of sums in the right half
        Map<Integer, Integer> rightFreq = new HashMap<>();
        for (int sum : rightSums) {
            rightFreq.put(sum, rightFreq.getOrDefault(sum, 0) + 1);
        }

        int count = 0;

        // 3. For each sum in left, see how many ways we can reach 'k' using right
        for (int s1 : leftSums) {
            int needed = k - s1;
            if (rightFreq.containsKey(needed)) {
                count += rightFreq.get(needed);
            }
        }

        return count;
    }

    private List<Integer> getSubsetSums(int[] arr, int start, int end) {
        List<Integer> res = new ArrayList<>();
        res.add(0); // Base case: empty subset sum is 0

        for (int i = start; i <= end; i++) {
            int currentNum = arr[i];
            int size = res.size();
            // For every existing sum, create a new sum by adding currentNum
            for (int j = 0; j < size; j++) {
                res.add(res.get(j) + currentNum);
            }
        }
        return res;
    }
}


