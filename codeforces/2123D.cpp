/*
problem: https://codeforces.com/problemset/problem/2123/D
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int 
using namespace std;

void solve() {
    ll n, k; 
    cin >> n >> k;

    string str;
    cin >> str;
    
    ll cnt = 0;
    for (ll itr = 0; itr < n; ++itr) {
        if (str[itr] == '1') {
            cnt++;
        }
    }

    cout << ((cnt <= k || n < 2 * k) ? "Alice" : "Bob") << endl;
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
