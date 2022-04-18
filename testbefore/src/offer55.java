import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class offer55 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else
        {
            return Math.abs(heigh(root.left)-heigh(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int heigh(TreeNode root)
    {
        if(root==null)
            return 0;
        else
            return Math.max(heigh(root.left),heigh(root.right))+1;
    }
    @Test
    public void test()
    {
   List<Integer>list=new ArrayList<>();
   list.add(1);
   list.add(2);
        System.out.println(list.toString());
    }
}
