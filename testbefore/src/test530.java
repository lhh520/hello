import java.util.Map;

public class test530 {

    int cur=-1;
    int ans;
    public int getMinimumDifference(TreeNode root) {

       dfs(root);
       return ans;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        dfs(root.left);
        cur=root.val;
        if(cur==-1)
            cur=root.val;
        else
        {
            ans=Math.min(ans,Math.abs(root.val-cur));
            cur= root.val;
        }
        dfs(root.right);
    }
}
