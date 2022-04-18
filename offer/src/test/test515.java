package test;

import java.util.*;

public class test515 {
    public List<Integer> largestValues(TreeNode root) {
    List<Integer>list=new ArrayList<>();
    Queue<TreeNode>queue=new LinkedList<>();
    if(root==null)
        return list;
    queue.add(root);
    while (!queue.isEmpty())
    {
        int sz=queue.size();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<sz;i++)
        {
            TreeNode temp=queue.poll();
            max=Math.max(max,temp.val);
            if(temp.right!=null)
                queue.add(temp.right);
            if(temp.left!=null)
                queue.add(temp.left);
        }
        list.add(max);
    }
    return list;
    }
}
