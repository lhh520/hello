package test;

public class test596 {
    int sum=0;
    public int findTilt(TreeNode root) {
       dfs(root);
       return sum;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
           return 0;
        int sumleft=dfs(root.left);
        int sumright=dfs(root.right);
        sum=sum+Math.abs(sumleft-sumright);
        return sumleft+sumright+root.val;
    }
}
