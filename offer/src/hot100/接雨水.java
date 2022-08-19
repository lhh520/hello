package hot100;

import org.junit.Test;

public class 接雨水 {
    public int trap(int[] height){
        int sz=height.length;
         int[]left=new int[sz];
         int[]right=new int[sz];
         left[0]=height[0];
         for(int i=1;i<sz;i++){
             left[i]=Math.max(left[i-1],height[i]);
         }
         right[sz-1]=height[sz-1];
         for(int i=sz-2;i>=0;i--){
             right[i]=Math.max(right[i+1],height[i]);
         }
         int ans=0;
         for(int i=0;i<sz;i++){
             ans+=Math.min(left[i],right[i])-height[i];
         }
         return ans;
    }
    @Test
    public void test(){
        int[]height =new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
