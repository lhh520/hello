package LCP;

public class 盛最多水的容器 {
    public int maxArea(int[] height){
        int maxAre=0;
        int left=0,right=height.length-1;
        while (left<right){
            int min=Math.min(height[left],height[right]);
            maxAre=Math.max(maxAre,min*(right-left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxAre;
    }
}
