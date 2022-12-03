package dp;
import java.util.*;
public class test999 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int ret=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            ret++;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return ret;
    }
    /*
    select STU,
     group by STU,CLASS
     select distinct Salary as SEcondHighestSalary from Employee order by Salary  limit 1,1
    * */


}
