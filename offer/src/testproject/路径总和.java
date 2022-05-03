package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 路径总和 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return lists;
        }
        backtrace(root,targetSum);
        return lists;
    }
    public void backtrace(TreeNode root, int targetSum){

        if(root==null){
            //System.out.println(list.toString());
            return;
        }

        list.add(root.val);
        if(root.left==null&&root.right==null&&sumList(list)==targetSum){
            lists.add(new ArrayList<>(list));
        }
        backtrace(root.left,targetSum);
        backtrace(root.right,targetSum);
        list.remove(list.size()-1);
    }
    public int sumList(List<Integer>list){
        int sum=0;
        for(int i:list){
            sum=sum+i;
        }
        return sum;
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
        pathSum(a,7);
    }
}
