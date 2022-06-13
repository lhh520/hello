package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class 最大层内元素和 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int ans=Integer.MIN_VALUE;
        int j=1;
        int max=1;
        while (!queue.isEmpty()){
            int sz=queue.size();
            int cur=0;
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                cur+=temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            if(cur>ans){
                ans=cur;
                max=j;
            }
            j++;
        }
        return max;
    }
}
