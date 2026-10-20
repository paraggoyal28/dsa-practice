/*
Given n points on a line numbered from 1 to n, and a list of intervals,
where each interval [l, r, count] adds count to every point from l to r
(inclusive). Compute the total count at each point after processing all intervals.
Examples:
Input : n = 5, intervals[] = [[1, 2, 9], [2, 4, 5], [3, 5, 7]]
Output : [9, 14, 12, 12, 7]
Explanation:
 Points:                  1   2   3   4   5
 Interval [1,2,9]:    9  9
 Interval [2,4,5]:       5   5   5
 Interval [3,5,7]:              7   7   7
 Total count:        9  14  12  12   7

Input : n = 4, intervals[] = [[1, 3, 2], [2, 4, 3]]
Output : [2, 5, 5, 3]
Explanation:
 Points:                  1   2   3   4
 Interval [1,3,2]:    2   2   2
 Interval [2,4,3]:        3   3   3
 Total count:         2   5   5   3

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;
    int count;
    Interval(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }
}

public class CountPointInInterval {

    private static int[] calculatePoints(int n, List<Interval> intervals) {
        int[] points = new int[n+1];

        for (Interval interval: intervals) {
            int start = interval.start;
            int end = interval.end;
            points[start] += interval.count;
            if (end < n)
                points[end + 1] -= interval.count;
        }

        for (int  i = 1; i <= n; ++i) {
            points[i] += points[i-1];
        }

        return points;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        int n = 5;
        intervals.add(new Interval(1, 2, 9));
        intervals.add(new Interval(2, 4, 5));
        intervals.add(new Interval(3, 5, 7));
        int[] points = calculatePoints(n, intervals);
        System.out.println("Points at each index is: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(points[i] + " ");
        }
        System.out.println();
    }
}
