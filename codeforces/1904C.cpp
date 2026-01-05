/*
problem: https://codeforces.com/problemset/problem/1904/C
author: parag kumar goyal

*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

/* for 3 or above operations ans is 0 */
void solve() {
    ll n, k;
    cin >> n >> k; 
    vector<ll> a(n);
    for (ll& element: a) {
        cin >> element;
    } 

    if (k >= 3) {
        cout << "0\n";
        return;
    }

    ll minDiff = *min_element(a.begin(), a.end());
    vector<ll> differences;
    
    for (ll itr1 = 0; itr1 < n; ++itr1) {
        for (ll itr2 = itr1 + 1; itr2 < n; ++itr2) {
            minDiff = min(minDiff, abs(a[itr1] - a[itr2]));
            differences.push_back(abs(a[itr1] - a[itr2]));
        }
    }

    if (k == 1) {
        cout << minDiff << endl;
        return;
    }
    sort(a.begin(), a.end());

    for (ll i = 0, m = differences.size(); i < m; ++i) {
      // for each difference calculate the second min difference
        ll lower_bnd = lower_bound(a.begin(), a.end(), differences[i]) - a.begin();
        if (lower_bnd > 0) {
          ll lower_value = a[lower_bnd-1];
          minDiff = min(minDiff, abs(lower_value - differences[i]));
        }
        if (lower_bnd < n)  {
          ll higher_value = a[lower_bnd];
          minDiff = min(minDiff, abs(higher_value - differences[i]));
        }
    }

    cout << minDiff << endl;
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
