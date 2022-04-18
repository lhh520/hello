public class offer053
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
     TreeNode ans=null;
     while(root!=null)
     {
         if(root.val>p.val)
         {
             ans=root;
             root=root.left;
         }
         else
             root=root.right;
     }
        return ans;
    }

}
