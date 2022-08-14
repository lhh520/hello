package 代码随想录二刷.回溯;

public class 摆动序列 {
    public int wiggleMaxLength(int[] nums){
        int curdiff=0;
        int prediff=0;
        int res=1;
        for(int i=0;i<nums.length;i++){
            if((curdiff>0&&prediff<=0)||(curdiff<0&&prediff>=0)){
                res++;
                prediff=curdiff;//更新最新的值
            }
        }
        return res;
    }
    public int wiggleMaxLength1(int[] nums){
        int[][]dp=new int[nums.length][2];
        dp[0][0]=1;
        dp[0][1]=1;
        for(int i=1;i< nums.length;i++){
            dp[i][0]=1;
            dp[i][1]=1;
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]){//i是波谷
                    dp[i][1]=Math.max(dp[j][0]+1,dp[i][1]);
                }
                if(nums[j]<nums[i]){
                    dp[i][0]=Math.max(dp[j][1]+1,dp[i][0]);
                }
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
