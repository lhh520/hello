import org.junit.Test;

public class testface0410 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //System.out.println(search(t1,t2));
        return dfs(search(t1,t2),t2);
    }
    Boolean dfs(TreeNode t1,TreeNode t2)
    {   if(t1==null&&t2==null)
        return true;
        if(t1==null||t2==null)
            return false;
        if(t1.val!=t2.val)
            return false;
        return dfs(t1.left,t2.left)&&dfs(t1.right,t2.right);
    }
    TreeNode search(TreeNode t1,TreeNode t2)
    {
        if(t1==null)
        return null;
        //System.out.println(t1.val);
        if(t1.val==t2.val)
            return t1;
        if(t1.left!=null)
            return search(t1.left,t2);
        if(t1.right!=null)
            return search(t1.right,t2);
        return null;
    }
    @Test
    public void test()
    {   TreeNode t3=new TreeNode(3);
        TreeNode t2=new TreeNode(2);
        TreeNode t1=new TreeNode(1,t2,t3);
        TreeNode t=new TreeNode(2);
        Boolean ans=checkSubTree(t1,t2);
        System.out.println(ans);
    }
    //正确的解法
    public boolean checkSubTree1(TreeNode t1, TreeNode t2) {
       if(t2==null)
           return  true;
       if(t1==null)
           return false;
       return isTreeEql(t1,t2)||checkSubTree(t1.left,t2)||checkSubTree(t1.right,t2);
    }
    Boolean isTreeEql(TreeNode t1, TreeNode t2)
    {
      if(t1==t2)
          return true;
      if(t1==null||t2==null)
          return false;
      return t1.val==t2.val&&isTreeEql(t1.left,t2.left)&&isTreeEql(t1.right,t2.right);
    }
}
