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

    sort(casinos.begin(), casinos.end(), [](vector<ll>& casino1, vector<ll>& casino2) {
        return casino1[0] == casino2[0] ? casino1[1] < casino2[1] : casino1[0] < casino2[0];
    });

    for (ll i = 0; i < noOfCasinos; i++) {
        // if I don't gain any coin with this casino I skip it
        if (casinos[i][2] <= initialCoins) {
            continue;
        }
        // if I can get the coin with this casino
        if (initialCoins >= casinos[i][0] 
            && initialCoins <= casinos[i][1]) {
            initialCoins = casinos[i][2];
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