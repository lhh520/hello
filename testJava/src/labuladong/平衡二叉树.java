package labuladong;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(dfs(root.left)-dfs(root.right))<=1;
    }
    public int dfs(TreeNode A){
        if(A==null){
            return 0;
        }
        return Math.max(dfs(A.left),dfs(A.right))+1;
    }
}
