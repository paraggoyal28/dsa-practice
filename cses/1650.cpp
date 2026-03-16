/*
problem: https://cses.fi/problemset/task/1650
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int 
using namespace std; 

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll n, queries;
    cin >> n >> queries;
    
    vector<ll> arr(n);

    for (ll i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    vector<ll> prefix(n);
    prefix[0] = arr[0];

    for (ll i = 1; i < n; ++i) {
        prefix[i] = prefix[i-1] ^ arr[i];
    }

    for (ll query = 0;query < queries; ++query) {
        cin >> l >> r; 
        l--;
        r--;
        ll sum = prefix[r];
        if (l > 0) {
            sum ^= prefix[l-1];
        }

        cout << sum << endl;
    }

    return 0;
}