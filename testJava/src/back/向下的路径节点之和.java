package back;

public class 向下的路径节点之和 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int ret=dfs(root,targetSum);
        ret+=dfs(root.left,targetSum);
        ret+=dfs(root.right,targetSum);
        return ret;
    }
    public int dfs(TreeNode root,int targetSum){
        int ret=0;
        if(root==null){
            return 0;
        }
        if(root.val==targetSum){
            ret++;
        }
        ret+=dfs(root.left,targetSum-root.val);
        ret+=dfs(root.right,targetSum-root.val);
        return ret;
    }
}
