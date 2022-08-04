package testproject;

public class 最大子序列交替和 {
    public long maxAlternatingSum(int[] nums) {
        int len=nums.length;
        //以i为奇数位置结尾最大
        long[]o=new long[len];
        long[]e=new long[len];//以i作为偶数最大值
        e[0]=nums[0];
        for(int i=1;i<e.length;i++){
            e[i]=Math.max(o[i-1]+nums[i],e[i-1]);
            o[i]=Math.max(e[i-1]-nums[i],o[i-1]);
        }
        return e[len-1];
    }
}
