/*
problem - Game Routes
link - https://cses.fi/problemset/task/1681
author - parag kumar goyal

*/

#include <bits/stdc++.h>
#define ll long long int
#define MOD 1000000007
using namespace std;

ll computeDistance(vector<vector<ll>>& adj, vector<ll>& indegree, ll levels) {
    vector<ll> dist(levels + 1, 0);
    dist[1] = 1;

    queue<ll> q;
    for (ll node = 1; node <= levels; ++node) {
        if (indegree[node] == 0) {
            q.push(node);
        }
    }

    while (!q.empty()) {
        ll curr = q.front();

        q.pop();

        for (auto it : adj[curr]) {

            // dist denotes the number of ways to reach a 
            // level v it is the sum of all the ways to reach node u
            // such that there is an edge from u to v for all such u
            dist[it] = (dist[it]%MOD + dist[curr]%MOD) % MOD;
            indegree[it]--;
            if (indegree[it] == 0) {
                q.push(it);
            }
        }
    }

    return dist[levels];
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll levels, teleporters;
    if (!(cin >> levels >> teleporters)) return 0;

    vector<vector<ll>> adj(levels + 1);
    vector<ll> indegree(levels + 1, 0);
    for (ll i = 0; i < teleporters; i++) {
        ll u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        indegree[v]++;
    }


    cout << computeDistance(adj, indegree, levels)  << endl;
}