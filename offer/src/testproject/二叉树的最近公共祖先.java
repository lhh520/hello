package testproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 二叉树的最近公共祖先 {
    Map<Integer,TreeNode>map=new HashMap<>();
    Set<Integer>set=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){//存到数组中
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
    public void dfs(TreeNode root){//哈希表中存储了数据和节点
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
