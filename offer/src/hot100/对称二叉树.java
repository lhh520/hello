package hot100;



public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root){
        return dfs(root,root);
    }
    boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        //
        return left.val==right.val&&dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
