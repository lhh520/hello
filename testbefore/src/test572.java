import org.junit.Test;

public class test572 {
    TreeNode temp=null;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root,subRoot);

        Boolean ans=check(temp,subRoot);
        return ans;
    }
    public void dfs(TreeNode root, TreeNode subRoot)
    {
        if(root.val==subRoot.val)
        {   temp=root;
            return;}
        if(root==null)
            return;
        if(root.left!=null)
            dfs(root.left,subRoot);
        if(root.right!=null)
            dfs(root.right,subRoot);

    }
    public boolean check(TreeNode root, TreeNode subRoot)
    {
        if(root==null&&subRoot==null)
            return true;
        if(root==null||subRoot==null||root.val!=subRoot.val)
            return false;
        return check(root.left,subRoot.left)&&check(root.right, subRoot.right);
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
        System.out.println(isSubtree(a,g));
    }
}
