package offertest1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer34 {
    List<List<Integer>>lists;
    List<Integer>list;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        System.out.println(1);
        lists=new ArrayList<>();
        list=new ArrayList<>();
        //k=target;
        System.out.println(1);
        dfs(root,target);
        System.out.println(lists.toString());
        return lists;
    }
    public void dfs(TreeNode root,int target){
        if(root==null&&sum1(list,target)){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(root==null){
            return;
        }
        dfs(root.left,target);
        list.add(root.val);
        dfs(root.right,target);
    }
    public boolean sum1(List<Integer>list1,int target){
        System.out.println(list1.toString());
        int sum0=0;
        if(list1.size()==0)
            return false;
        for (int i = 0; i <list1.size(); i++) {
            sum0=sum0+list1.get(i);
        }
        if(sum0==target)
            return true;
        return false;
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
