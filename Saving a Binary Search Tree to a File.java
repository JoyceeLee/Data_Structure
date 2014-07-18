/**
* Describe an algorithm to save a Binary Search Tree (BST) to a file in terms of run-time and disk space complexity. 
* You must be able to restore to the exact original BST using the saved format.
*/

/**
* in-order traversal : no idea about the original tree
* post-order traversal : trable in construct sub-tree before its parent
* pre-order traversal : good idea
*/

// rebuild BST from pre-order array
class Idx {
    int data;
    public Idx(int data) {
        this.data = data;
    }
}
public class Solution {
    public TreeNode readBST(int[] A) {
        TreeNode root = null;
        Idx idx = new Idx(0);
        helper(idx, A, root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    public void helper(Idx idx, int[] A, TreeNode cur, int min, int max){
        if(idx.data<A.length && A[idx.data]>min && A[idx.data]<max) {
            cur = new TreeNode(A[idx]);
            if(++idx.data<A.length) {
                helper(idx, A, cur.left, min, cur.val);
                helper(idx, A, cur.right, cur.val, max);
            }
        }
    }
}
