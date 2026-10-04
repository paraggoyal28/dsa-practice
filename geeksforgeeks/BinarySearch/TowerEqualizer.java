/*
problem: https://www.geeksforgeeks.org/problems/equalize-the-towers2804/1
author: parag kumar goyal
TC: O(N * log(maxHeight - minHeight)) 
SC: O(1)
*/

import java.util.Arrays;

public class TowerEqualizer {

    /*
    Calculates the total cost to bring all towers height to a specific height
    Time Complexity - O(N)  
    */
    private static long calculateTotalCost(int[] heights, int[] costs, long targetHeight) {
        long totalCost = 0;

        for (int i = 0; i < heights.length; ++i) {
            long distance = Math.abs(heights[i] - targetHeight);
            totalCost += distance * costs[i];
        }

        return totalCost;
    }

    /*
    Finds the minimum cost to equalize all towers using Binary Search
    Logic: The cost function is convex (U-shaped), so we can use Binary Search
    to find the "valley" (the minimum point)
    Time Complexity: O(n * log(HeightRange))
    Space Complexity: O(1)
    */

    public static long getMinEqualizationCost(int[] heights, int[] costs) {
        if (heights == null || heights.length == 0) return 0;

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int h: heights) {
            minHeight = Math.min(minHeight, h);
            maxHeight = Math.max(maxHeight, h);
        }

        long low = minHeight;
        long high = maxHeight;
        long answer = calculateTotalCost(heights, costs, low);

        while (low < high) {
            long mid = low + (high - low)/2;

            long costAtMid = calculateTotalCost(heights, costs, mid);
            long costAtNext = calculateTotalCost(heights, costs, mid + 1);

            // Update the global minimum found so far
            answer = Math.min(answer, costAtMid);

            if (costAtMid > costAtNext) {
                // the curve is still descending, move to right
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return calculateTotalCost(heights, costs, low);
    }


    /*
    Finds the minimum cost to equalize all towers using Binary Search
    Logic: The cost function is convex (U-shaped), so we can use Binary Search
    to find the "valley" (the minimum point)
    Time Complexity: O(nlogn)
    Space Complexity: O(1)
    */
    public static long  getMinEqualizationCostWeightedMedian(int[] heights, int[] costs) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;

        long[][] pairs = new long[n][2];
        long totalCost = 0;

        for (int i = 0; i < n; ++i) {
            pairs[i][0] = heights[i];
            pairs[i][1] = costs[i];
            totalCost += costs[i];
        }

        Arrays.sort(pairs, (a, b) -> Long.compare(a[0], b[0]));

        long prefSum = 0;
        long optimalHeight = pairs[0][0];

        for (int i = 0; i < n; ++i) {
            prefSum += pairs[i][1];

            if (prefSum >= (totalCost + 1)/2) {
                optimalHeight = pairs[i][0];
                break;
            }
        }

        return calculateTotalCost(heights, costs, optimalHeight);
    }

    /*
    Linear Scanning
    */
    public static long  getMinEqualizationCostLinearScan(int[] heights, int[] costs) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;

        long[][] pairs = new long[n][2];
        long totalCost = 0;

        for (int i = 0; i < n; ++i) {
            pairs[i][0] = heights[i];
            pairs[i][1] = costs[i];
            totalCost += costs[i];
        }

        Arrays.sort(pairs, (a, b) -> Long.compare(a[0], b[0]));

        long prefixCost = pairs[0][1];
        long startingCost = 0;

        long startingHeight = pairs[0][0];

        for (int i = 1; i < n; ++i) {
            startingCost += (long) Math.abs(pairs[i][0] - startingHeight) * pairs[i][1];
        }

        long minTotalCost = startingCost;

        for (int i = 1; i < n; ++i) {
            long delta = pairs[i][0] - pairs[i-1][0]; 

            startingCost = startingCost + delta * (2 * prefixCost - totalCost);

            minTotalCost = Math.min(minTotalCost, startingCost);

            prefixCost += pairs[i][1];
        }



        return minTotalCost;
    }


    public static void main(String[] args) {
        int[] heights = {1, 2, 3};
        int[] costs = {100, 10, 1000};

        System.out.println("Minimum Cost: " + getMinEqualizationCost(heights, costs));
        System.out.println("Minimum Cost: " + getMinEqualizationCostWeightedMedian(heights, costs));
        System.out.println("Minimum Cost: " + getMinEqualizationCostLinearScan(heights, costs));

    }

}

/* 
Weighted Median
*/

