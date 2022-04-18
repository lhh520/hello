public class test700 {
    public TreeNode searchBST(TreeNode root, int val) {
     if(root.val==val||root==null)
        return root;
     return root.val>val?searchBST(root.left,val):searchBST(root.right,val);

    }
}
