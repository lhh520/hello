package test;

public class 路径总和III {
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        dfs(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }
    public void dfs(TreeNode root,int targetSum){
        if(root==null){
            return;
        }
        targetSum-=root.val;
        if(targetSum==0){
            count++;
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }
}
