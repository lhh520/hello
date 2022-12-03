package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class cdcdscsd {
    public int findBottomLeftValue (TreeNode root) {
        // write code here
        if(root==null){
            return 0;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int ret=-1;
        while (!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=q.poll();
                if(i==0){
                    ret=cur.val;
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
        }
        return ret;
    }
    public int[] merge (int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=nums1.length;i<m;i++){
            nums1[i]=nums2[j++];
        }
        Arrays.sort(nums1);
        return nums1;
    }
    @Test
    public void test(){

    }
}
