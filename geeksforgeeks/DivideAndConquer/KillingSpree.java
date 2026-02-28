/*
problem; https://www.geeksforgeeks.org/problems/killing-spree3020/1
author; parag kumar goyal

*/

TC: O(cuberoot(N))
SC: O(1)
class Solution {
  public:
    long long int killinSpree(long long int n) {
        // Code Here
        // basically calculate the sum and then do binary search 
        long long int personsKilled = 0;
        for (long long int i = 1; i * i <= n; ++i) {
            n -= i * i;
            personsKilled += 1;
        }
        
        return personsKilled;
    }
};

TC: O(logN)
SC: O(1)

class Solution {
public:
    long long int killinSpree(long long int n) {
        long long minKilledPeople = 1;
        // For N = 10^12, 2*10^4 is safe. 
        // If N was 10^{18}, you'd need ~1,442,250.
        long long maxKilledPeople = 2000000; 
        long long peopleCanBeKilled = 0; // Initialize to 0
        
        while (minKilledPeople <= maxKilledPeople) {
            long long mid = minKilledPeople + (maxKilledPeople - minKilledPeople) / 2;
            
            // Using __int128 or careful multiplication to avoid overflow 
            // though for 10^12, long long is plenty.
            long long sumSquares = (mid * (mid + 1) * (2 * mid + 1)) / 6;
            
            if (sumSquares <= n) {
                peopleCanBeKilled = mid; 
                minKilledPeople = mid + 1;
            } else {
                maxKilledPeople = mid - 1;
            }
        }
        
        return peopleCanBeKilled;
    }
};