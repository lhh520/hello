package offertest1;

public class offer28 {
    public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    return dfs(root.left,root.right);

    }
    public boolean dfs(TreeNode A,TreeNode B){
        if(A==null&&B==null)
            return true;
        if(A==null||B==null||A.val!=B.val)
            return false;
        return dfs(A.left,B.left)&&dfs(A.right,B.right);
    }
}
