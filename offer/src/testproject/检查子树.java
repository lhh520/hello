package testproject;

public class 检查子树 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t2==null){
            return true;
        }
        if(t1==null){
            return false;
        }
        return isRight(t1,t2)||checkSubTree(t1.left,t2)||checkSubTree(t1.right,t2);
    }
    boolean isRight(TreeNode t1,TreeNode t2){
        if(t1==t2){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return t1.val==t2.val&&isRight(t1.left,t2.left)&&isRight(t1.right,t2.right);
    }
}
