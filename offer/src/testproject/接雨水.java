package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 接雨水 {
    public int trap(int[] height) {
        int n=height.length;
        int res=0;
        for(int i=0;i<height.length;i++){
            if(i==0||i==n-1){
                continue;
            }
            int leftindex=i;
            for(int j=0;j<i;j++){
                if(height[leftindex]<height[j]){
                    leftindex=j;
                }
            }
            int rightindex=i;
            for(int j=i+1;j<n;j++){
                if(height[rightindex]<height[j]){
                    rightindex=j;
                }
            }
            int curheight=Math.min(height[leftindex],height[rightindex])-height[i];
            if(curheight>0)
            res=res+curheight;
        }
        return res;
    }
    public int trap2(int[] height){
        int sz=height.length;
        int[]left=new int[sz];
        int[]right=new int[sz];
        left[0]=height[0];
        for(int i=1;i<sz;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        System.out.println(Arrays.toString(left));
        right[sz-1]=height[sz-1];
        for(int i=sz-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        System.out.println(Arrays.toString(right));
        int ans=0;
        for(int i=0;i<sz;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(nums));
    }
}
