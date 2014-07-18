/**
* Given a binary tree, find the largest Binary Search Tree (BST), 
* where largest means BST with largest number of nodes in it. 
* The largest BST may or may not include all of its descendants.
*/

/**
* Hint :
* You could not simply return root node of the largest BST as this would include all of its subtrees. 
* You would need to create copies of the subtrees or delete nodes from the original binary tree.
*/


class Numb {
    int data;
    public Numb(int data) {
        this.data = data;
    }
}
public class Solution {
    public findLargestBST(TreeNode root){
        TreeNode largestBST = null;
        TreeNode child = null;
        Numb maxNodes = new Numb(Integer.MIN_VALUE);

        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, maxNodes, largestBST, child);
        return largestBST;
    }
    public int helper(TreeNode root, int min, int max, 
                   Numb maxNodes, TreeNode largestBST, TreeNode child) {
        if(root==null) return 0;
        if(min<root.val && root.val<max) {
            int leftNodes = helper(root.left, min, root.val, maxNodes, largestBST, child);
            TreeNode leftChild = leftNodes==0 ? null : child;
            int rightNodes = helper(root.right, root.val, max, maxNodes, largestBST, child);
            TreeNode rightChild = rightNodes==0 ? null : child;
            
            TreeNode parent = new TreeNode(root.val);
            parent.left = leftChild;
            parentright = rightChild;
            child = parent;
            
            int total = leftNodes + rightNodes + 1;
            if(total>maxNodes.data) {
                maxNodes.data = total;
                largestBST = child;
            }
            return total;
        } else {
            helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, maxNodes, largestBST, child);
            return 0;
        }
    }
}
