/*
check whether a graph is bipartite or not
TC: O(V + E)
SC: O(V + E)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class GraphBipartite {
    private static boolean cannotColor(int node, int V, ArrayList<ArrayList<Integer>> adj,
                                        int[] colors, int clr) {
        colors[node] = clr;

        for (int neighbor: adj.get(node)) {
            if (colors[neighbor] == -1 && cannotColor(neighbor, V, adj, colors, 1 - clr)) {
                return true;
            } else if (colors[neighbor] == clr) {
                return true;
            }
        }

        return false;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int node = 0; node < V; ++node) {
            // if node is not colored yet
            if (colors[node] == -1) {
                if (cannotColor(node, V, adj, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<Integer>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 2}, {2, 3}
        };

        int V = 4;

        ArrayList<ArrayList<Integer>> adj = constructAdj(V, edges);

        System.out.println("The graph is bipartite: " + isBipartite(V, adj));
    }
}
