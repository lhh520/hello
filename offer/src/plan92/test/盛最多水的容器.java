package plan92.test;

import org.junit.Test;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while (left<right){
            int min=Math.min(height[left],height[right]);
            int len=right-left;
            max=Math.max(max,len*min);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
