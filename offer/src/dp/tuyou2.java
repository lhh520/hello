package dp;

import java.util.LinkedList;
import java.util.Queue;

public class tuyou2 {
    public int distributePerls (TreeNode root) {
        // write code here
        int num=root.val;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int count=0;
        while (!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode temp=q.poll();
                num+=temp.val;
                count++;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return num/count;
    }
}
