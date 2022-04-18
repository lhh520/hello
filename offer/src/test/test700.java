package test;

public class test700 {
    TreeNode target=new TreeNode();
    public TreeNode searchBST(TreeNode root, int val) {
    dfs(root,val);
    return target;
    }
    public void dfs(TreeNode root, int val)
    {
        if(root==null)
            return;
        if(root.val==val)
        {
            target=root;
            return;
        }
        if(root.left!=null)
            dfs(root.left,val);
        if(root.right!=null)
            dfs(root.right,val);
    }
    public TreeNode searchBST1(TreeNode root, int val)
    {
        if(root==null)
            return null;
        if(val==root.val)
            return root;
        return searchBST1(val<root.val?root.left:root.right,val);
    }
}
