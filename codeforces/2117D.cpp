/*
problem: https://codeforces.com/problemset/problem/2117/D
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

string canExplode(vector<ll>& a) {
    ll n = a.size();

    /*
    for each index can reduce a[i] by i 
    or by n - i + 1
    so if a[i]%i == 0 || a[i]%(n-i+1) == 0 || a[i]%(n+1) == 0 
 
    5 
    21 18 15 12 9 
    1 2 3 4 5
    5 4 3 2 1 

    x + y5 = 21 
    2x + 4y = 18 

    x - y = -3
    6y = 24 
    y = 4 

    x = 1 

    3 6 6 3 
    x + 4y = 3
    2x + 3y = 6
    x - y = 3

    5y = 0
    y = 0
    x = 3 
    4x = 

    
    52 101
    x + 2y = 52
    2x + y = 101

    x - y = 49
    x + (n)y = a[0]
    x - y = a[1] - a[0]

    (n+1)y = 2*a[0] - a[1]

    x = a[0] - n*y
    if x and y satisfy all elements then yes else no

    */

    ll y = (2 * a[0] - a[1])/(n+1);
    
    ll x = a[0] - n * y;
    
    if (x < 0 || y < 0) return "NO";

    for (ll i = 1; i <= n; ++i) {
        if (a[i-1] != (x * i + y * (n - i + 1))) {
            return "NO";
        }
    }
    return "YES";
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
        
        vector<ll> a(n); 

        for (ll i = 0; i < n; ++i) {
            cin >> a[i];
        }

        cout << canExplode(a) << endl;
    }

    return 0;
}
