package Node;

public class test617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if(root1==null)
             return root2;
         if(root2==null)
             return root1;
         TreeNode merged=new TreeNode(root1.val+root2.val);
         merged.left=mergeTrees(root1.left,root2.right);
         merged.right=mergeTrees(root1.right,root1.right);
         return merged;
    }
}
