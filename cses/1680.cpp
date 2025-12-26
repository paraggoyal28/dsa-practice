#include <bits/stdc++.h>
#define ll long long int
using namespace std;

vector<ll> path;

void print(vector<ll>& path) {
    cout << path.size() << endl;
    for (ll city: path) {
        cout << city << " ";
    }
    cout << endl;
}

// Function to find the longest path using Topological Sort + DP
void findingShortestPath(vector<vector<ll>>& adj, ll srcCity, ll cities, vector<ll>& in_degree) {
    // dist[i] stores the longest distance from srcCity to i
    // Initialize with a very small number to represent unreachability
    vector<ll> dist(cities + 1, -1e9); 
    vector<ll> parent(cities + 1, -1);

    // Queue for Kahn's Algorithm
    queue<ll> q;
    
    // Push all nodes with in-degree 0
    for(int i = 1; i <= cities; ++i) {
        if(in_degree[i] == 0) {
            q.push(i);
        }
    }

    // Base case: Distance to source is 1 (counting the city itself as per problem requirement usually, or 0 edges)
    // Problem asks for "number of cities".
    dist[srcCity] = 1;

    while(!q.empty()) {
        ll u = q.front();
        q.pop();

        for(auto v : adj[u]) {
            // Update distance if u is reachable from source
            if(dist[u] != -1e9) {
                if(dist[u] + 1 > dist[v]) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                }
            }

            in_degree[v]--;
            if(in_degree[v] == 0) {
                q.push(v);
            }
        }
    }

    // Check if we reached the destination
    if(dist[cities] < 0) {
        cout << "IMPOSSIBLE\n";
        return;
    }

    // Reconstruct path
    ll curr = cities;
    while(curr != -1) {
        path.push_back(curr);
        curr = parent[curr];
    }
    
    // Check if the path actually starts at srcCity (validity check)
    if(path.back() != srcCity) {
         cout << "IMPOSSIBLE\n";
         return;
    }

    reverse(path.begin(), path.end());
    print(path);
}

int main() {
    
    /* optimizing the input and output*/
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll cities, flights;
    if (!(cin >> cities >> flights)) return 0;

    // Use regular adjacency list for topological sort
    vector<vector<ll>> adj(cities + 1);
    vector<ll> in_degree(cities + 1, 0);

    for (ll i = 0; i < flights; i++) {
        ll u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        in_degree[v]++;
    }

    findingShortestPath(adj, 1, cities, in_degree);
    
    return 0;
}
