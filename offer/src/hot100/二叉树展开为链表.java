package hot100;
import java.util.*;
public class 二叉树展开为链表 {
    List<TreeNode>list=new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode dummy=new TreeNode(-1);
        TreeNode cur=dummy;
        for(int i=0;i<list.size();i++){
            TreeNode cc=list.get(i);
            cc.left=null;
            cur.right=cc;
            cur=cur.right;
        }
        cur.right=null;
        root=dummy.right;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        if(root.left!=null){
            dfs(root.left);
        }
        if(root.right!=null){
            dfs(root.right);
        }
    }
}
