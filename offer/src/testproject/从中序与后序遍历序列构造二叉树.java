package testproject;

import java.util.HashMap;

public class 从中序与后序遍历序列构造二叉树 {
    //inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    HashMap<Integer,Integer>map=new HashMap<>();
    int[]post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        post=postorder;
        TreeNode root=buildTree(0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    public TreeNode buildTree(int inorderStart,int inorderEnd,int postStart,int postEnd){
        if(inorderStart>=inorderEnd||postStart>=postEnd){
            return null;
        }
        //先找到根结点
        int root=post[postEnd];
        //中序遍历中根结点的位置，分为两部分
        int rootIndexInorder=map.get(root);
        TreeNode node=new TreeNode(root);
        node.left=buildTree(inorderStart,rootIndexInorder-1, postStart,postStart + rootIndexInorder - inorderStart - 1);
        node.right=buildTree(rootIndexInorder+1,inorderEnd,postStart + rootIndexInorder - inorderStart,postEnd-1);
        return node;
    }
}
