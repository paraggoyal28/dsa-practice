/*
problem: https://www.geeksforgeeks.org/problems/next-element-with-greater-frequency--170637/1
author: parag kumar goyal

Given an array arr[] of integers, for each element, find the first element to its right that has a higher frequency than the current element.
If no such element exists, return -1 for that position.
Examples:
Input: arr[] = [2, 1, 1, 3, 2, 1]
Output: [1, -1, -1, 2, 1, -1]
Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
For arr[0] = 2, the next element 1 has a higher frequency → 1.
For arr[1] and arr[2], no element to the right has a higher frequency → -1.
For arr[3] = 3, the next element 2 has a higher frequency → 2.
For arr[4] = 2, the next element 1 has a higher frequency → 1.
For arr[5] = 1, no elements to the right → -1.

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^5
*/

#include <iostream>
#include <vector>
using namespace std;

vector<int> findNextGreater(vector<int>& nums) {

    unordered_map<int, int> freq;
    int sz = (int) arr.size();
    for (int num: arr) {
        freq[num]++;
    }
    vector<int> nextGreaterFrequencyElement(sz, -1);
    stack<int> decreasingFreqNums;

    decreasingFreqNums.push(arr[sz-1]);

    for (int idx = sz-2; idx >= 0; --idx) {
        while (!decreasingFreqNums.empty() && 
            freq[decreasingFreqNums.top()] <= freq[arr[idx]]) {
            decreasingFreqNums.pop();
        }

        if (!decreasingFreqNums.empty()) {
            nextGreaterFrequencyElement[idx] = decreasingFreqNums.top();
        }

        decreasingFreqNums.push(arr[idx]);
    }

    return nextGreaterFrequencyElement;
}

void print(vector<int>& nums) {
    for (int num: nums) {
        cout << num << " ";
    }
    cout << endl;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    vector<int> nums = {2, 1, 1, 3, 2, 1};

    vector<int> nextGreaterFrequencyNums = findNextGreater(nums);

    print(nextGreaterFrequencyNums);

    return 0;
}