package 新刷题.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树前序遍历迭代 {
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);//先输出中心节点
            //右侧
            if(pop.right!=null){
                stack.add(pop.right);
            }
            if(pop.left!=null){
                stack.add(pop.left);
            }
        }
        return list;
    }

}
