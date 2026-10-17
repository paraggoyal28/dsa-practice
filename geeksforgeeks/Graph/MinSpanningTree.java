/*
problem: https://www.geeksforgeeks.org/dsa/minimum-cost-connect-cities/
author: parag kumar goyal
TC: O(ElogV)
SC: O(V + E)
 */


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinSpanningTree {
    static class Edge implements Comparable<Edge> {
        int node, weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Function to find the minimum cost to connect all cities
    public static int findMST(int n, int[][] edges) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list to adjacency list
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        boolean[] inMST = new boolean[n+1]; // 1 - based indexing

        minHeap.add(new Edge(1, 0));

        int mstCost = 0;

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();

            int u = edge.node, weight = edge.weight;

            if (inMST[u]) continue;

            mstCost += weight;
            inMST[u] = true;

            for (Edge neighbor: adj.get(u)) {
                if (!inMST[neighbor.node]) {
                    minHeap.add(neighbor);
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        int[][] city1 = {
                {1, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 4},
                {2, 3, 5}, {2, 5, 7}, {3, 4, 5}
        };

        System.out.println(findMST(5, city1));

        int[][] city2 = {
                {1, 2, 1}, {1, 3, 1}, {1, 4, 100}, {2, 3, 1},
                {4, 5, 2}, {4, 6, 2}, {5, 6, 2}
        };

        System.out.println(findMST(6, city2));
    }
}
