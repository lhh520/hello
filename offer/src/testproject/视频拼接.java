package testproject;

import org.junit.Test;

import java.util.*;

public class 视频拼接 {
    public int videoStitching(int[][] clips, int time) {
        int[]dp=new int[time+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<=time;i++){
            for(int[] clip:clips){
                if(clip[0]<i&&i<=clip[1]){
                    dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[time]==Integer.MAX_VALUE-1?-1:dp[time];
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        System.out.println(videoStitching(nums,3));
    }
}
