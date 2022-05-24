package testproject;

public class 单值二叉树 {
    int uu;
    public boolean isUnivalTree(TreeNode root) {
        uu=root.val;
        return dfs(root);
    }
    public boolean dfs(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.val!=uu){
            return false;
        }
        return dfs(root.left)&&dfs(root.right);
    }
}
