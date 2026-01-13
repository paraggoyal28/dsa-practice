/*
problem: https://cses.fi/problemset/task/1652
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

int main() {
    /*
    optimizing the input and output
    */
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll size, queries;
    cin >> size >> queries;

    vector<vector<ll>> forest(size, vector<ll>(size, 0));
    char forst;
    for (ll row = 0;row < size; ++row) {
        for (ll col = 0; col < size; ++col) {
            cin >> forst;
            if (forst == '*)') {
                forest[row][col] = 1;
            }
        }
    }

    vector<vector<ll>> prefixSum(forest);

    for (ll row = 0; row < size; ++row) {
        for (ll col = 0; col < size; ++col) {
            if (row == 0 && col == 0) {
                continue;
            }
            if (row > 0 && col > 0) {
                prefixSum[row][col] += prefixSum[row-1][col] + prefixSum[row][col-1] 
                    - prefixSum[row-1][col-1];
            } else if (row > 0) {
                prefixSum[row][col] += prefixSum[row-1][col];
            } else {
                prefixSum[row][col] += prefixSum[row][col-1];
            }
        }
    }

    while (queries--) {
        ll y1, x1, y2, x2;
        cin >> y1 >> x1 >> y2 >> x2;
        
        ll numberOfTrees = prefixSum[y1][x1];
        if (y1 == 0 && x1 == 0) continue;

        if (y1 > 0 && x1 > 0) {
            numberOfTrees = numberOfTrees - prefixSum[y1-1][x1]
                - prefixSum[y1][x1-1] + prefixSum[y1-1][x1-1];
        }

        else if (x1 > 0) {
            numberOfTrees = numberOfTrees - prefixSum[y1][x1-1];
        }

        else {
            numberOfTrees = numberOfTrees - prefixSum[y1-1][x1];
        }

        cout << numberOfTrees << endl;
    }

    return 0;
}