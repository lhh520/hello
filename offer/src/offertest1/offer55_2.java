package offertest1;

public class offer55_2 {

    public boolean isBalanced(TreeNode root) {
    if(root==null)
        return true;
    else
        return Math.abs(dfs(root.left)-dfs(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}
