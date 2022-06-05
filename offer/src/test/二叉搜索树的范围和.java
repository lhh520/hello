package test;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的范围和 {
    int low;
    int height;
    int ans=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low=low;
        this.height=high;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(root.val>=low&&root.val<=height){
            ans+=root.val;
        }
        dfs(root.right);
    }
}
