package Node;

import java.util.LinkedList;
import java.util.Queue;

public class test513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(root);
        int ans=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                if(i==0)
                    ans=temp.val;
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);

            }
        }
        return ans;
    }
}
