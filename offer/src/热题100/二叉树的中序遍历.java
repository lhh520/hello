package 热题100;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    List<Integer>list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
