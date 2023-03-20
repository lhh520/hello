package labuladong;

import java.util.*;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1=find(root,p);
        List<TreeNode>list2=find(root,q);
        TreeNode ancestor=null;
        for(int i=0;i<list1.size()&&i<list2.size();i++){
            if(list1.get(i)==list2.get(i)){
                ancestor=list1.get(i);
            }
            else
                break;
        }
        return ancestor;
    }
    List<TreeNode> find(TreeNode t,TreeNode target){
        List<TreeNode>list=new ArrayList<>();
        TreeNode node=t;
        while (node!=target){
            list.add(node);
            if(target.val<node.val){
                node=node.left;
            }
            else
                node=node.right;
        }
        list.add(node);
        return list;
    }
}
