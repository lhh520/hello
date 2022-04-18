package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class offer34 {
    List<List<Integer>>lists=new ArrayList<>();
    Set<List<Integer>>set=new HashSet<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target,list);
        return  lists;
    }
    public void dfs(TreeNode root, int target, List<Integer>list)
    {   if(root==null)
        return;
        list.add(root.val);
        if(root.left==null&&root.right==null&&sumList(list)==target)
        {   if(set.add(new ArrayList<>(list)))
            lists.add(new ArrayList<>(list));

        }

        dfs(root.left,target,list);
        dfs(root.right,target,list);
        list.remove(list.size()-1);
    }
    public int sumList(List<Integer>list)
    {
        int sum=0;
        for(int i=0;i<list.size();i++)
        {
            sum=sum+list.get(i);
        }
        return sum;
    }
    @Test
    public void test()
    {
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
        List<List<Integer>>ans=pathSum(a,7);
        System.out.println(ans.toString());
        //set


    }
}
