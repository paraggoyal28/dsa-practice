/*
problem: https://cses.fi/problemset/task/1143
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long 
using namespace std;

class SegmentTree {
public:
    // tree stores the max value in a range
    vector<ll> tree;
    ll size;

    SegmentTree(ll n) {
        this->size = n;
        this->tree.resize(this->size, 0);
    }

    void build(vector<ll>& rooms, ll st, ll end, ll node) {
        if (st == end) {
            tree[node] = st;
            return;
        }

        ll mid = st + (end - st)/2;
        build(rooms, st, mid, 2*node);
        build(rooms, mid+1, end, 2*node+1);
        tree[node] = max(tree[2*node], tree[2*node+1]);
    }

    ll findAndUpdate(ll st, ll end, ll node, ll x) {
        if (st == end) {
            tree[node] -= x;
            return st; 
        }

        ll mid = st + (end - st)/2;
        ll res;
        if (tree[mid] >= x) {
            res = findAndUpdate(st, mid, 2 * node, x);
        } else {
            res = findAndUpdate(mid + 1, end, 2 * node + 1, x);
        }

        tree[node] = max(tree[2*node], tree[2*node+1]);
        return res;
    }

};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // for each group
    // we can iterate over all hotels
    // O(n*m)
    // least index which has the 

    // can we use segment tree
    // update reduce the free rooms
    // query the least index 

    // segment tree each node stores the maximum of the range
    // by storing the maximum value we are sure if this range 
    // has the max value less than the required rooms asked
    // we can move to the next range

    ll noOfHotels, noOfGroups;
    cin >> noOfHotels >> noOfGroups;

    vector<ll> freeRooms(noOfHotels+1);

    SegmentTree* sgTree = new SegmentTree(noOfHotes);


    for (ll i = 1; i <= noOfHotels; ++i) {
        cin >> freeRooms[i];
    }

    sgTree->build(freeRooms, 1, noOfHotels, 1);

    while (noOfGroups--) {
        ll groupSize;
        cin >> groupSize;

        ll minIndex = sgTree->findAndUpdate(1, noOfHotels, 1, groupSize);

        cout << minIndex << " ";

        freeRooms[minIndex] -= groupSize;
    }

    cout << endl;

    return 0;
}