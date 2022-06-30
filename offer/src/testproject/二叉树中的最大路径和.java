package testproject;

public class 二叉树中的最大路径和 {
    int maxGain=0;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxGain;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(dfs(root.left),0);
        int right=Math.max(dfs(root.right),0);
        int nodeVal=left+right+root.val;
        maxGain=Math.max(maxGain,nodeVal);
        return root.val+Math.max(left,right);
    }
}
