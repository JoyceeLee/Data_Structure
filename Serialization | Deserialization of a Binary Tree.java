/**
* Design an algorithm and write code to serialize and deserialize a binary tree. 
* Writing the tree to a file is called ‘serialization’ and reading back from the file to 
* reconstruct the exact same binary tree is ‘deserialization’.
*/

/**
* Serialization is the process of converting a data structure or object into a sequence of bits 
* so that it can be stored in a file or memory buffer, or transmitted across a network connection 
* link to be “resurrected” later in the same or another computer environment.
*/


// Serialization
// pre-order traversal
public ArrayList<Character> writeBT(TreeNode root) {
    ArrayList<Character> ret = new ArrayList<Character>();
    writeBinaryTree(root, ret);
    return ret;
}
public void writeBinaryTree(TreeNode root, ArrayList<Character> ret) {
    if(root==null) {
        ret.add('#');
        return;
    } else {
        ret.add((char) root.val+'0');
        writeBinaryTree(root.left, ret);
        writeBinaryTree(root.right, ret);
    }
}


// Deserialization
class Idx {
    int data;
    public Idx(int data) {
        this.data = data;
    }
}
public TreeNode readBT(ArrayList<Character> str) {
    TreeNode root = null;
    readBinaryTree(root, str, new Idx(0));
}
public void readBinaryTree(TreeNode root, ArrayList<Character> str, Idx idx) {
    if(idx.data>str.size()) return;
    
    char cur = str.get(idx.data++);
    if(cur=='#') return;
    root = new TreeNode((int) cur-'0');
    
    readBinaryTree(root.left, str, idx);
    readBinaryTree(root.right, str, idx);
}
