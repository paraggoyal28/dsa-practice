/*
problem: Dynamic Range Minimum Queries
author: parag kumar goyal
url: https://cses.fi/problemset/task/1649
approach: Segment Tree
time: O(logn) for query O(logn) for update O(n) for preprocessing
space: O(4*n)
*/
#include <bits/stdc++.h>
#define ll long long int
#define INF 2e18
using namespace std;

void preprocessSegmentTree(vector<ll>& tree, vector<ll>& a, ll start, ll end, ll node) {
    if (start == end) {
        tree[node] = a[start];
        return;
    }

    ll mid = (start + end)/2;
    preprocessSegmentTree(tree, a, start, mid, node*2);
    preprocessSegmentTree(tree, a, mid+1, end, node*2+1);
    tree[node] = min(tree[node*2], tree[node*2+1]);
}

void updateSegmentTree(vector<ll>& tree, ll start, ll end, ll node, ll idx, ll value) {
    if (start == end) {
        tree[node] = value;
        return;
    }

    ll mid = (start + end)/2;
    if (idx <= mid) {
        updateSegmentTree(tree, start, mid, node*2, idx, value);
    } else {
        updateSegmentTree(tree, mid+1, end, node*2+1, idx, value);
    }
    tree[node] = min(tree[node*2], tree[node*2+1]);
}

ll querySegmentTree(vector<ll>& tree, ll start, ll end, ll node, ll l, ll r) {
    if (start > r || end < l) {
        return INF;
    }

    if (l <= start && end <= r)  {
        return tree[node];
    }

    ll mid = (start + end)/2;
    ll left = querySegmentTree(tree, start, mid, 2 * node, l, r);
    ll right = querySegmentTree(tree, mid+1, end, 2 * node + 1, l, r);
    return min(left, right);
}


void solveBySegmentTree(vector<ll>& a, ll n, ll q) {
    vector<ll> tree(4*n, INF);
    
    preprocessSegmentTree(tree, a, 0, n-1, 1);

    while (q--) {
        ll type, idx, value, l, r;
        cin >> type;
        if (type == 1) {
            cin >> idx >> value;
            a[idx - 1] = value;
            updateSegmentTree(tree,  0, n-1, 1, idx-1, value);
        } else {
            cin >> l >> r;
            cout << querySegmentTree(tree, 0, n-1, 1, l-1, r-1) << endl;
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
    

    solveBySegmentTree(a, n, q);
    return 0;
}