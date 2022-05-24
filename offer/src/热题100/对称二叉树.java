package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 对称二叉树 {
    public boolean isSymmetric1(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i)!=list.get(list.size()-1)){
                    return false;
                }
            }
            //
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root){
        return dfshelper(root,root);
    }
    public boolean dfshelper(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&dfshelper(left.left,right.right)&&dfshelper(left.right,right.left);
    }
    @Test
    public void test(){

    }
}
