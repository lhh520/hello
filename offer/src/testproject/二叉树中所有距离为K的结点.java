package testproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树中所有距离为K的结点 {
    Map<Integer,TreeNode>map=new HashMap<>();
    List<Integer>list=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findAns(target, null, 0, k);
        return list;
    }
    public void findParent(TreeNode node){
        if(node.left!=null){
            map.put(node.left.val,node);
            findParent(node.left);
        }
        if(node.right!=null){
            map.put(node.right.val,node);
            findParent(node.right);
        }
    }
    public void findAns(TreeNode node,TreeNode from,int depth,int k){
        if(node==null){
            return;
        }
        if(depth==k){
            list.add(node.val);
            return;
        }
        if(node.left!=from){
            findAns(node.left,node,depth+1,k);
        }
        if(node.right!=from){
            findAns(node.right,node,depth+1,k);
        }
        if(map.get(node.val)!=from){
            findAns(map.get(node.val),node,depth+1,k);
        }
    }
}
