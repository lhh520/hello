package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<Integer>ans=new ArrayList<>();
        if(root==null)
            return ans;
        queue.add(root);
        while (!queue.isEmpty())
        {
            int sz=queue.size();
            for (int i = 0; i <sz; i++) {
                TreeNode temp=queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                if(i==sz-1)
                    ans.add(temp.val);
            }
        }
        return ans;
    }
}
