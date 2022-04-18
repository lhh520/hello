import java.util.ArrayList;
import java.util.List;

public class offer54
{   List<Integer>temp=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
    dfs(root);
    return temp.get(temp.size()-k+1);
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        dfs(root.left);
        temp.add(root.val);
        dfs(root.right);
    }
}
