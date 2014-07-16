/*Given a binary tree, find the lowest common ancestor of two given nodes in the tree.*/

// Solution 1
// A Top-Down Approach ( Worst case O(n^2) ):
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        int totalMatch = countMatch(root, p, q);
        if(totalMatch!=2) return null;
        
        if(root==p || root==q) return root;
        int leftMatch = countMatch(root.left, p, q);
        if(totalMatch==1) 
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
public class Solution {
    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        if(!cover(root, p) || !cover(root, q))
            return null;
        if(root==p || root==q)
            return root;
        TreeNode left = LCAofBT(root, p, q);
        TreeNode right = LCAofBT(root, p, q);
        if(left!=null && right!=null) return root;
        return left==null ? right : left;
    }
    public boolean cover(TreeNode root, TreeNode p) {
        if(root==null) return false;
        if(root==p) return true;
        return cover(root.left, p) || cover(root.right, p);
    }
}
