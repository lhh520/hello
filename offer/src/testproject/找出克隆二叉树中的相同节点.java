package testproject;

public class 找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==target){
            return cloned;
        }
        TreeNode ans=null;
        if(original.left!=null){
            ans=getTargetCopy(original.left,cloned.left,target);
        }
        if(ans==null&&original.right!=null){
            return getTargetCopy(original.right,cloned.right,target);
        }
        return ans;
    }
}
