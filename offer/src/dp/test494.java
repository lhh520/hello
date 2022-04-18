package dp;

public class test494 {
    public int findTargetSumWays(int[] nums, int target) {
       int sum=0;
       for(int i=0;i<nums.length;i++){
           sum=sum+nums[i];
       }
       if((target+sum)%2!=0) return 0;//表示只有0种途径能满足最终的要求
       int size=(target+sum)/2;
       if(size<0) size=-size;
       int[]dp=new int[size+1];
       dp[0]=1;
       for(int i=0;i<nums.length;i++){
           for(int j=size;j>=nums[i];j--){
               dp[j]+=dp[j-nums[i]];//表示当前所有的结果等于
           }
       }
       return dp[size];
    }
}
