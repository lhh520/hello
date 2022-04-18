import java.util.ArrayList;
import java.util.List;

public class test783 {
    int min=Integer.MAX_VALUE;
    List<Integer>list=new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
    dfs(root);
    for(int i=0;i<list.size()-1;i++)
    {
        min=Math.min(list.get(i+1)-list.get(i),min);
    }
    return min;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
