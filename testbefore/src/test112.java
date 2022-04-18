public class test112
{
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
            return root.val==targetSum;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    public boolean hasPathSum1(TreeNode root, int targetSum)
    {
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root,int cur,int targetSum)
    {
        if(root==null)
            return false;
        cur=cur+root.val;
        if(root.left==null&&root.right==null)
            return cur==targetSum;//表示在最后一层，此时需要判定是不是等于路径和
        else
            return dfs(root.left,cur,targetSum)||dfs(root.right,cur,targetSum);
    }

}
