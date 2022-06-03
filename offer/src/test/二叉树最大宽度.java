package test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode>queue=new LinkedList<>();//存放节点
        Queue<Integer>queue2=new LinkedList<>();//存放节点的索引
        queue.add(root);
        queue2.add(1);
        int ans=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            int wide=0;
            boolean flag=false;//用来记录是不是第一个节点
            int left=-1,right=-1;//记录左右的值

            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                int pos=queue2.poll();
                if(!flag){
                   flag=true;
                   left=pos;
                }
                right=pos;
                wide=Math.max(wide,right-left+1);
                if(temp.left!=null){
                    queue.add(temp.left);
                    queue2.add(2*pos);//下一个做节点 等于当前的节点乘以2
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    queue2.add(2*pos+1);
                }

            }
            ans=Math.max(ans,wide);
        }
        return ans;
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        int ans=widthOfBinaryTree(a);
        System.out.println(ans);
    }
}
