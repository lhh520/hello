package testproject;

public class 只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int[]cnt=new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                if(((nums[i]>>j)&1)==1){
                    cnt[j]++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<32;i++){//所有的一共有32位，进行
            if (cnt[i]%3!=0) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
