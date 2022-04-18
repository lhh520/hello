package dp;

import java.util.HashMap;
import java.util.Map;

public class test337 {
    //不带备忘录的遍历
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int money=root.val;
        if(root.left!=null){
            money+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left)+rob(root.right.right);
        }
        return Math.max(money,rob(root.left)+rob(root.right));
    }
    //带备忘录
    public int rob1(TreeNode root){
        Map<TreeNode,Integer>map=new HashMap<>();
        return robAction(root,map);
    }
    int robAction(TreeNode root,Map<TreeNode,Integer>map){
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int money=root.val;
        if(root.left!=null){
            money+=robAction(root.left.left,map)+robAction(root.left.right,map);
        }
        if(root.right!=null){
            money+=robAction(root.right.left,map)+robAction(root.right.right,map);
        }
        int res=Math.max(money,robAction(root.left,map)+robAction(root.right,map));
        map.put(root,res);
        return res;
    }
}
