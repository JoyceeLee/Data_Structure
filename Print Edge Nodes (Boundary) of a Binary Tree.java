/**
* Print all edge nodes of a complete binary tree anti-clockwise.
* That is all the left most nodes starting at root, then the leaves left to right and finally all the rightmost nodes.
* In other words, print the boundary of the tree.
*
* Variant: Print the same for a tree that is not complete.
*/

/**
* a modified recursive definition for left-most node (similar for right-most node):
* - If a node is a left-most node, then its left child must be a left-most node as well.
* - If its left child does not exist, then its right child will be a left-most node.
*/


public class Solution {
    public ArrayList<Integer> edgeNodes(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null) return null;
        ret.add(root);
        leftEdges(root.left, ret, true);
        rightEdges(root.right, ret, true);
        return ret;
    }
    public void leftEdges(TreeNode cur, ArrayList<Integer> ret, boolean isLeft) {
        if(cur==null) return;
        if(isLeft || (cur.left==null && cur.right==null) ) {
            ret.add(cur.val);
        }
        leftEdges(cur.left, ret, isLeft);
        leftEdges(cur.right, ret, (isLeft && cur.left==null ? true : false));
    }
    public void rightEdges(TreeNode cur, ArrayList<Integer> ret, boolean isRight) {
        if(root==null) return;
        rightEdges(cur.left, ret, (isRight && cur.right==null ? true : false));
        rightEdges(cur.right, ret, isRight);
        if(isRight || (cur.left==null && cur.right==null) ) {
            ret.add(cur.val);
        }
    }
}
