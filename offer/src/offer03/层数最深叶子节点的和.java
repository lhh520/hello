package offer03;

import java.util.LinkedList;
import java.util.Queue;

public class 层数最深叶子节点的和 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int sum=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            sum=0;
            for(int i=0;i<sz;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}
