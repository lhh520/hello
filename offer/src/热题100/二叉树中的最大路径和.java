package 热题100;

public class 二叉树中的最大路径和 {
    int max=0;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
         if(root==null){
             return 0;
         }
         int left=Math.max(dfs(root.left),0);
         int right=Math.max(dfs(root.right),0);
         int node=left+right+root.val;
         max=Math.max(max,node);
         return Math.max(left,right)+root.val;
    }
}
