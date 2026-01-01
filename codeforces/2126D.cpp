#include <bits/stdc++.h>
#define ll long long int
using namespace std;

ll solve() {
    ll noOfCasinos, initialCoins;
    cin >> noOfCasinos >> initialCoins;
    
    vector<vector<ll>> casinos(noOfCasinos);

    for (ll i = 0; i < noOfCasinos; i++) {
        ll l, r, real;
        cin >> l >> r >> real;
        casinos[i].push_back(l);
        casinos[i].push_back(r);
        casinos[i].push_back(real);
    
    }

    sort(casinos.begin(), casinos.end());
    for (ll i = 0; i < noOfCasinos; i++) {
        
        // if I can get the coin with this casino
        if (initialCoins >= casinos[i][0] 
            && initialCoins <= casinos[i][1]) {
            initialCoins = max(initialCoins, casinos[i][2]);
        }
    }

    
    return initialCoins;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll tests;
    cin >> tests;
    while (tests--) {
        cout << solve() << endl;
    }
    return 0;
}