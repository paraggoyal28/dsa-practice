/*
problem: https://cses.fi/problemset/task/3405
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

    //1. Generate elements
    vector<int> elements(n);
    elements[0] = (int) start;
    for (int i = 1; i < n; ++i) {
        elements[i] = (int)((1LL * elements[i-1] * a + b) % c);
    }

    // 2. Precompute prefix and suffix ORs within blocks of size k

    vector<int> pref(n), suf(n);

    for (int i = 0;i < n; ++i) {
        if (i%k == 0) pref[i] = elements[i];
        else pref[i] = pref[i-1] | elements[i];
    }

    for (int i = n-1; i >= 0; --i) {
        if ((i+1)%k == 0 || i == n-1) suf[i] = elements[i];
        else suf[i] = suf[i+1] | elements[i];
    }

    // 3. Calculate Xor of all window ORs
    ll total_xor = 0;

    // A window of length k starting at i and ending at i + k - 1
    for (int i = 0; i <= n-k; ++i) {
        ll L = i;
        ll R = i + k - 1;

        // The OR of range [L, R] is (OR of suffix of block containing L) 
        // | (OR of prefix of block containing R)
        int window_or = suf[L] | pref[R];

        total_xor ^= window_or;
    }

    cout << total_xor << endl;

    return 0;
}

/*
Example:
Imagine K=4 and you want the OR of elements from index 2 to 5:
Block 1: [0, 1, 2, 3] -> suff[2] gives OR of [2, 3]
Block 2: [4, 5, 6, 7] -> pref[5] gives OR of [4, 5]
suff[2] | pref[5] gives the OR of [2, 3, 4, 5], which is your window!

*/