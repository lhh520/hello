package testproject;

import java.util.HashMap;
import java.util.Map;

public class 删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }
        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);
        if(root.left==null&&root.right==null&&root.val==target){
            return null;
        }
        return root;
    }

}
