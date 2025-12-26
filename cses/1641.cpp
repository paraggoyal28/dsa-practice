#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    ll size, targetSum;
    cin >> size >> targetSum;

    vector<pair<ll, ll>> arr(size);
    for(ll i = 0; i < size; i++) {
        ll num;
        cin >> num;
        arr[i] = {num, i+1};
    }

    sort(arr.begin(), arr.end());

    for (ll i = 0; i < size-2; ++i) {
        ll j = i + 1;
        ll k = size - 1;
        while (j < k) {
            if (arr[i].first + arr[j].first + arr[k].first == targetSum) {
                cout << arr[i].second << " " << arr[j].second 
                    << " " << arr[k].second << endl;
                return 0;
            }
            else if (arr[i].first + arr[j].first + arr[k].first < targetSum) {
                j++;
            }
            else {
                k--;
            }
        }
    }
    cout << "IMPOSSIBLE\n";
    return 0;
}
