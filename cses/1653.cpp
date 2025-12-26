#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
typedef long long ll;
/*
15
4 8 6 1
1 4 6 8
Wrong Approach
n 6 

If I do binary search on the number of rides
if 2 rides

Right Approach
Think of recursive solution

1 
1 4
1 4 6

*/

ll findMinRides(ll persons, vector<ll>& weights, ll maxWeight) {
    pair<ll, ll> minRidesRequired[1 << persons];

    // dp[i] -> {rides, lastRideWeight} represents the 
    // minimum number of rides required to transport persons in combination i
    // with the last ride having a weight of lastRideWeight
    minRidesRequired[0] = {0, maxWeight + 1};

    for (ll combination = 1; combination < (1 << persons); combination++) {
        minRidesRequired[combination] = {21, 0};
        
        for (ll person = 0; person < persons; ++person) {
            if (combination & (1 << person)) {
                
                auto [minRides, lastRideWeight] = minRidesRequired[combination ^ (1 << person)];
                
                if (lastRideWeight + weights[person] <= maxWeight) {
                    lastRideWeight += weights[person];
                } else {
                    minRides++;
                    lastRideWeight = min(lastRideWeight, weights[person]);
                }

                minRidesRequired[combination] = min(minRidesRequired[combination], {minRides, lastRideWeight});
            }
        }
    }

    return minRidesRequired[(1 << persons) - 1].first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll persons, maxWeight;
    cin >> persons >> maxWeight;
    vector<ll> weights(persons);
    for (ll& weight: weights) {
        cin >> weight;
    }
    cout << findMinRides(persons, weights, maxWeight) << endl;
}