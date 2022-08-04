package testproject;

public class 根到叶路径上的不足节点 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDelete=dfs(root,0,limit);
        if(rootDelete){
            return null;
        }
        return root;
    }
    public boolean dfs(TreeNode root,int val, int limit){
        if(root.left==null&&root.right==null){
            return root.val+val<limit;
        }
        boolean leftDelete=true;
        boolean rightDelete=false;
        if(root.left!=null){
            leftDelete=dfs(root.left,val+root.val,limit);
        }
        if(root.right!=null){
            rightDelete=dfs(root.right,val+root.val,limit);
        }
        if(leftDelete){
            root.left=null;
        }
        if(rightDelete){
            root.right=null;
        }
        return leftDelete&&rightDelete;
    }
}
