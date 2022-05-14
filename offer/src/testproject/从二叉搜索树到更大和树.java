package testproject;

import org.junit.Test;

public class 从二叉搜索树到更大和树 {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root!=null){
            bstToGst(root.right);
            sum+=root.val;
            root.val=sum;
            bstToGst(root.left);
        }
        return root;
    }
    @Test
    public void test(){

    }
}
