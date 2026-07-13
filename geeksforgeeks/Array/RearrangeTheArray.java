/*
problem: https://www.geeksforgeeks.org/problems/rearrange-the-array-1639032648/1
Consider an array a[] = [1, 2, 3, ..., n] and a permutation b[] of size n containing all integers from 1 to n exactly once.

The array b[] defines a rearrangement operation.
During a single operation, every element at position i in a[] moves to position b[i] (1-based indexing).
We must do at least one operation on a[].
Find the minimum number of operations required for all elements to return to their original positions simultaneously, i.e., for a[] to become: [1, 2, 3, ..., n] again.

Note:  The answer can be large, so return the answer modulo 10^9+7.
author: parag kumar goyal

*/


/*
Brute Force
TC: O(n*(number of operations))
SC: O(n)
*/

public class GFG {
    static final int MOD = 1000000007;

    // Checks whether the array has
    // returned to its original state.
    static boolean isOriginal(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != i + 1)
                return false;
        }
        return true;
    }

    // Returns the minimum operations required to restore
    // the array to its original state using simulation.
    static int minOperations(int[] b) {
        int n = b.length;
        
        // Initial array [1, 2, 3, ..., n]
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i + 1;

        int operations = 0;
        
        // Keep applying the permutation until
        // the array is restored.
        while (true) {
            int[] temp = new int[n];
            // Move element at position i to position b[i].
            for (int i = 0; i < n; i++) {
                temp[b[i] - 1] = a[i];
            }
            a = temp;
            operations++;
            if (isOriginal(a))
                break;
        }
        return operations % MOD;
    }

    public static void main(String[] args) {
        int[] b = {2, 3, 1, 5, 4};
        System.out.println(minOperations(b));
    }
}



/*
Optimized Approach
TC: O(nlogn)
SC: O(n)

*/
class Solution {
    static final int MOD = 1000000007;
  
    // Computes (x^y) % MOD using binary exponentiation
    static long modPow(long x, long y) {
        long res = 1;
        
        x %= MOD;
        
        while (y > 0) {
            if ((y&1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            y >>= 1;
        }
        
        return res;
    }
  
  
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        List<Integer> cycles = new ArrayList<>();
        
        // Find lengths of all disjoint cycles
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    
                    cur = b[cur] - 1;
                    len++;
                }
                cycles.add(len);
            }
        }
        
        // Smallest Prime Factor
        int[] spf = new int[n+1];
        for (int i = 0; i <= n; ++i) {
            spf[i] = i;
        }
        
        for (int i = 2; (long) i * i <= n; ++i) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        
        
        Map<Integer, Integer> maxPower = new HashMap<>();
        
        // Store maximum exponent of every prime
        // appearing in any cycle length
        for (int len: cycles) {
            Map<Integer, Integer> freq = new HashMap<>();
            while (len > 1) {
                int p = spf[len];
                int cnt = 0;
                while (len%p == 0){
                    len /= p;
                    cnt++;
                }
                freq.put(p, cnt);
            }
            
            for (Map.Entry<Integer, Integer> it: freq.entrySet()) {
                maxPower.merge(it.getKey(), it.getValue(), Math::max);
            }
        }
        
        // Reconstruct LCM modulo MOD
        long res = 1;
        for (Map.Entry<Integer, Integer> it : maxPower.entrySet()) {
            res = (res * modPow(it.getKey(), it.getValue()))%MOD;
        }
        
        
        return (int)res;
    }
};