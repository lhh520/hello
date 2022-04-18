package offertest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class offer54 {
    List<Integer>list=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(list);
        Collections.reverse(list);
        return list.get(k);
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
