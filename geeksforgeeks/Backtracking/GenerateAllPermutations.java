/*
problem: https://www.geeksforgeeks.org/problems/generate-permutations-of-an-array/1
author: parag kumar goyal
TC: O(n*n!) to generate permutations that are n! and n when doing the add operation to 
copy the array value into final result 
SC: O(n*n!) to store all permutations
*/

class Solution {

    /**
     * Main entry point for generating distinct permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        // Base Case: Current permutation is complete
        if (start == nums.length) {
            result.add(convertArrayToList(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i); // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> convertArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) list.add(n);
        return list;
    }
}
