package backtrace;


import org.junit.Test;

import java.util.*;

public class Tree {
    public static List<Integer> getTree(TreeNode root){
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        int k=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            List<Integer>list1=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                list1.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            if(k%2!=0){
                Collections.reverse(list1);
            }
            System.out.println(list1);
            k++;
            for(int ii=0;ii<list1.size();ii++){
                list.add(list1.get(ii));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(0);
        TreeNode n2=new TreeNode(1);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        List<Integer>list=getTree(n1);
        //System.out.println(list);
    }

}
