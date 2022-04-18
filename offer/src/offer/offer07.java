package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//****//
public class offer07 {
    private Map<Integer,Integer>indexMap;
    public TreeNode myBuilderTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right)
    {
        if(preorder_left>preorder_right)//
            return null;
        //前序遍历的第一个节点就是根节点
        int preorder_root=preorder_left;
        //在中序遍历中定位根节点
        int inorder_root=indexMap.get(preorder[preorder_root]);
        //根节点的建立
        TreeNode root=new TreeNode(preorder[preorder_root]);
        //左子树的数目
        int size_leftsubtree=inorder_root-inorder_left;
        //递归的构造左子树，连接根节点
        //先序遍历，从左边界+1开始的
        root.left=myBuilderTree(preorder,inorder,preorder_left+1,preorder_left+size_leftsubtree,inorder_left,inorder_root-1);
        root.right=myBuilderTree(preorder,inorder,preorder_left+size_leftsubtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
     int n=preorder.length;
     indexMap=new HashMap<Integer,Integer>();
     for(int i=0;i<n;i++)
         indexMap.put(inorder[i],i);
     return myBuilderTree(preorder,inorder,0,n-1,0,n-1);
    }
    @Test
    public void test()
    {

    }
}
