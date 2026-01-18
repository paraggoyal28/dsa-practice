/*
problem: Number of provinces
https://www.geeksforgeeks.org/problems/number-of-provinces/1?
Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

author: parag kumar goyal
TC: O(V^2)
SC: O(V)
*/

#include <iostream>
#include <vector>
using namespace std; 

class Solution {
public:
    void visit(vector<vector<int>>& adj, int node, vector<bool>& visited) {
        visited[node] = true;
        
        for (int neigh = 0, V = (int) adj.size(); neigh < V; ++neigh) {
            if (!visited[neigh] && adj[node][neigh]) {
                visit(adj, neigh, visited);
            }
        }
    }
  
    int numProvinces(vector<vector<int>> adj, int V) {
        // code here
        vector<bool> visited(V, false);
        int provinces = 0;
        
        for (int node = 0; node < V; ++node) {
            if (!visited[node]) {
                visit(adj, node, visited);
                provinces++;
            }
        }
        
        return provinces;
    }
}