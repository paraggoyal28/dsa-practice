/*
problem: https://codeforces.com/problemset/problem/2117/C
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

ll maxNumberOfSegments(vector<ll>& arr, ll n) {
    /*
    first segment to be a[0]
    then iterate till found a[0].. 
    keep track of all the numbers 
    now move again to the next iteration of a[0]
    and check if each element is in the set of visited
    keep a track of the group for each element in a map prevSet has all element
    
    */

    vector<ll> segmentNo(n+1, 0);
    segmentNo[arr[0]] = 1;
    ll prevGroupCnt = 1;
    ll currentGroupCnt = 0;
    ll groupNumber = 2;
    ll totalGroups = 1;
    for (ll itr = 1; itr < n; ++itr) {
        if (segmentNo[arr[itr]] == groupNumber - 1) {
            prevGroupCnt -= 1; 
        } 
        
        segmentNo[arr[itr]] = groupNumber;
        currentGroupCnt += 1;

        if (prevGroupCnt == 0) {
            prevGroupCnt = currentGroupCnt;
            groupNumber += 1;
            totalGroups++;
        }
    }

    return totalGroups;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll tests;
    cin >> tests;

    while (tests--) {
        ll n; 
        cin >> n;
        
        vector<ll> arr(n);
        for (ll i = 0;i < n; ++i) {
            cin >> arr[i];
        }

        cout << maxNumberOfSegments(arr, n) << endl;
    }

    return 0;
}