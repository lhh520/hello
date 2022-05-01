package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 两棵二叉搜索树中的所有元素 {
    List<Integer>list1=new ArrayList<>();
    List<Integer>list2=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1,list1);
        dfs(root2,list2);
        List<Integer>list=new ArrayList<>();
        int i=0,j=0;
        while (i<list1.size()||j<list2.size()){
            int a=i>=list1.size()?Integer.MAX_VALUE:list1.get(i);
            int b=j>=list2.size()?Integer.MAX_VALUE:list2.get(j);
            if(a<=b&&i<list1.size()){
                i++;
                list.add(a);
            }else if(a>b&&j<list2.size()){
                j++;
                list.add(b);
            }
        }

        return list;
    }
    public void dfs(TreeNode root,List<Integer>list){
        if(root==null)
            return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
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
        //
        getAllElements(a,a);
    }
}
