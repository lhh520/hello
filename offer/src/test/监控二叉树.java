package test;

import org.junit.Test;

public class 监控二叉树 {
    int res=0;
    public int minCameraCover(TreeNode root) {
        return dfs(root)==0?res+1:res;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 2;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==0||right==0){
            res++;
            return 1;
        }
        //其中一个有相机，则父节点就是被覆盖了
        if(left==1||right==1){
            return 2;
        }
        //都为覆盖
        return 0;
    }
    @Test
    public void test(){

    }
}
