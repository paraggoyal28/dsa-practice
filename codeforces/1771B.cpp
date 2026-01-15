/*
problem: https://codeforces.com/problemset/problem/1771/B
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long
using namespace std;

class DSU {
public:
    vector<ll> parent;
    
    DSU(ll n) {
        parent.resize(n+1, -1);
    }

    ll findParent(ll node) {
        if (parent[node] == -1) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    void merge(ll node1, ll node2) {
        ll parent1 = findParent(node1);
        ll parent2 = findParent(node2);
        if (parent1 == parent2) return;

        if (parent1 < parent2) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll tests;
    cin >> tests;

    

    while (tests--) {
        ll n, m;
        cin >> n >> m;
        
        DSU* dsu = new DSU(n);
        // If we assign not friends pair max friend index the less friend as parent
        // Now all we need to do is we keep two pointer one notes the start
        // and second iterates if parent[arr[secondIdx]] < secondIdx then start = secondIndex
        // and we move forward to find the pairs will secondIdx - firstIdx
        
        ll ans = n;
        
        for (ll pair = 0; pair < m; ++pair) {
            ll u, v;
            cin >> u >> v;
            dsu->merge(u, v);  
        }

        ll start = 1;
        for (ll end = 2; end <= n; ++end) {
            if (dsu->findParent(end) < end) {
                start = end;
            } else {
                ans += end - start;
            }
        }
        
        cout << ans << endl;
    }

    return 0;
}