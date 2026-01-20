/*
problem: https://www.geeksforgeeks.org/problems/implement-undo-redo/1
author: parag kumar goyal
SC: O(n)
TC: O(n)
*/

#include <iostream>
#include <vector>
using namespace std; 

class Solution {
  public:
    stack<char> undoneChars;
    string res = "";
    void append(char x) {
        // append x into document
        res.push_back(x);
    }

    void undo() {
        // undo last change
        if (res.empty()) return;
        char last = res.back();
        res.pop_back();
        undoneChars.push(last);
    }

    void redo() {
        // redo changes
        if (undoneChars.empty()) {
            return;
        }
        
        res.push_back(undoneChars.top());
        undoneChars.pop();
    }

    string read() {
        // read the document
        return res;
    }
};