package backtrace;

import org.junit.Test;

import java.util.LinkedList;
import java.util.*;

public class test9988888 {
    public int maxValue (TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int ret=0;
        List<Integer>list=new ArrayList<>();
        while (!queue.isEmpty()){
            int sz=queue.size();
            int total=0;
            int maxson=0;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                total+=cur.val;
                if(cur.left!=null){
                    maxson=Math.max(maxson,cur.left.val-cur.val);
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    maxson=Math.max(maxson,cur.right.val-cur.val);
                    queue.add(cur.right);
                }
            }
            ret=Math.max(ret,Math.max(total+maxson,total));

        }
        return ret;
    }




    @Test
    public  void maindd() {
        TreeNode node=new TreeNode(3);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        System.out.println(maxValue(node));
    }


}
