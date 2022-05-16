package 热题100;

import java.util.ArrayList;
import java.util.List;

public class 后继者 {
    List<TreeNode> list=new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        for(int i=0;i<list.size();i++){
            if(list.get(i)==p){
                try {
                    return list.get(i+1);
                }
                catch (Exception e){

                }
            }
        }
        return null;
    }
    public void dfs(TreeNode root){
        //中序遍历
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode cur = root;
        TreeNode ans = null;
        while (cur != null){
            if (cur.val > target){
                ans = cur;
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }

        }
        return ans;
    }
}
