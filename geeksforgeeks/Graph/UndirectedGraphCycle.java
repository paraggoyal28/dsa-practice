/*
problem: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/graph-gfg-160/problem/detect-cycle-in-an-undirected-graph
author: parag kumar goyal
TC: O(V + E)
SC: O(V)
 */

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycle {

    private static boolean isCyclicUtil(int node, boolean[] visited, List<List<Integer>> graph,
                                        int parent) {

        visited[node] = true;

        for (int neigh: graph.get(node)) {
            if (!visited[neigh]) {
                if (isCyclicUtil(neigh, visited, graph, node)) {
                    return true;
                }
            } else if (neigh != parent) {
                return true;
            }
        }

        return false;
    }


    public static boolean isCycle(int V, int[][] edges) {

        if (edges == null || edges.length == 0) return false;

        List<List<Integer>> graph = new ArrayList<>();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            if (edge[0] == edge[1]) return true; // self loops

            if (graph.get(edge[0]).contains(edge[1])) return true; // parallel edge

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int node = 0; node < V; ++node) {
            if (!visited[node]) {
                if (isCyclicUtil(node, visited, graph, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        int[][] edges = new int[3][2];

        edges[0][0] = 0;
        edges[0][1] = 1;

        edges[1][0] = 0;
        edges[1][1] = 2;

        edges[2][0] = 2;
        edges[2][1] = 3;

        System.out.println("Does the above graph contains cycle: " + isCycle(V, edges));
    }
}
