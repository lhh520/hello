package Node;

public class test530 {
    TreeNode pre;
    int result=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       if(root==null) return 0;
       dfs(root);
       return result;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(pre!=null){
            result=Math.min(result, root.val- pre.val);
        }
        pre=root;
        dfs(root.right);
    }
}
