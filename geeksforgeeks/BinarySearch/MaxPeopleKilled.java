/*
problem: https://www.geeksforgeeks.org/problems/killing-spree3020/1
author: parag kumar goyal
TC: O(log(p))
SC: O(1)
*/

class Solution {
  public:
    int maxPeopleDefeated(int p) {
        // the number of people killed
        // n*(n+1)*(2*n+1)/6 <= p 
        
        long low = 0, high = 20000;
        long ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low)/2;
            
            // Sum of squares formula: n*(n+1)*(2n+1)/6
            long strengthRequired = (mid * (mid + 1) * (2 * mid + 1)) / 6;
            
            
            if (p >= strengthRequired) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        
        return ans;
    }
    
};
