import org.junit.Test;

public class test938 {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return sum;
    }
    public int dfs(TreeNode root, int low, int high)
    {
       if(root==null)
           return 0;
       if(root.val>low&&root.val<high)
       {
           sum=sum+root.val;
       }
       return dfs(root, low, high)+dfs(root, low, high);
    }
    @Test
    public void test()
    {

    }
}
