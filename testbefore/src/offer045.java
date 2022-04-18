import java.util.LinkedList;
import java.util.Queue;

public class offer045 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            root=queue.poll();//使最先进去的出列，然后root指向头节点
            if(root.right!=null)
                queue.add(root.right);//右子树不空，则右子树入队列
            if(root.left!=null)
                queue.add(root.left);//左子树不为空，左子树进入队列
        }
        return root.left.val;
    }

}
