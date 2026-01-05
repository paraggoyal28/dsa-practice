/*
problem: https://codeforces.com/problemset/problem/1907/D
author: parag kumar goyal

*/


#include <bits/stdc++.h>
#define ll long long int
using namespace std;

bool possible(vector<pair<ll, ll>>& segments, ll k) {
    ll lower = 0, higher = 0;
    for (pair<ll, ll>& segment: segments) {
        lower = max(lower - k, segment.first);
        higher = min(higher + k, segment.second);
        if (lower > higher) {
            return false;
        }
    }
    return true;
}

void solve() {
    ll noOfSegments;
    cin >> noOfSegments;
    vector<pair<ll, ll>> segments;
    for (ll itr = 0; itr < noOfSegments; ++itr) {
        ll l, r;
        cin >> l >> r;
        segments.push_back({l, r});
    }

    ll minK = -1, maxK = 1000000000, res = 0;
    while (maxK >= minK) {
        ll mid = (maxK + minK)/2;
        if (possible(segments, mid)) {
            res = mid;
            maxK = mid - 1;
        } else {
            minK = mid + 1;
        }
    }

    cout << maxK << endl;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll tests;
    cin >> tests;
    while (tests--) {
        solve();
    }

    return 0;
}

