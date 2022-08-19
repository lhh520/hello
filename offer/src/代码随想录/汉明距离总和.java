package 代码随想录;

public class 汉明距离总和 {
    public int totalHammingDistance(int[] nums) {
        int ret=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int cur=nums[i]^nums[j];
                ret+=Integer.bitCount(cur);
            }
        }
        return ret;
    }
}
