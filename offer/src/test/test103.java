package test;

import java.util.*;

public class test103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        while (!queue.isEmpty())
        {
            int sz=queue.size();
            int j=0;
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<sz;i++)
            {
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(j%2==0)
                ans.add(new ArrayList<>(list));
            else
            {
                Collections.reverse(list);
                ans.add(new ArrayList<>(list));
            }
            list.clear();
            j++;
        }
        return ans;
    }
}
