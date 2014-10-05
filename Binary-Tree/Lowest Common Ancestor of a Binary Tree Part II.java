/*Given a binary tree, find the lowest common ancestor of two given nodes in the tree. 
Each node contains a parent pointer which links to its parent.*/

// Solution 1
// HashSet :
/*
  Time Complexity : O(h)
  Space Complexity : O(h)
*/
public class Solution {
    public TreeNode LCAwithParent(TreeNode p, TreeNode q) {
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        while(p!=null || q!=null) {
            if(p!=null) {
                if(visited.contains(p))
                    return p;
                visited.add(p);
                p = p.parent;
            }
            if(q!=null) {
                if(visited.contains(q))
                    return q;
                visited.add(q);
                q = q.parent;
            }
        }
        return null;
    }
}


// Solution 2
/*
we could get the distance (height) of both nodes and their heights' difference (dh)
move the lower node dh steps so they could on the same level
Then, we advance both nodes one level at a time. 
 - They would then eventually intersect at one node, which is the LCA of both nodes. 
 - If not, one of the node would eventually reach NULL
 
  Time Complexity : O(h)
  Space Complexity : O(1)
*/
public class Solution {
    public TreeNode LCAwithParent(TreeNode p, TreeNode q) {
        int ph = getHeight(p);
        int qh = getHeight(q);
        if(ph>qh) {
            int tmpint = ph;
            ph = qh;
            qh = tmpint;
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        int dh = qh-ph;
        while(dh>0) {
            q = q.parent;
            dh--;
        }
        while(p!=null && q!=null) {
            if(p==q) return p;
            p = p.parent;
            q = q.parent;
        }
        return null;
    }
    public int getHeight(TreeNode p) {
        int h = 0;
        while(p!=null) {
            p = p.parent;
            h++;
        }
        return h;
    }
}
