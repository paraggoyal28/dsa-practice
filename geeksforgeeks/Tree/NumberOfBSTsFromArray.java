/*
problem: https://www.geeksforgeeks.org/problems/number-of-bst-from-array/1
author: parag kumar goyal
TC: O(n^2) for calculating catalan numbers
SC: O(n) for storing catalan numbers
*/

import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;

    private static class Pair {
        int value;
        int originalIndex;

        Pair(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }

    public ArrayList<Long> countBSTs(int[] arr) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();

        // 1. Precompute Catalan Numbers up to n using DP
        // C[i] = Sum of (C[j] * C[i-1-j]) for j from 0 to i-1
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        if (n > 0) catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + (catalan[j] * catalan[i - 1 - j]) % MOD) % MOD;
            }
        }

        // 2. Map values to original indices and sort
        List<Pair> sortedWithIdx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedWithIdx.add(new Pair(arr[i], i));
        }
        sortedWithIdx.sort(Comparator.comparingInt(a -> a.value));

        // 3. Initialize result list with zeros
        ArrayList<Long> result = new ArrayList<>(Collections.nCopies(n, 0L));

        // 4. Calculate BSTs for each element as root
        for (int i = 0; i < n; i++) {
            int leftElements = i;
            int rightElements = n - i - 1;

            // Number of BSTs = (BSTs from left side) * (BSTs from right side)
            long count = (catalan[leftElements] * catalan[rightElements]) % MOD;
            
            int originalIdx = sortedWithIdx.get(i).originalIndex;
            result.set(originalIdx, count);
        }

        return result;
    }
}


/*
TC: O(NlogN)
SC: O(N)
*/

public class Solution {

    static final int MOD = 1000000007;

    // Precompute factorials
    static long[] fact;
    static long[] invFact;

    public static void precompute(int maxN) {
        int limit = 2 * maxN; 

        fact = new long[limit + 1];
        invFact = new long[limit + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; ++i) {
            fact[i] = (fact[i-1] * i) % MOD;
        }

        invFact[limit] = power(fact[limit], MOD-2); 

        for (int i = limit - 1; i >= 0; --i) {
            invFact[i] = (invFact[i+1] * (i+1)) % MOD; 
        }
    }

    static long power(long base, long exp) {
        long res = 1; 
        base %= MOD; 

        while (exp > 0) {
            if (exp%2 == 1) res = (res * base) % MOD; 
            base = (base * base) % MOD; 
            exp /= 2;
        }

        return res;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;

        return (((fact[n] * invFact[r]) % MOD) * invFact[n-r]) % MOD; 
    }

    static long getCatalan(int n) {
        // Formulat C(n) = 1/(n+1) * binom(2n, n)

        long binom = nCr(2*n, n);
        long invNPlus1 = power(n + 1, MOD - 2);
        return (binom * invNPlus1) % MOD;  
    }

    public long[] solve(int[] arr) {
        int n = arr.length;
        precompute(n);

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; ++i) {
            indices[i] = i;
        }

        // Custom sort on primitive array indices
        Arrays.sort(indices, (a, b) -> Integer.compare(arr[a], arr[b]));

        long[] result = new long[n];
        for (int i = 0; i < n; ++i) {
            int leftCount = i;
            int rightCount = n - i - 1;
            
            long ways = (getCatalan(leftCount) * getCatalan(rightCount)) % MOD; 
            result[indices[i]] = ways; 
        }

        return result; 
    }

}