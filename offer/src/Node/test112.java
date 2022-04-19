package Node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test112 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root);
        System.out.println(lists.size());
        for(List<Integer>li:lists){
            System.out.println(li.toString());
            int sum=0;
            for(int i:li){
                sum+=i;
            }
            if(sum==targetSum)
                return true;
        }
        return false;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
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
        hasPathSum(a,5);
    }
}
