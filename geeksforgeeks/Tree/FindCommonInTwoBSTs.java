/*
problem: https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
author: parag kumar goyal
TC: O(N+M)
SC: O(N+M) where N is the size of tree1 and M is the size of tree2
*/

/*
The Issue: Integer Reference Comparison
In Java, ArrayList<Integer> stores Integer objects, not primitive int values.

In your findCommon helper:

Java
if (inorder1.get(i) == inorder2.get(j)) { ... }
The == operator checks for reference equality (if they are the exact same object 
in memory), not value equality.

Java caches Integer objects for values between -128 and 127. For these numbers, == works 
because they point to the same cached object. But for any number outside that 
range (like 150 or 1000), Java creates a new object, and == will return false 
even if the values are identical.

The Fix
Use the .equals() method or compare their primitive values:

Java
if (inorder1.get(i).equals(inorder2.get(j))) { // Safe for all values
// OR
if ((int)inorder1.get(i) == (int)inorder2.get(j)) { // Unboxing to primitive

*/

class Solution {
    
    private static ArrayList<Integer> findCommon(ArrayList<Integer> inorder1, 
                                                ArrayList<Integer> inorder2) {
        int n = inorder1.size();
        int m = inorder2.size();
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < n && j < m) {
            if ((int)inorder1.get(i) == (int)inorder2.get(j)) {
                res.add(inorder1.get(i));
                i++;
                j++;
            } else if (inorder1.get(i) < inorder2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return res;
    }
    
    
    private static void findInorder(Node root, ArrayList<Integer> inorder) {
        if (root != null) {
            findInorder(root.left, inorder);
            inorder.add(root.data);
            findInorder(root.right, inorder);
        }
    }
    
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        findInorder(r1, inorder1);
        findInorder(r2, inorder2);
        
        return findCommon(inorder1, inorder2);
    }
}