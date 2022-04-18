package offertest1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>>lists=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }
}
