package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                if(i==0){
                    ans=temp.val;
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return ans;
    }
}
