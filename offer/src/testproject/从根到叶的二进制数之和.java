package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 从根到叶的二进制数之和 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        //深度优先遍历
        dfs(root);
        int sum=0;
        for(List<Integer>lis:lists){
            int cur=0;
            for(int j=0;j<lis.size();j++){
                cur=cur*2+lis.get(j);
            }
            sum=sum+cur;
        }

        return sum;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        //开始
        list.add(root.val);
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
            //return;
        }
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size()-1);
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

        System.out.println(sumRootToLeaf(a));
    }
}
