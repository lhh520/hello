package offer;

import org.junit.Test;

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //1.找到当前的B的第一个节点在整个节点中的位置
        TreeNode C=findB(A,B);
        return isSame(C,B);
    }
    TreeNode findB(TreeNode A, TreeNode B)
    {
        if(A==null)
            return null;
        if(A.val==B.val)
        {
            TreeNode C=A;
            return C;
        }
        TreeNode C= findB(A.left,B);
        if(C!=null)
            return C;
            return findB(A.right,B);
    }
    boolean isSame(TreeNode C, TreeNode B)
    {
        if(C==null&&B==null)
            return true;
        if(C==null||B==null||C.val!=B.val)
            return false;
        return isSame(C.left,B.left)&&isSame(C.right,C.right);
    }
    @Test
    public void test()
    {
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
        System.out.println(isSubStructure(a,f));
    }
}
