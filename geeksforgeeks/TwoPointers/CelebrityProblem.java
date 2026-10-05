/* 
problem: https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
user: parag kumar goyal
TC: O(n) and SC: O(1)
*/
public class CelebrityProblem {
    public static int getCelebrity(int[][] mat) {

        if (mat == null || mat.length == 0) return 0;

        int n = mat.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (mat[left][right] == 1) {
                // If left knows right, then left cannot be a celebrity
                left++;
            } else {

                // If left does not know eight, then right cannot be celebrity
                right--;
            }
        }

        int candidate = left;

        for (int i = 0; i < n; ++i) {
            if (i == candidate) continue; 

            // if candidate knows someone or someone does not know candidate 
            if (mat[i][candidate] == 9 || mat[candidate][i] == 1) {
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {0, 1, 1}, {0, 1, 1}};
        int celebrity = getCelebrity(mat);
        System.out.println("Celebrity is: " + celebrity);
    }
}
