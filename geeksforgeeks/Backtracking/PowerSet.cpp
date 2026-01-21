/*
problem: https://www.geeksforgeeks.org/problems/power-set4302/1
author: parag kumar goyal
*/

class Solution {
  public:
    void generateAllSubseq(string& s, int idx, string& subseq, 
        vector<string>& allSubseq) {
        allSubseq.push_back(subseq);
        
        
        for (int i = idx, n = s.length(); i < n; ++i) {
            subseq.push_back(s[i]);
            generateAllSubseq(s, i + 1, subseq, allSubseq);
            subseq.pop_back();
        }
    }
  
    vector<string> AllPossibleStrings(string s) {
        // Code here
        string subseq = "";
        int n = s.length();
        vector<string> allSubsequences;
        allSubsequences.reserve((1 << n));
        generateAllSubseq(s, 0, subseq, allSubsequences);
        sort(allSubsequences.begin(), allSubsequences.end());
        return allSubsequences;
    }
};