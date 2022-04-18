import java.util.ArrayList;
import java.util.List;

public class test230_1 {
    //int target;
    List<Integer>temp=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
    dfs(root);
    return temp.get(k-1);
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
