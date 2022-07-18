package testproject;

public class 节点与其祖先之间的最大差值 {
    public int maxAncestorDiff(TreeNode root) {
        //先访问头节点 那我需要记录的是当前节点的 最大值 和最小值
        return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root,int lower,int upper){
        if(root==null){
            return 0;
        }
        int max=Math.max(Math.abs(root.val-lower),Math.abs(root.val-upper));
        int left=0,right=0;
        if(root.val<lower){//小于最小值 则考虑更新左右
            left=dfs(root.left,root.val,upper);
            right=dfs(root.right,root.val,upper);
        }else if(root.val>upper){
            left=dfs(root.left,lower,root.val);
            right=dfs(root.right,lower,root.val);
        }else {
            left=dfs(root.left,lower,upper);
            right=dfs(root.right,lower,upper);
        }
        return Math.max(max,Math.max(left,right));
    }
}
