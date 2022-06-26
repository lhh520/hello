package testproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                max=Math.max(max,temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }
}
