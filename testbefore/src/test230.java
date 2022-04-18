import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test230 {
    List<Integer>ans=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return ans.get(k-1);
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left!=null)
            dfs(root.left);
        ans.add(root.val);
        if(root.right!=null)
            dfs(root.right);
    }
}
