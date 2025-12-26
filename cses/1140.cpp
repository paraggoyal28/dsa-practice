#include <bits/stdc++.h>
using namespace std;

struct Project {
    long long a, b, p;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<Project> v(n);
    for (int i = 0; i < n; i++) cin >> v[i].a >> v[i].b >> v[i].p;

    // Sort by project end time
    sort(v.begin(), v.end(), [](Project &x, Project &y){
        return x.b < y.b;
    });

    vector<long long> dp(n);
    vector<long long> endTimes(n);
    for (int i = 0; i < n; i++) endTimes[i] = v[i].b;

    for (int i = 0; i < n; i++) {
        long long include = v[i].p;

        // Find latest project that ends < v[i].a
        int j = upper_bound(endTimes.begin(), endTimes.end(), v[i].a - 1) - endTimes.begin() - 1;

        if (j >= 0) include += dp[j];

        long long exclude = (i == 0 ? 0 : dp[i - 1]);

        dp[i] = max(include, exclude);
    }

    cout << dp[n - 1] << "\n";
}