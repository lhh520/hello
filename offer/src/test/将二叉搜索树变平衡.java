package test;

import java.util.ArrayList;
import java.util.List;

public class 将二叉搜索树变平衡{
    List<Integer>list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        //先中序遍历 获得二叉树的节点
        getvalue(root);
        //递归建立二叉书
        return build(0,list.size()-1);
    }
    public void getvalue(TreeNode root){
        if(root==null){
            return;
        }
        //中序遍历
        getvalue(root.left);
        list.add(root.val);
        getvalue(root.right);
    }
    public TreeNode build(int l,int r){
        int mid=(l+r)/2;
        TreeNode node=new TreeNode(list.get(mid));
        if(l<=mid-1)
         node.left=build(l,mid-1);
        if(r>=mid+1){
            node.right=build(mid+1,r);
        }
        return node;
    }
}
