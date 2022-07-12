package 代码随想录;

public class 按要求补齐数组 {
    public int minPatches(int[] nums, int n) {
        int patches=0;
        long x=1;
        int length=nums.length,index=0;
        while (x<=n){
            if(index<length&&nums[index]<=x){
                x+=nums[index];
                index++;
            }else {
                x*=2;
                patches++;
            }
        }
        return patches;
    }
}
