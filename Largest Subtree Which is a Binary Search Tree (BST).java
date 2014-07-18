/**
* Given a binary tree, find the largest Binary Search Tree (BST), 
* where largest means BST with largest number of nodes in it. 
* The largest BST may or may not include all of its descendants.
*/

/**
* Hints : 
* 1. A subtree of a tree T is a tree consisting of a node in T and all of its descendants in T. 
* 2. combine the idea from this problem: Determine if a Binary Tree is a Binary Search Tree, 
* and also the idea of doing a Depth-first search (DFS).
*/


/**
* For more reading
* http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
* Naive Approach
* Flawed Approach
*/


class Number {
    int data;
    public Number(int data) {
        this.data = data;
    }
}
public class Solution {
    public TreeNode findLargestBST(TreeNode root) {
        TreeNode largestBST = null;
        Number min = new Number(0);
        Number max = new Number(0);
        Number total = new Number(Integer.MIN_VALUE);
        helper(root, min, max, total, largestBST);
        return largetsBST;
    }
    public int helper(TreeNode root, Number min, Number max, Number total, TreeNode largestBST) {
        if(root==null)
            return 0;
            
        boolean isBST = true;
        
        int leftNode = helper(root.left, min, max, total, largestBST);
        if(leftNode==-1 || (leftNode!=0 && max.data>=root.val) )
            isBST = false;
        int curMin = leftNode==0 ? root.val : min.data;
        
        int rightNode = helper(root.right, min, max, total, largestBST);
        if(rightNode==-1 || (rightNode!=0 && min.data<=root.val) )
            isBST = false;
        int curMax = rightNode==0 ? root.val : max.data;
        
        if(isBST) {
            min.data = curMin;
            max.data = curMax;
            int nodeNum = leftNode + rightNode + 1;
            if(nodeNum<total.data) {
                total.data = nodeNum;
                largestBST = root;
            }
            return nodeNum;
        } else {
            return -1;
        }
    }
}
/** Bottom-up Approach
* 1. post-order traversal, a node cannot be processed before its sub nodes (so, the min / max value have been changed
*    based on the value of leaf nodes)
* 2. we use isBST instead of return -1 immediately when the left tree is not a BST in case the right sub tree is the 
*    tree we are looking for
* 3. Pros of bottom-up (compared to top-down)
*   - time reduced
*     when one of the nodes does not satisfy the BST properties, all subtrees above 
*     (which includes this node as well) must also not satisfy the BST requirements
*   - information
*     results for total number of nodes, current min/max value could be passed up the tree
*/
