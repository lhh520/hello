import org.junit.Test;

import java.util.Stack;

public class test236
{
    Stack<Integer>stack1=new Stack<>();
    Stack<Integer>stack2=new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        dfs(root,p);
        if(!stack1.isEmpty())
        {
            System.out.println(stack1.pop());
        }
        return root;
    }
    public void dfs(TreeNode root,TreeNode p)
    {

        stack1.push(root.val);
        if(root.val==p.val)
        {
            stack1.push(root.val);

            return;
        }
            if(root.left!=null)
            dfs(root.left,p);
        if(root.right!=null)
            dfs(root.right,p);
        stack1.pop();
    }
    @Test
    public void test()
    {   TreeNode a = new TreeNode(1);
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
        lowestCommonAncestor(a,f,b);
    }
}
