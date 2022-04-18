package test;

import java.util.*;

public class test1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode>list=new ArrayList<>();
    Set<Integer>set=new HashSet<>();
        for (int i = 0; i <to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        list.add(root);
        del(root,set,list);
        return list;

    }
    //后序遍历，进行删除
    TreeNode del(TreeNode node,Set<Integer>delete,List<TreeNode>list)
    {
        if(node==null) return null;
        node.left=del(node.left,delete,list);
        node.right=del(node.right,delete,list);
        if(delete.contains(node.val))
        {
            if(node.left!=null)
                list.add(node.left);
            if(node.right!=null)
                list.add(node.right);
            if(list.contains(node))
                list.remove(node);
            return null;
        }
        return node;
    }
}
