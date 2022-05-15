package 热题100;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int ans=Integer.MIN_VALUE;
        while (l<r){
            int area=(height[r]-height[l])*(r-l);
            ans=Math.max(area,ans);
            if(height[l]<=height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
