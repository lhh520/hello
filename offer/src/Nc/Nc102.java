package Nc;

import org.junit.Test;

public class Nc102 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root==null) return root.val;
        if(o1==root.val || o2==root.val) return root.val;
        boolean f1=dfs(root.left,o1);
        boolean f2=dfs(root.right,o2);
        boolean f3=dfs(root.left,o2);
        boolean f4=dfs(root.right,o1);
        if(f1&&f2||f3&&f4)
            return root.val;
        if(f1&&f3)
            return lowestCommonAncestor(root.left,o1,o2);

            return lowestCommonAncestor(root.right,o1,o2);

    }
    public boolean dfs(TreeNode root, int o)
    {  if(root==null)
        return false;
       if(root.val==o)
           return true;

       return dfs(root.left,o)||dfs(root.right,o);
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
        System.out.println(dfs(a,40));
    }
}
