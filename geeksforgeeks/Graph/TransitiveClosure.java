/*
problem: https://www.geeksforgeeks.org/problems/transitive-closure-of-a-graph0930/1
author: parag kumar goyal
*/

/*
Floyd Warshall
TC: O(N^3)
SC: O(N^2)
*/
class Solution {

    static int[][] transitiveClosure(int N, int[][] graph) {

        int[][] tc = new int[N][N];

        // copy graph and set self reachability
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tc[i][j] = graph[i][j];
            }
            tc[i][i] = 1;
        }

        // Warshall
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {

                if (tc[i][k] == 1) {  // prune

                    for (int j = 0; j < N; j++) {
                        if (tc[k][j] == 1) {
                            tc[i][j] = 1;
                        }
                    }
                }
            }
        }

        return tc;
    }
}

/*
Using BitSet
O(N³) → O(N³ / 64)
*/


class Solution {

    static int[][] transitiveClosure(int N, int[][] graph) {

        BitSet[] reach = new BitSet[N];

        for (int i = 0; i < N; i++) {
            reach[i] = new BitSet(N);

            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1)
                    reach[i].set(j);
            }

            reach[i].set(i);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (reach[i].get(k)) {
                    reach[i].or(reach[k]); // fast bitwise OR
                }
            }
        }

        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = reach[i].get(j) ? 1 : 0;
            }
        }

        return result;
    }
}

/*
DFS - 
O(V * (V + E))
*/

class Solution {

    static int[][] transitiveClosure(int N, int[][] graph) {

        int[][] tc = new int[N][N];
`       
        /* for a particular source node
            check for each node can be reachable or not
            i -> 
        */
        for (int i = 0; i < N; i++) {
            dfs(i, i, graph, tc);
        }

        return tc;
    }

    static void dfs(int src, int node, int[][] graph, int[][] tc) {
        tc[src][node] = 1;

        for (int next = 0; next < graph.length; next++) {
            if (graph[node][next] == 1 && tc[src][next] == 0) {
                dfs(src, next, graph, tc);
            }
        }
    }
}


