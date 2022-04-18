package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>queue=new LinkedList<>();
        if(root==null)
            return false;
        queue.add(root);
        while (!queue.isEmpty())
        {
            int sz=queue.size();
            List<Integer>list=new ArrayList<>();
            for (int i = 0; i <sz; i++)
            {
                TreeNode temp=queue.poll();
                if((temp.left.val==x&&temp.right.val==y)||(temp.left.val==y&&temp.right.val==x))
                {
                    return false;
                }
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(list.contains(x)&&list.contains(y))
                return true;
        }
        return false;
    }
}
