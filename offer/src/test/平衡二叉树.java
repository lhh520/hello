package test;

public class 平衡二叉树 {
    boolean is=false;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        if(is){
            return false;
        }else {
            return true;
        }
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(Math.abs(left-right)>1){
            is=true;
        }
        return Math.max(left,right)+1;
    }
}
