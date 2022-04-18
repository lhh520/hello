import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {   int maxlen=Integer.MIN_VALUE;

            //root=queue.poll();
            int sz=queue.size();//
            for(int i=0;i<sz;i++)
            {
               TreeNode tr=queue.poll();
               maxlen=Math.max(tr.val,maxlen);
                if(tr.left!=null)
                    queue.add(root.left);
                if(tr.right!=null)
                    queue.add(root.right);
            }
            ans.add(maxlen);

        }
        return ans;
    }
    //
    public List<Integer> largestValues0(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 层序遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 在每一层维护一个变量，用于存储最大值
            int max = Integer.MIN_VALUE;
            // 对每一层的元素进行遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 每取出来一个元素就进行一次比较
                max = Math.max(max, cur.val);

                // 添加下一层的元素
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 将每一层的最大值添加到结果变量中
            result.add(max);
        }
        return result;
    }


}
