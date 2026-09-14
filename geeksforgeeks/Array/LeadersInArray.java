/*
problem: https://www.geeksforgeeks.org/dsa/leaders-in-an-array/
author: parag kumar goyal
TC: O(n) SC: O(1)
*/


class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> leaderArray = new ArrayList<>();

        int maxSoFar = Integer.MIN_VALUE;

        for (int itr = arr.length - 1; itr >= 0; --itr) {
            if (arr[itr] >= maxSoFar) {
                leaderArray.add(arr[itr]);
                maxSoFar = arr[itr];
            }
        }

        Collections.reverse(leaderArray);

        return leaderArray;
    }
}