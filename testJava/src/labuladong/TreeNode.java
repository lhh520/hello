package labuladong;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val)
    {
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }
    /*

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
        f.left = g;*/
}
