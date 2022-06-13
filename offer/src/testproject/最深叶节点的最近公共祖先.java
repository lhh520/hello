package testproject;

public class 最深叶节点的最近公共祖先 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return null;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left==right) return root;
        else if(left<right) return lcaDeepestLeaves(root.right);
        return lcaDeepestLeaves(root.left);
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(dfs(root.left),dfs(root.right));
    }
}
