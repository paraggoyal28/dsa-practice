/*
problem: https://www.geeksforgeeks.org/problems/all-numbers-with-specific-difference3558/1
author: parag kumar goyal
*/

/*
TC: O(nlog10n)
SC: O(1)
*/
class Solution {
    private int findSumOfDigits(int number) {
        int sumOfDigits = 0;
        
        while (number > 0) {
            sumOfDigits += number%10;
            number = number/10;
        }
        
        return sumOfDigits;
    }
    
    public int getCount(int n, int d) {
        // code here
        int cnt = 0;
        
        for (int number = 1; number <= n; ++number) {
            
            int sumOfDigits = findSumOfDigits(number);
            
            if (number - sumOfDigits >= d) {
                cnt++;
            }
        }
        
        return cnt;
    }
};

/*
TC: O(log10(n)*log2(n))
SC: O(1)
*/
class Solution {
    private long findSumOfDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public long getCount(long n, long d) {
        long low = 1, high = n;
        long firstSatisfying = n + 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Property: x - sumDigits(x) is non-decreasing
            if (mid - findSumOfDigits(mid) >= d) {
                firstSatisfying = mid;
                high = mid - 1; // Look for a smaller number
            } else {
                low = mid + 1; // Look for a larger number
            }
        }

        // If no number satisfies it, firstSatisfying is n+1, returns 0
        return n - firstSatisfying + 1;
    }
}