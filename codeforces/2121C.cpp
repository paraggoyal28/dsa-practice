/*
problem: https://codeforces.com/problemset/problem/2121/C
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int 
using namespace std;

ll findMinimumMaxValue() {
    ll rows, cols;
    cin >> rows >> cols;

    vector<vector<ll>> matrix(rows, vector<ll>(cols));

    ll maxElement = 0;
    ll maxElementCnt = 0;
    vector<ll> rowCount(rows, 0);
    vector<ll> colCount(cols, 0);

    for (ll row = 0; row < rows; ++row) {
        for (ll col = 0; col < cols; ++col) {
            cin >> matrix[row][col];
            maxElement = max(maxElement, matrix[row][col]);
        }
    }

    /*
    find the point whose row or col matches the row or col of all the maximum values
    add the row and col of all the maximum values to a set rows and a set cols
     now for each point if its row is in the 

    for each point we can check if its row is covers all the max points
    (1, 0) r[1]=2, r[0]=1, r[2]=1
    (1, 3) c[0]=1, c[2]=2, c[3]=1
    (0, 2)
    (2, 2)

    for all such points if I get the common

    (0, 1)
    (3, 1)
    (2, 0)
    (2, 1)
    (2, 2)

    (0, 1)
    (1, 0)
    (2, 1)

    (0, 1) r[0]=2, c[1]=3, c[2]=1, c[0]=1, c[3]=1, r[3]=3, r[1]=1
    (0, 2) 
    (1, 1)
    (3, 1)
    (3, 0)
    (3, 3)
    
    */

    for (ll row = 0;row < rows; ++row) {
        for (ll col = 0; col < cols; ++col) {
            if (matrix[row][col] == maxElement) {
                rowCount[row]++;
                colCount[col]++;
                maxElementCnt++;
            }
        }
    }

    for (ll row = 0; row < rows; ++row) {
        for (ll col = 0; col < cols; ++col) {
            if (rowCount[row] + colCount[col] == 
                    maxElementCnt - (matrix[row][col] == maxElement ? 1 : 0)) {
                return maxElement - 1;
            }
        }
    }

    return maxElement;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll tests;
    cin >> tests;

    while (tests--) {
        cout << findMinimumMaxValue() << endl;
    }


    return 0;
}