package offertest1;

import java.util.*;

public class test68 {
    HashMap<Integer,TreeNode>map=new HashMap<>();
    Set<TreeNode>set=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=root){
            set.add(map.get(p.val));
            p=map.get(p.val);
        }
        while(q!=null){
            if(set.contains(map.get(q.val)))
                return q;
            q=map.get(q.val);
        }
        return null;
    }
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
