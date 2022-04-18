import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>>lists=new ArrayList<>();
        while(!queue.isEmpty())
        {   List list=new ArrayList();
            int sz=queue.size();
            for(int i=0;i<sz;i++)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }
}
