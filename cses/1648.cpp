/*
problem: Dynamic Range Sum Queries
author: parag kumar goyal
url: https://cses.fi/problemset/task/1648
approach: Segment Tree
time: O(logn) for query O(logn) for update O(n) for preprocessing
space: O(4*n)
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

class BIT {
public:
    vector<ll> tree;
    ll size;
    BIT(ll n) {
        tree.resize(4 * n, 0);
        size = 4 * n;
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
        bit->add(i+1, a[i]);
    }


    while (q--) {
        ll type;
        cin >> type;
        if (type == 1) {
            ll index, value;
            cin >> index >> value;
            ll diff = value - a[index-1];
            a[index-1] = value;

            bit->add(index, diff);
        } else {
            ll left, right;
            cin >> left >> right;
            ll rightSum = bit->query(right);
            ll leftSum = bit->query(left-1);
            cout << rightSum - leftSum << endl;
        }
    }

    return 0;
}