package 热题100;

import org.junit.Test;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
    @Test
    public void test(){

    }
}
