package plan92.yyyy;
import org.junit.Test;

import java.util.*;
public class test84848 {

        private Map<Integer,Integer> indexMap;
        public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
            // write code here
            int[]preorder=new int[preOrder.size()];
            for(int i=0;i<preOrder.size();i++){
                preorder[i]=preOrder.get(i);
            }
            int[]inorder=new int[inOrder.size()];
            for(int i=0;i<inOrder.size();i++){
                inorder[i]=inOrder.get(i);
            }
//            System.out.println(Arrays.toString(inorder));
//            System.out.println(Arrays.toString(preorder));
            TreeNode node =buildTree(preorder, inorder);
            ArrayList<TreeNode>ret=new ArrayList<>();
            ret.add(node);
            return ret;

        }
    public int preIndex=0;
    public TreeNode createTreeByPandI(int[] preorder,int[] inorder,int inbegin,int inend){
        if(inbegin>inend){
            //如果满足这个条件，说明没有左树和右树
            return null;
        }

        TreeNode root=new TreeNode(preorder[preIndex]);
        //找到根在中序遍历的位置
        int rootIndex=findIndexOfI(inorder,inbegin,inend,preorder[preIndex]);
        if(rootIndex==-1){
            return null;
        }
        preIndex++;
        //分别创建左子树和右子树
        root.left=createTreeByPandI(preorder,inorder,inbegin,rootIndex-1);
        root.right=createTreeByPandI(preorder,inorder,rootIndex+1,inend);
        return root;
    }
    private int findIndexOfI(int[] inorder,int inbegin,int inend,int key){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==key){
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null)  return null;
        return createTreeByPandI(preorder,inorder,0,inorder.length-1);
    }




    @Test
        public void test(){

            ArrayList<Integer>preOrder=new ArrayList<>();
            preOrder.add(1);
            preOrder.add(1);
            preOrder.add(2);
            ArrayList<Integer>inOrder=new ArrayList<>();
            inOrder.add(1);
            inOrder.add(2);
            inOrder.add(1);
            getBinaryTrees(preOrder,inOrder);
        }


    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



