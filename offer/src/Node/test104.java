package Node;

import org.junit.Test;

public class test104 {
    public int maxDepth(TreeNode root) {
      if(root==null)
          return 0;
      return Math.max(depth(root.left),depth(root.right));
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        else
            return Math.max(depth(root.left),depth(root.right))+1;
    }

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftdepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        if(root.left==null){
            return rightDepth+1;
        }
        if(root.right==null){
            return leftdepth+1;
        }
        return Math.min(leftdepth,rightDepth)+1;
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
        System.out.println(minDepth(a));
    }
}
