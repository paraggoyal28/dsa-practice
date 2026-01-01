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
#define INF 2e18
using namespace std;


void preprocessSegmentTree(vector<ll>& tree, vector<ll>& a, ll s, ll e, ll node) {
    if (s == e) {
        tree[node] = a[s];
        return;
    }

    ll mid = (s + e)/2;
    preprocessSegmentTree(tree, a, s, mid, node*2);
    preprocessSegmentTree(tree, a, mid+1, e, node*2+1);
    tree[node] = tree[node*2] + tree[node*2+1];
}

ll query(vector<ll>& tree, ll l, ll r, ll node, ll s, ll e) {
    // no overlap
    if (s > r || e < l) {
        return 0;
    }

    if (l <= s && e <= r) {
        return tree[node];
    }

    ll mid = (s + e)/2;
    ll left = query(tree, l, r, node*2, s, mid);
    ll right = query(tree, l, r, node*2+1, mid+1, e);
    return left + right;
}

void update(vector<ll>& tree, ll idx, ll value, ll node, ll s, ll e) {
    if (s == e && s == idx) {
        tree[node] = value;
        return;
    }

    ll mid = (s + e)/2;
    if (idx <= mid) {
        update(tree, idx, value, node*2, s, mid);
    }
    else {
        update(tree, idx, value, node*2+1, mid+1, e);
    }
    tree[node] = tree[node*2] + tree[node*2+1];
}

void solveBySegmentTree(vector<ll>& a, ll q, ll n) {
    vector<ll> tree(4*n, 0);
    
    preprocessSegmentTree(tree, a, 0, n-1, 1);

    while (q--) {
        ll type;
        cin >> type;
        if (type == 1) {
            ll idx, value;
            cin >> idx >> value;
            idx--;   
            a[idx] = value;
            update(tree, idx, value, 1, 0, n-1);
        }
        else {
            ll l, r;
            cin >> l >> r;
            l--; r--;
            cout << query(tree, l, r, 1, 0, n-1) << endl;
        }
    }
}

void updateFenwickTree(vector<ll>& tree, ll idx, ll value) {
    while (idx < tree.size()) {
        tree[idx] += value;
        idx += idx & -idx;
    }
}

ll queryFenwickTree(vector<ll>& tree, ll idx) {
    ll sum = 0;
    while (idx > 0) {
        sum += tree[idx];
        idx -= idx & -idx;
    }
    return sum;
}

ll queryFenwickTree(vector<ll>& tree, ll l, ll r) {
    return queryFenwickTree(tree, r) - queryFenwickTree(tree, l-1);
}


void solveByFenwickTree(vector<ll>& a, ll q, ll n) {
    vector<ll> tree(n+1, 0);
    
    for(ll i = 0; i < n; i++) {
        updateFenwickTree(tree, i+1, a[i]);
    }

    while (q--) {
        ll type, l, r, idx, value;
        cin >> type;
        if (type == 1) {
            cin >> idx >> value;
            ll diff = value - a[idx-1];
            a[idx-1] = value;
            updateFenwickTree(tree, idx, diff);
        } else {
            cin >> l >> r;
            cout << queryFenwickTree(tree, l, r) << endl;
        }
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
 
    
    ll n, q;
    cin >> n >> q;
    vector<ll> a(n);
    for(ll i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    // solveBySegmentTree(a, q, n);

    solveByFenwickTree(a, q, n);
    return 0;
}