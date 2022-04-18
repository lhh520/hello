import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test199 {
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer>ans=new ArrayList<>();
    Queue<TreeNode>queue=new LinkedList<>();
    if(root==null)
        return ans;
    queue.add(root);
    while(!queue.isEmpty())
    {
        int sz=queue.size();
        TreeNode temp=null;
        for(int i=0;i<sz;i++)
        {
            temp=queue.poll();

            if(root.left!=null)
                queue.add(root.left);
            if(root.right!=null)
                queue.add(root.right);
        }
        ans.add(new Integer(temp.val));

    }
    return ans;
    }
}
