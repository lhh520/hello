package Node;

import java.util.LinkedList;
import java.util.Queue;

public class test101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return true;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            int[]nums=new int[sz];
            for(int i=0;i<sz;i++){
                TreeNode temp=queue.poll();
                nums[i]=temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(!isValid(nums)){
                return false;
            }
        }
        return true;
    }
    public boolean isValid(int[]nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[nums.length-1-i])
                return false;
        }
        return true;
    }

    //
    public boolean isSymmetric1(TreeNode root){
        if(root==null)
            return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
