package hot100;

public class 二叉树中的最大路径和 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int node=left+right+root.val;
        max=Math.max(max,node);
        return Math.max(left,right)+root.val;
    }
}
