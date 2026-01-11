/*
problem: Range Update Queries
author: parag kumar goyal
url: https://cses.fi/problemset/task/1651
approach: BIT Tree
time: O(logn) for query O(logn) for update O(n) for preprocessing
space: O(4*n)
*/
#include <bits/stdc++.h>
#define ll long long 
using namespace std;

class BIT {
    public:
        vector<ll> tree;
        ll size;

        BIT(ll n) {
            tree.resize(4*n, 0);
            size = 4*n;
        }

        void add(ll index, ll value) {
            while (index < size) {
                tree[index] += value;
                index += index & (-index);
            }
        }

        ll query(ll index) {
            ll sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }

            return sum;
        }
};

int main() {
    ll n, q;

    cin >> n >> q;
    
    vector<ll> a(n);
    BIT* bit = new BIT(n);
    for (ll i = 0; i < n; ++i) {
        cin >> a[i];
        bit->add(i+1, a[i] - (i == 0 ? 0 : a[i-1]));
    }

    while (q--) {
        ll type;
        cin >> type;
        if (type == 2) {
            ll k;
            cin >> k;
            cout << bit->query(k) << endl; 
        } else {
            ll a, b, u;
            cin >> a >> b >> u;

            bit->add(a, u);
            bit->add(b+1, -u);
        }
    }

    return 0;
}