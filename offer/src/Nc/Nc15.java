package Nc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Nc15 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<ArrayList<Integer>>lists=new ArrayList<>();
        while (!queue.isEmpty())
        {
            int sz=queue.size();
            for(int i=0;i<sz;i++)
            {
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
