package 新刷题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int len=height.length;
        int left=0,right=len-1;
        int max=-1;
        while (left<right){
            int cur=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,cur);
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
