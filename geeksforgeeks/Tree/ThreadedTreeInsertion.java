/*
Threaded Binary Trees
Optimize wasted memory on null pointers to point to in-order, preorder, post-order
successor or predecessor for efficient traversal
*/

class Node {
    int data;
    Node left, right;
    boolean lThread, rThread; // true if pointer is a thread, false if it is a child

    public Node(int data) {
        this.data = data;
        this.lThread = true; 
        this.rThread = true;
    }
};

public Node insert(Node root, int key) {
    Node curr = root;
    Node parent = null;

    // Standard BST search logic
    while (curr != null) {
        if (key == curr.data) {
            return root;  // duplicate no need to insert
        }
        parent = curr; 
        if (key < curr.data) {
            if (!curr.lThread) curr = curr.left; 
            else break;
        } else {
            if (!curr.rThread) curr = curr.right;
            else break;
        }
    }

    Node newNode = new Node(key);
    if (parent == null) {
        root = newNode;
    } else if (key < parent.data) {
        newNode.left = parent.left; 
        newNode.right = parent;
        parent.lThread = false;
        parent.left = newNode;
    } else {
        newNode.right = parent.right;
        newNode.left = parent;
        parent.rThread = false; 
        parent.right = newNode; 
    }

    return root;
}

