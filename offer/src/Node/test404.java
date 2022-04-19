package Node;

import org.junit.Test;

public class test404 {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return sum;
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum=sum+root.left.val;
        }
        dfs(root.left);
        dfs(root.right);

    }

}
