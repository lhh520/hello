package testproject;

public class 逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int low=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            low=Math.min(low,sum);
        }
        if(low>=0){
            return 1;
        }else {
            return 1-low;
        }

    }
}
