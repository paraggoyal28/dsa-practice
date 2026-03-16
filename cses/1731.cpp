/*
problem: https://cses.fi/problemset/task/1731
author: parag kumar goyal
*/

#include <bits/stdc++.h>
#define ll long long int
#define MOD 1000000007
using namespace std;

ll findNumberOfWays(string str, unordered_set<string>& dictionary) {
    /*
    dp[i] = number of ways to partition str with given words
    dp[n] will be the ans
    dp[i] = for a word as. a substr (j..i) add all dp[j]
    ababc
    4
    ab
    abab
    c
    cb

    abab
    dp[0] = 1
    dp[1] = 0
    dp[2] = 
    */
    int len = str.length();
    vector<ll> ways(len+1, 0);
    vector<ll> prevIdx;
    prevIdx.push_back(0);
    ways[0] = 1;
    for (int itr = 1; itr <= len; ++itr) {
        for (int prev: prevIdx) {
            string substr = str.substr(prev, itr - prev);
            if (dictionary.find(substr) != dictionary.end()) {
                ways[itr] += ways[prev];
            }
        }
        if (ways[itr] > 0) {
            prevIdx.push_back(itr);
        }
    }

    return ways[len];
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    string str;
    cin >> str; 
    
    ll k;
    cin >> k;

    unordered_set<string> dictionary;
    string word;
    for (ll i = 0;i < k; ++i) {
        cin >> word;
        dictionary.insert(word);
    }

    cout << findNumberOfWays(str, dictionary) << endl;
    return 0;
}