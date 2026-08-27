/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/container-with-most-water0535
author: parag kumar goyal
TC: O(n) where n is the size of array
SC: O(1)
*/

class GfG {
    static int maxWater(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        while (left < right) {
            
            // find the water stored in the container between 
            // arr[left] and arr[right]
            int water = Math.min(arr[left], arr[right]) * (right - left);
            res = Math.max(res, water);
            
            if (arr[left] < arr[right])
                left += 1;
            else
                right -= 1;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));
    }
}