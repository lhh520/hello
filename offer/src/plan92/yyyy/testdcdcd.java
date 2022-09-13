package plan92.yyyy;

public class testdcdcd {
    int sum=0;
    public int sum (TreeNode root) {
        // write code here
        TreeNode left=root.left,right=root.right;
        if(left!=null){
            dfs(root,left,left.left);
            dfs(root,left,left.right);
        }
        if(right!=null){
            dfs(root,right,right.left);
            dfs(root,right,right.right);
        }
        return sum;

    }
    public void dfs(TreeNode grand,TreeNode par,TreeNode node){
        if(node==null){
            return;
        }
        if(grand.val%2!=0){
            return;
        }
        dfs(par,node,node.left);
        dfs(par,node,node.right);
    }
    class TreeNode {
   int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }
}
