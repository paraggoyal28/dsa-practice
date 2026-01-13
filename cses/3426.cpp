/*
problem: https://cses.fi/problemset/task/3426
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll n, k;
    cin >> n >> k;
    
    ll start, a, b, c;
    cin >> start >> a >> b >> c;
    

    vector<ll> elements;
    elements.push_back(start);
    ll xorValue = 0;
    ll prefixXorSum = 0;
    for (ll i = 1; i < n; ++i) {
        elements.push_back(((elements.back()%c * (a%c))%c + b%c + c)%c);
    }

    for (ll i = 0; i < k; ++i) {
        prefixXorSum ^= elements[i];
    }

    xorValue ^= prefixXorSum;

    for (ll i = k; i < n; ++i) {
        prefixXorSum ^= elements[i];
        prefixXorSum ^= elements[i-k];

        xorValue ^= prefixXorSum;
    }

    cout << xorValue << endl;

    return 0;
}