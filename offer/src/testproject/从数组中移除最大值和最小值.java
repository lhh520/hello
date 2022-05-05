package testproject;

import org.junit.Test;

import java.util.HashMap;

public class 从数组中移除最大值和最小值 {
    public int minimumDeletions(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            map.put(nums[i],i);
        }
        int ma=map.get(max);
        int mi=map.get(min);
        int n1=Math.max(ma,mi)+1;
        int n2=Math.max(nums.length-ma,nums.length-mi);
        int n3=Math.min(ma+nums.length-mi+1,mi+nums.length-ma+1);
        System.out.println("n1: "+n1+" n2: "+n2+" n3:"+n3);
        return Math.min(Math.min(n1,n2),n3);
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,-4,19,1,8,-2,-3,5};
        System.out.println(minimumDeletions(nums));
    }
}
