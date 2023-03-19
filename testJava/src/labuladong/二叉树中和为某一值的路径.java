package labuladong;
import java.util.*;
public class 二叉树中和为某一值的路径 {
    List<List<Integer>>ret=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtrace(root,target);
        return ret;
    }
    public void backtrace(TreeNode root, int target){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null&&sum(list)==target){
            ret.add(new ArrayList<>(list));
        }
        backtrace(root.left,target);
        backtrace(root.right,target);
        list.remove(list.size()-1);
    }
    public int sum(List<Integer>list){
        int num=0;
        for(int i=0;i<list.size();i++){
            num+=list.get(i);
        }
        return num;
    }
}
