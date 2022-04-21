package offer03;

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&(recure(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    boolean recure(TreeNode A,TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;
        return recure(A.left,B.left)&&recure(A.right,B.right);
    }
}
