/*
problem; https://www.geeksforgeeks.org/problems/killing-spree3020/1
author; parag kumar goyal

*/

//TC: O(cuberoot(N))
// SC: O(1)
public class KillingSpree {
  public long  killingSpree(long n) {
        // Code Here
        // basically calculate the sum and then do binary search 
        long  personsKilled = 0;
        for (long i = 1; i * i <= n; ++i) {
            n -= i * i;
            personsKilled += 1;
        }
        
        return personsKilled;
    }
};

//TC: O(logN)
// SC: O(1)

class KillingSolution {
     long killingSpree(long n) {
        long minKilledPeople = 1;
        // For N = 10^12, 2*10^4 is safe. 
        // If N was 10^{18}, you'd need ~1,442,250.
        long maxKilledPeople = 2000000;
        long peopleCanBeKilled = 0; // Initialize to 0
        
        while (minKilledPeople <= maxKilledPeople) {
            long mid = minKilledPeople + (maxKilledPeople - minKilledPeople) / 2;
            
            // Using __int128 or careful multiplication to avoid overflow 
            // though for 10^12, long long is plenty.
            long sumSquares = (mid * (mid + 1) * (2 * mid + 1)) / 6;
            
            if (sumSquares <= n) {
                peopleCanBeKilled = mid; 
                minKilledPeople = mid + 1;
            } else {
                maxKilledPeople = mid - 1;
            }
        }
        
        return peopleCanBeKilled;
    }
}