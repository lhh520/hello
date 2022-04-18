package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
         if(root==null)
             return false;
         return dfs(head,root)||dfs(head,root.left)||dfs(head,root.right);
    }
    public boolean dfs(ListNode head, TreeNode root){
        if(head==null)
            return true;
        if(root==null)
            return false;
        if(head.val!=root.val)
            return false;
        return dfs(head.next,root.left)||dfs(head.next,root.right);
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
        ListNode head=new ListNode(1);
        isSubPath(head,a);
    }
}
