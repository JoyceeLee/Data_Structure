/* Given a binary search tree (BST), find the lowest common ancestor of two given nodes in the BST. 
 http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-search-tree.html */


public class Solution {
    public LCAofBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) {
            return null;
        }
        if(!cover(p)||!cover(q))
            return null;
        if(Math.min(p.val, q.val)>root.val)
            return LCAofBST(root.right, p, q);
        if(Math.max(p.val, q.val)<root.val)
            return LCAofBST(root.left, p, q);
        return root;
    }
    public boolean cover(TreeNode root, TreeNode p) {
        if(root==null) return false;
        if(root==p) return true;
        return cover(root.left, p) || cover(root.right, p);
    }
}

/*
1. cover
    Time complexity : O(n) <DFS>
    Space complexity : O(log n)
2. LCAofBST
    Time complexity : O(log n) <DFS>
    Space complexity : O(log n)
*/
