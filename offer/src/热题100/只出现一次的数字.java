package 热题100;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int num=nums[0];
        for(int i=1;i<nums.length;i++){
            num^=nums[i];
        }
        return num;
    }
}
