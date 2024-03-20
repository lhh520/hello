package 新刷题;

public class 合并后数组中的最大元素 {
    public long maxArrayValue(int[] nums) {
        //从后向前进行数组的合并
        long res=nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){
            if(res>=nums[i-1]){
                res+=nums[i-1];
            }else {
                res=nums[i-1];
            }
        }
        return res;
    }
}
