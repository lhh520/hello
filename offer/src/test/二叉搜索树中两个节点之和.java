package test;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中两个节点之和 {
    List<Integer>list=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        for(int i=0;i<list.size();i++){
            if(list.contains(k-list.get(i))&&(list.get(i)*2!=k)){
                return true;
            }
        }
        return false;
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
