/*
problem: https://www.geeksforgeeks.org/problems/next-smallest-palindrome4740/1
author: parag kumar goyal
TC: O(N)
SC: O(N)
*/
class Solution {

    boolean isHighest(int num[], int n) {
        for (int i = 0; i < n; ++i) {
            if (num[i] != 9) {
                return false;
            }
        }
        return true;
    }
    
    Vector<Integer> smallest(int n) {
        Vector<Integer> smallestNumber = new Vector<>();
        
        smallestNumber.add(1);
        for (int i = 1; i < n-1; ++i) {
            smallestNumber.add(0);
        }
        smallestNumber.add(1);
        return smallestNumber;
    }
    
    void addNumsToVector(int num[], Vector<Integer> nextPalindrome, int n) {
        for (int i = 0; i < n; ++i) {
            nextPalindrome.add(num[i]);
        }
    }
    
    
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        if (isHighest(num, n)) return smallest(n + 1);
    
        Vector<Integer> nextPalindrome = new Vector<>();
        addNumsToVector(num, nextPalindrome, n);
    
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;
    
        // 1. Mirror left to right
        boolean leftWasGreater = false;
        int tempI = i, tempJ = j;
        while (tempI >= 0) {
            if (nextPalindrome.get(tempI) != nextPalindrome.get(tempJ)) {
                leftWasGreater = nextPalindrome.get(tempI) > nextPalindrome.get(tempJ);
                break;
            }
            tempI--; tempJ++;
        }
        
        // Mirror it anyway
        while (i >= 0) {
            nextPalindrome.set(j++, nextPalindrome.get(i--));
        }
    
        // 2. If it's not greater, increment from the middle out
        if (!leftWasGreater) {
            int carry = 1;
            i = mid - 1;
            if (n % 2 == 1) { // Odd: increment the single middle element first
                int val = nextPalindrome.get(mid) + carry;
                nextPalindrome.set(mid, val % 10);
                carry = val / 10;
                j = mid + 1;
            } else {
                j = mid;
            }
    
            while (i >= 0 && carry > 0) {
                int val = nextPalindrome.get(i) + carry;
                nextPalindrome.set(i, val % 10);
                nextPalindrome.set(j, val % 10); // Keep it symmetric
                carry = val / 10;
                i--; j++;
            }
        }
        return nextPalindrome;
    }
}