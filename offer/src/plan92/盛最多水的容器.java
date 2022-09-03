package plan92;

import org.junit.Test;

public class 盛最多水的容器 {
    public int maxArea(int[] height){
        int l=0,r=height.length-1;
        int area=0;
        int max=0;
        while (l<=r){
            area=Math.min(height[l],height[r])*(r-l);
            max=Math.max(max,area);
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
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
