package labuladong;

public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int dfs(TreeNode root,int depth){
        if(root==null){
            return 0;
        }
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
}
