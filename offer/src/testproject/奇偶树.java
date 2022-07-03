package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int cur=1;
        while (!queue.isEmpty()){
            int sz=queue.size();

            int pre=cur%2==0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            for(int i=0;i<sz;i++){
                TreeNode node=queue.poll();
                if(cur%2==0){
                    if(node.val>=pre||(node.val%2!=0)){
                        return false;
                    }
                }else {
                    if(node.val<=pre||(node.val%2==0)){
                        return false;
                    }
                }

                pre=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            cur++;
        }
        return true;
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        System.out.println(isEvenOddTree(a));
    }
}
