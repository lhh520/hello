package testproject;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中第K小的元素 {
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        dfs(root);
        return list.get(k);
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
