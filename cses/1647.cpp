/*
problem: Static Range Minimum Queries
author: parag kumar goyal
url: https://cses.fi/problemset/task/1647

*/


#include <bits/stdc++.h>
#define ll long long int
using namespace std;


void solveBySparseTable(ll q, vector<ll>& a) {
    ll n = a.size();
    
    /*
    preprocessing: O(nlogn)
    space: O(nlogn)
    */
    ll logRange = log2(n);
    vector<vector<ll>> lookup(n, vector<ll>(logRange + 1));
    for (ll i = 0; i < n; i++) {
        lookup[i][0] = i;
    }
    for (ll j = 1; j <= logRange; j++) {
        for (ll i = 0; i + (1 << j) <= n; i++) {
            if (a[lookup[i][j - 1]] <= a[lookup[i + (1 << (j - 1))][j - 1]]) {
                lookup[i][j] = lookup[i][j - 1];
            } else {
                lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
            }
        }
    }


    /*
    query; O(1)
    */
    while (q--) {
        ll l, r;
        cin >> l >> r;
        l--;
        r--;

        ll len = r - l + 1;
        ll j = log2(len);
        
        cout << min(a[lookup[l][j]], a[lookup[r - (1 << j) + 1][j]]) << endl;
        
    }
}

/*
preprocessing: O(n)
space: O(n)
*/
vector<ll> preprocessSqrtDecomposition(vector<ll>& a, ll n) {

    ll blk_size = (ll) sqrt(n);
    ll num_blocks = (n + blk_size - 1) / blk_size;
    vector<ll> blocks(num_blocks, INT_MAX);
    for (ll i = 0; i < n; i++) {
        ll blk_idx = i / blk_size;
        blocks[blk_idx] = min(blocks[blk_idx], a[i]);
    }
    return blocks;
}
/*
time: O(sqrt(n))
*/
ll querySqrtDecomposition(ll l, ll r, vector<ll>& blocks, vector<ll>& a) {
    ll n = a.size();
    
    ll minValue = 2e18;
    
    ll blk_size = (ll) sqrt(n);

    while (l <= r && l%blk_size != 0) {
        minValue = min(minValue, a[l]);
        l++;
    }

    while (l + blk_size - 1 <= r) {
        minValue = min(minValue, blocks[l/blk_size]);
        l += blk_size;
    }

    while (l <= r) {
        minValue = min(minValue, a[l]);
        l++;
    }

    return minValue;
}

void solveBySqrtDecomposition(ll q, vector<ll>& a) {
    ll n = a.size();

    vector<ll> blocks = preprocessSqrtDecomposition(a, n);

    while (q--) {
        ll l, r;
        cin >> l >> r;
        l--;
        r--;
        cout << querySqrtDecomposition(l, r, blocks, a) << endl;
    }
}

void build(vector<ll>& a, ll node, ll start, ll end, vector<ll>& tree) {
    if (start == end) {
        tree[node] = a[start];
        return;
    }

    ll mid = (start + end) / 2;
    build(a, node*2, start, mid, tree);
    build(a, node*2 + 1, mid + 1, end, tree);
    tree[node] = min(tree[2*node], tree[2*node+1]);
}

/*
preprocessing: O(n)
space: O(4*n)
*/
vector<ll> preprocessingSegmentTree(vector<ll>& a, ll n) {
    vector<ll> tree(4*n, 0);
    build(a, 1, 0, n-1, tree);
    return tree;
}

/*
time: O(logn)
space: O(1)
*/
ll querySegmentTree(ll l, ll r, vector<ll>& tree, ll start, ll end, ll node) {
    // No Overlap
    if (start > r || end < l) {
        return 2e18;
    }

    // Complete Overlap
    if (l <= start && end <= r) {
        return tree[node];
    }

    ll mid = (start + end) / 2;
    ll left = querySegmentTree(l, r, tree, start, mid, node*2);
    ll right = querySegmentTree(l, r, tree, mid + 1, end, node*2 + 1);
    return min(left, right);
}

void solveBySegmentTree(ll q, vector<ll>& a) {
    ll n = a.size();
    
    vector<ll> tree = preprocessingSegmentTree(a, n);

    while (q--) {
        ll l, r;
        cin >> l >> r;
        l--;
        r--;
        cout << querySegmentTree(l, r, tree, 0, n-1, 1) << endl;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll n, q;
    cin >> n >> q;
    vector<ll> a(n);
    for (ll i = 0; i < n; i++) {
        cin >> a[i];
    }

    
    solveBySparseTable(q, a);

    // solveBySqrtDecomposition(q, a);

   // solveBySegmentTree(q, a);
}
