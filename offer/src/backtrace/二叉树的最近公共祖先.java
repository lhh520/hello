package backtrace;

import java.util.*;

public class 二叉树的最近公共祖先 {
    Map<Integer,TreeNode> map=new HashMap<>();
    Set<Integer>set=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        while (p!=null){
            set.add(p.val);
            p=map.get(p.val);
        }
        while(q!=null){
            if(set.contains(q.val)){
                return q;
            }
            q=map.get(q.val);
        }
        return root;
    }
    //每个都存储着子节点到父亲节点的关系
    public void dfs(TreeNode root){
        if(root.left!=null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
