/*
problem - https://codeforces.com/problemset/problem/1794/C
author - parag kumar goyal
*/

void findCost() {
    ll n;
    cin >> n;
    vector<ll> a(n);
    for (ll i = 0; i < n; ++i) {
        cin >> a[i];
    } 

    /*
    score = s1.s2.s3..sd/1.2...d 
    m - maximum score for any subsequence in the sequence
    cost is the maximum length of a subsequence with score m 
    [a1, a2, a3, .. an] 
    a1 <= a2 <= a3 <= ... an 
    find the cost for sequences of length 1, 2, .. n

    1, 2, 3 
    1
    1, 2
    1, 2, 3 

    1, 1, 2

    1, 1, 1 

    1, 1

    5, 5, 5, 5, 5
    1, 2, 3, 4, 5 

    1, 2, 3, 4, 5 
    1, 1, 2, 3, 3

    1, 1, 1, 1, 1
    1, 2, 2 
    >= 2 

    1, 2, 3 
    >= 2

    if new character is 1 
    then the cost is 1 

    new character is 2 and the previous cost is 2 
    1, 1, 2, 2 
    1, 1, 1, 2

    for a current character how many characters I can go back

    for i = 1 to n 
        for j=i..1 calculate the max score and max length
    

    if I have the cost for a previous seq
    for the current seq the 

    1, 2, 3, 4, 5
    5 - 1
    10 - 2
    10 - 3 
    5 - 4 

    can cost decrease 

    1, 2, 3, 4, 4

    1, 1, 2, 2, 3

    Why the cost will never decrease ? 
    2 
    a0.a1 >= a1.2
    a0 >= 2
    cost 2 
    a2.a1.a0/2 > 
    cost k 
    seq will start with >= k 
    binary search on cost 2 - n 
    4 
    that happens if the starting element is greater than or equal to cost
    for index i 
    binary search on cost prevCost - n
    for checking a particular cost check if the arr[i-cost] >= cost
    
    3*2/2


    4*3*2/1*2*3 = 4
    4*3/2 = 6

    */
    ll prevCost = 1;
    for (ll idx = 0; idx < n; ++idx) {
        
        ll minCost = prevCost;
        ll resCost = minCost;
        ll maxCost = idx + 1;
        
        // 2 
        // 1 
        // 1 
        
        while (minCost <= maxCost) {
            ll midCost = minCost + (maxCost - minCost)/2;
            if (midCost - 1 <= idx && a[idx - midCost + 1] >= midCost) {
                minCost = midCost + 1;
                resCost = midCost;
            } else {
                maxCost = midCost - 1;
            }
        }
        
        prevCost = resCost;
        cout << resCost << " ";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ll tests;
    cin >> tests;

    while (tests--) {
        findCost();
        cout << endl;
    }

    return 0;
}