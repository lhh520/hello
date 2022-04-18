package offertest1;

import offer.TreeNode;
import org.junit.Test;

import java.util.HashMap;

public class offer07 {
    HashMap<Integer,Integer>map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         map=new HashMap<>();
         int n=inorder.length;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return my(preorder,inorder,0,n-1,0,n-1);

    }
    public TreeNode my(int[] preorder, int[] inorder,int pre_left,int pre_right,int inorder_left,int inorder_right){
       if(pre_left>pre_right){
           return null;
       }
       int preorder_root=pre_left;
       int inorder_root=map.get(preorder[preorder_root]);//得到索引
       //建立根节点
       TreeNode root=new TreeNode(preorder[preorder_root]);//建立根节点
        //得到左子树的数目
       int size_left=inorder_root-inorder_left;
        //root.left=my(preorder,inorder,pre_left+1,pre_left+size_left,inorder_left,inorder_root-1);
        //root.right=my(preorder,inorder,pre_left+size_left+1,pre_right,inorder_root+1,inorder_right);
        return root;
    }
    @Test
    public void test(){

    }
}
