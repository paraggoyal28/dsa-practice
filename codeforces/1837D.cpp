/*
problem: https://codeforces.com/problemset/problem/1837/D
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

void solve() {
    ll n; 
    cin >> n;
    
    string str;
    cin >> str;
    
    vector<ll> bal(n+1, 0);

    for (ll itr = 0; itr < n; ++itr) {
        if (str[itr] == '(') { // increment balance if found open bracket
            bal[itr+1] = bal[itr] + 1;
        } else {
            bal[itr+1] = bal[itr] - 1;
        }
    }

    if (bal[n] != 0) {
        cout << "-1\n";
        return;
    }

    if (*min_element(bal.begin(), bal.end()) == 0 || *max_element(bal.begin(), bal.end()) == 0) {
        cout << 1 << endl;

        for (ll itr = 0; itr < n; ++itr) {
            if (itr) cout << " ";
            cout << 1;
        }
        cout << endl;
        return;
    } 

    cout << 2 << endl;

    vector<ll> ans;
    ll itr = 0;

    while (itr < n) {
        // identify Regular if start is open else Reversed Regular
        ll w = (str[itr] == '(' ? 1 : 2);

        do {
            itr++;
            ans.push_back(w);
        } while (bal[itr] != 0);
    }

    for (itr = 0; itr < n; ++itr) {
        if (itr) cout << " ";
        cout << ans[itr];
    }
    cout << endl;
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