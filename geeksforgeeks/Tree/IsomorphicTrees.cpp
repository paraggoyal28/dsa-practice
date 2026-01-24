/*
problem: https://www.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
author: parag kumar goyal 

Recursive Approach
TC: O(2^N) where N is the number of nodes
SC: O(H) where H is the height of tree

String rep
TC: O(N^2) where N is the number of nodes
SC: O(N^2) where N is the number of nodes

Integer Hashing
TC: O(NlogN) where N is the number of nodes
SC: O(N) where N is the number of nodes

Integer Hashing with unordered_map
TC: O(N)
SC: O(N)

*/

struct Node {
    int val;
    Node* left, right; 
    Node(int val) {
        this->val = val;
        this->left = NULL;
        this->right = NULL;
    }
};

/* Recursive Approach */
class Solution {

    bool isIsomorphic(Node* root1, Node* root2) {
        if (root1 == NULL && root2 == NULL) {
            return true;
        }

        if (!root1 || !root2 || root1->val != root2->val) {
            return false;
        }

        return (isIsomorphic(root1->left, root2->left) && 
                isIsomorphic(root1->right, root2->right)) || 
                (isIsomorphic(root1->left, root2->right) && 
                isIsomorphic(root1->right, root2->left));
    }
} 



/* String Hashing Approach */
class Solution {
  public:
    string findCanonicalForm(Node* root) {
        if (root == NULL) {
            return "#";
        }
        
        string leftCanonicalForm = findCanonicalForm(root->left);
        string rightCanonicalForm = findCanonicalForm(root->right);
        
        // sort the (leftCanonicalForm, rightCanonicalForm)
        // to handle the (left, right) case
        if (leftCanonicalForm > rightCanonicalForm) {
            swap(leftCanonicalForm, rightCanonicalForm);
        }
        
        return to_string(root->data) + "(" + 
            leftCanonicalForm + "," + 
            rightCanonicalForm + ")";
    }
  
    // Return True if the given trees are isomotphic. Else return False.
    bool isIsomorphic(Node *root1, Node *root2) {
        return findCanonicalForm(root1) == findCanonicalForm(root2);
    }
};

/* Integer based hashing approach */

class Solution {
    map<vector<int>, int> structureToId;
    int idCounter = 0;

public:

    int getTreeId(Node* root) {
        if (root == nullptr) return -1;

        int leftId = getTreeId(root->left);
        int rightId = getTreeId(root->right);

        int minId = min(leftId, rightId);
        int maxId = max(leftId, rightId);

        vector<int> signature = {root->data, minId, maxId};

        if (structureToId.find(signature) == structureToId.end()) {
            structureToId[signature] = idCounter++;
        }

        return structureToId[signature];
    }

    bool isIsomorphic(Node* root1, Node* root2) {
        structureToId.clear();

        idCounter = 0;

        return getTreeId(root1) == getTreeId(root2);
    }
}

// Custom hasher for a vector of 3 integers
/*
Why the Hash Formula Matters
The line seed ^= hash(x) + 0x9e3779b9 + (seed << 6) + (seed >> 2); looks like magic, but it serves a vital purpose:

0x9e3779b9: This is the "Golden Ratio" constant. It helps distribute the bits evenly so that even similar inputs (like {1, 0, 1} and {1, 1, 0}) produce very different hash values.

Bit Shifting: << 6 and >> 2 ensure that the hash of the first element affects all parts of the final seed, not just one section.
*/
struct VectorHasher {
    size_t operator()(const std::vector<int>& v) const {
        size_t seed = 0;
        for (int x : v) {
            // A common bit-mixing formula to combine hashes
            seed ^= std::hash<int>{}(x) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
        }
        return seed;
    }
};

/* Unordered Map TC: O(n) SC: O(n) */
class Solution {
    unordered_map<vector<int>, int, VectorHasher> structureToId;
    int idCounter = 0;

public:

    int getTreeId(Node* root) {
        if (root == nullptr) return -1;

        int leftId = getTreeId(root->left);
        int rightId = getTreeId(root->right);

        int minId = min(leftId, rightId);
        int maxId = max(leftId, rightId);

        vector<int> signature = {root->data, minId, maxId};

        if (structureToId.find(signature) == structureToId.end()) {
            structureToId[signature] = idCounter++;
        }

        return structureToId[signature];
    }

    bool isIsomorphic(Node* root1, Node* root2) {
        structureToId.clear();

        idCounter = 0;

        return getTreeId(root1) == getTreeId(root2);
    }
}