package offertest1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class offer33 {
//    public boolean verifyPostorder(int[] postorder) {
//
//    }
    //二叉树的中序遍历是递增数组
    Set<Integer> map;
    boolean flag=false;
    public boolean findTarget(TreeNode root, int k) {
        map=new HashSet<>();
        dfs(root,k);
        return flag;
    }
    public void dfs(TreeNode root,int k){
        if(root==null)
            return;
        if(map.contains(k- root.val))
        {   flag=true;
            return;}
        dfs(root.left,k);
        map.add(root.val);
        dfs(root.right,k);
    }
}
