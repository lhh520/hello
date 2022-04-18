import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test897 {
    List<Integer>temp=new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
       dfs(root);
        System.out.println(temp.toString());
       TreeNode head=new TreeNode(0);
        TreeNode cur=head;
        System.out.println("hello");
        int len=temp.size();
       for(int i=0;i<len;i++)
       {
           TreeNode node=new TreeNode(temp.get(i));
           cur.right=node;
           cur=node;
       }
       return head.right;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        dfs(root.left);
        temp.add(root.val);
        dfs(root.right);
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
        increasingBST(a);
    }
}
