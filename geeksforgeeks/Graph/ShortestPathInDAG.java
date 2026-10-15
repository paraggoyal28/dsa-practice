/*
problem: https://www.geeksforgeeks.org/dsa/shortest-path-for-directed-acyclic-graphs/
author: parag kumar goyal
TC: O(V + E)
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ShortestPathInDAG {

    private static ArrayList<Integer> getShortestPath(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int[] inDegree = new int[V];
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        List<Integer> toplogicalOrder = new ArrayList<>();
        ArrayList<Integer> shortestPath = new ArrayList<>();

        for (int i = 0; i < V; ++i) {
            graph.add(new ArrayList<>());
            inDegree[i] = 0;
            shortestPath.add(Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
            inDegree[v]++;
        }

        for (int i = 0; i < V; ++i) {
            if(inDegree[i] == 0) {
                bfs.offerLast(i);
            }
        }

        // generate the topological ordering
        while (!bfs.isEmpty()) {
            int current = bfs.pollFirst();
            toplogicalOrder.add(current);
            for (int[] neighbor: graph.get(current)) {
                int v = neighbor[0];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    bfs.offerLast(v);
                }
            }
        }

        // get the shortest path
        shortestPath.set(0, 0);
        for (int node: toplogicalOrder) {
            // if current node is reachable from 0
            if (shortestPath.get(node) != Integer.MAX_VALUE) {
                for (int[] neighbor: graph.get(node)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    // relax weight
                    if (shortestPath.get(v) > shortestPath.get(node) + w) {
                        shortestPath.set(v, shortestPath.get(node) + w);
                    }
                }
            }
        }


        for (int node = 0; node < V; ++node) {
            if (shortestPath.get(node) == Integer.MAX_VALUE) {
                shortestPath.set(node, -1);
            }
        }


        return shortestPath;
    }


    public static void main(String[] args) {
        int[][] edges = new int[3][3];

        edges[0][0] = 0;
        edges[0][1] = 2;
        edges[0][2] = 4;

        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[1][2] = 1;

        edges[2][0] = 2;
        edges[2][1] = 3;
        edges[2][2] = 1;

        ArrayList<Integer> shortestDistances = getShortestPath(4, edges);

        System.out.println(shortestDistances);
    }
}
