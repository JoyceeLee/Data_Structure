/**
* Convert a BST to a sorted circular doubly-linked list in-place. 
* Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
*/


public class Solution {
    public TreeNode BST2DLL(TreeNode root) {
        TreeNode pre = null;
        TreeNode head = null;
        helper(root, pre, head);
        return head;
    }
    public void helper(TreeNode cur, TreeNode pre, TreeNode head) {
        if(cur==null) return;
        helper(cur.left, pre, head);
        
        cur.left = pre;
        if(pre!=null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        
        head.left = cur;
        TreeNode right = cur.right; //
        cur.right = head;
        pre = cur;
        helper(right, pre, head);
    }
}
