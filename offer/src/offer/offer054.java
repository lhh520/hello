package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer054 {
    List<Integer>list=new ArrayList<>();
    int sum=0;
    public TreeNode convertBST(TreeNode root)
    {
        dfs1(root);
        dfs2(root);
        return root;
    }
    public void dfs1(TreeNode root)
    {
        if(root==null)
            return;
        sum=sum+root.val;
        list.add(root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    public void dfs2(TreeNode root)
    {
        if(root==null)
            return;
        root.val=sub(root.val,list);
        dfs2(root.left);
        dfs2(root.right);
    }
    int sub(int val,List<Integer>list)
    {
        int total=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>val)
                total=total+list.get(i);
        }
        return total;
    }
    @Test
    public void test()
    {

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
        TreeNode t=convertBST(a);
        System.out.println(sum);
        System.out.println(list.toString());
    }
}
