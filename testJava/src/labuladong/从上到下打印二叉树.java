package labuladong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        List<Integer>list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        int[]nums=new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return nums;
    }
}
