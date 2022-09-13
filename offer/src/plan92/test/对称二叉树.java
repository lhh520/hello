package plan92.test;



public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root){
        return dfs(root,root);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val== right.val&&dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
