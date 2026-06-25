/*
problem: https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
author: parag kumar goyal
TC: O(10Cn) where n <= 9
SC: O(n) + O(10Cn) where n <= 9
*/

public class Solution {

    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // if n out of range return ans
        if (n <= 0 || n > 9) return ans;
        
        if (n == 1) ans.add(0);

        backtrack(0, 0, n, ans);

        return ans;
    }

    private static void backtrack(int currentNum, int lastDigit, int remainingDigits, ArrayList<Integer> ans) {

        if (remainingDigits == 0) {
            ans.add(currentNum);
            return;
        }

        for (int nextDigit = lastDigit + 1; nextDigit <= 9; ++nextDigit) {
            backtrack(currentNum * 10 + nextDigit, nextDigit, remainingDigits - 1, ans);
        }
    }

}