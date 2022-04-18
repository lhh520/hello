package test;

import java.util.ArrayList;
import java.util.List;

public class test144 {
    List<Integer>list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        dfs(root);
        return list;
    }
    public void dfs(TreeNode root)
    {
        if(root==null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
