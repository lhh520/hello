import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2)?true:false;
    }
    public void dfs(TreeNode root,List<Integer>list)
    {
        if(root==null)
            return;
        if(root.right==null&&root.left==null)
            list.add(root.val);
        if(root.left!=null)
            dfs(root.left,list);
        if(root.right!=null)
            dfs(root.right,list);
    }
}
