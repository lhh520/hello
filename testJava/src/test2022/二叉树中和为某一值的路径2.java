package test2022;

import java.util.*;

public class 二叉树中和为某一值的路径2 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target){
        if(root==null){
            return lists;
        }
        dfs(root,target);
        return lists;
    }
    public void dfs(TreeNode root,int target){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null&&sumList(list)==target){
            lists.add(new ArrayList<>(list));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        list.remove(list.size()-1);
    }
    public int sumList(List<Integer>list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
}
