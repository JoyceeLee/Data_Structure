/**
* Convert a BST to a sorted circular doubly-linked list in-place. 
* Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
*/

// Solution 1 : In-order
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


// Solution 2 : Divided and Conquer
public class Solution {
    public void join(TreeNode a, TreeNode b) {
        a.right = b;
        b.left = a;
    }
    public TreeNode connect(TreeNode lista, TreeNode listb) {
        TreeNode alast = lista.left;
        TreeNode blast = listb.left;
        join(alast, listb);
        join(blast, lista);
        return lista;
    }
    public TreeNode BST2DLL(TreeNode root) {
        if(root==null) return;
        TreeNode alist = BST2DLL(root.left);
        TreeNode blist = BST2DLL(root.right);
        root.left = root;
        root.right = root;
        alist = connect(alist, root);
        alist = connect(alist, blist);
        reurn alist;
    }
}
