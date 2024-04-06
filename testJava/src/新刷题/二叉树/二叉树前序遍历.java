package 新刷题.二叉树;


import java.util.ArrayList;
import java.util.List;

public class 二叉树前序遍历 {
    //递归函数写法：1.确定返回类型 2.确定终止条件 3.确定单层递归罗技
    List<Integer>list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pre(root);
        return list;
    }
    public void pre(TreeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        pre(root.left);
        pre(root.right);
    }
}
