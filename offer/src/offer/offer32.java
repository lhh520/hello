package offer;

import org.junit.Test;

import java.util.*;

public class offer32 {
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[]{};
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode temp=queue.poll();
            list.add(temp.val);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return  ans;
    }
    @Test
    public void test()
    {   TreeNode gg=null;
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        int [] num=levelOrder(gg);
        System.out.println(Arrays.toString(num));
    }
}
