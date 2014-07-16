/*Given a binary tree, find the lowest common ancestor of two given nodes in the tree.*/

// Solution 1
// A Top-Down Approach ( Worst case O(n^2) ):
/*
Time Complexity
For balance tree : O(n)
    - countMatch : t(n) = O(n)
    - LCAofBT : T(n) = t(n) + t(n/2) + T(n/2)
                T(n) = O(n)
For degenerate tree (worst case) : O(n^2)
    - countMatch : t(n) = O(n)
    - LCAofBT : T(n) = t(n) + t(n-1) + T(n-1)
                T(n) = O(n^2)
*/
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        int totalMatch = countMatch(root, p, q);
        if(totalMatch!=2) return null;  //--------------------- how to avoid after the first sort ? ? ?
        
        if(root==p || root==q) return root;
        int leftMatch = countMatch(root.left, p, q);
        if(leftMatch==1) 
            return root;
        else if(leftMatch==2) 
            return LCAofBT(root.left, p, q);
        else
            return LCAofBT(root.right, p, q);
    }
    public int countMatch(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return 0;
        int matched = countMatch(root.left, p, q) + countMatch(root.right, p, q);
        if(root==p || root==q)
            matched += 1;
        return matched;
    }
}


// Solution 2
// A Bottom-up Approach (Worst case O(n) ):
/*
Time Complexity : O(n)
- check : t(n) = O(n)
- helper : tt(n) = O(n)
- LCAofBT : T(n) = t(n) + tt(n) = O(n)
*/
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        if(!check(root, p) || !check(root, q))
            return null;
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q)
            return root;
        TreeNode left = LCAofBT(root.left, p, q);
        TreeNode right = LCAofBT(root.right, p, q);
        if(left!=null && right!=null) return root;
        return left==null ? right : left;
    }
    public boolean check(TreeNode root, TreeNode p) {
        if(root==null) return false;
        if(root==p) return true;
        return check(root.left, p) || check(root.right, p);
    }
}
