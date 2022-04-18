package offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer047 {
    public TreeNode pruneTree(TreeNode root) {
       if(root==null)
           return root;
       root.left=pruneTree(root.left);
       root.right=pruneTree(root.right);
       if(root.val==0&&root.left==null&&root.right==null)
           root=null;
       return root;
    }

}
