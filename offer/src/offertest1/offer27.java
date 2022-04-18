package offertest1;

import java.util.LinkedList;
import java.util.Queue;

public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=root.left;
        return root;
    }
}
