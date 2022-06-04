package test;

import java.util.ArrayList;
import java.util.List;

public class 展平二叉搜索树 {
    List<TreeNode>list=new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode bb=new TreeNode(0);
        TreeNode cur=bb;
        for(int i=0;i<list.size();i++){
            TreeNode temp=list.get(i);
            temp.left=null;
            temp.right=null;
            cur.right=temp;
            cur=cur.right;
        }
        return bb.right;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
