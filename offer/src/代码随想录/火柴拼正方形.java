package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 火柴拼正方形 {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        Arrays.sort(matchsticks);
        if(sum%4!=0||matchsticks[matchsticks.length-1]>sum/4){
            return false;
        }
        int target=sum/4;
        //System.out.println(target);
        int[]dp=new int[target+1];
        int[]dp1=new int[target*2+1];
        dp[0]=0;
        dp1[0]=0;
        for(int i=0;i<matchsticks.length;i++){
            for(int j=target;j>=matchsticks[i];j--){
                dp[j]=Math.max(dp[j],dp[j-matchsticks[i]]+matchsticks[i]);
            }
        }

        for(int i=0;i<matchsticks.length;i++){
            for(int j=target*2;j>=matchsticks[i];j--){
                dp1[j]=Math.max(dp1[j],dp1[j-matchsticks[i]]+matchsticks[i]);
            }
        }
        return dp[target]==target&&dp1[2*target]==2*target;
    }

    public boolean makesquare1(int[] matchsticks){
        Arrays.sort(matchsticks);//先进行排序
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        int[]bucket=new int[4];
        Arrays.fill(bucket,0);
        return backtrace(0,matchsticks,bucket,sum/4);
    }
    public boolean backtrace(int index,int[]matchsticks,int[] bucket,int edge){
        if(index>=matchsticks.length){
            return true;
        }
        for(int j=0;j<4;j++){
            if(bucket[j]+matchsticks[index]>edge){
                continue;
            }
            bucket[j]+=matchsticks[index];
            if(backtrace(index+1,matchsticks,bucket,edge)){
                return true;
            }
            bucket[j]-=matchsticks[index];
        }
        return false;
    }

    @Test
    public void test(){

    }
}
