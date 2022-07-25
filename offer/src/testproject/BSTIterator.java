package testproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSTIterator {
    TreeNode root;
    List<TreeNode> list;
    TreeNode cur;
    int ii=0;
    public BSTIterator(TreeNode root) {
        this.root=root;
        list=new ArrayList<>();
        //中序遍历
        dfs(root);
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
    public int next() {
        cur=list.get(ii++);
        return cur.val;
    }

    public boolean hasNext() {
        return ii==list.size()?false:true;
    }
}
