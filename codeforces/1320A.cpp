/*
problem: https://codeforces.com/problemset/problem/1320/A
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll cities;
    cin >> cities;

    vector<ll> beautyValues(cities);

    unordered_map<ll, ll> beautyValuesGrp;
    ll maxBeautyValue = 0;

    for (ll itr = 0; itr < cities; ++itr) {
        cin >> beautyValues[itr];
        beautyValues[itr] -= itr;
    }

    for (ll itr = 0; itr < cities; ++itr) {
        beautyValuesGrp[beautyValues[itr]]
            += beautyValues[itr] + itr;
        maxBeautyValue = max(maxBeautyValue,
            beautyValuesGrp[beautyValues[itr]]);
    }

    cout << maxBeautyValue << endl;
    return 0;
}