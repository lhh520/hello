package test;

import org.junit.Test;

import java.util.*;

public class 俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        //先固定一个纬度 接下来求另一个纬度,第一个纬度从小到大 保证一定可以塞进去 第二个纬度从大刀到小
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //第一个从大到小
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });

        int[]nums=new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            nums[i]=envelopes[i][1];//获取第二个数字
        }
        System.out.println(Arrays.toString(nums));
        //开始求最大递增子序列
        int[]dp=new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i=1;i< nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ret=0;
        for (int i=0;i<nums.length;i++){
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]mat=new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(maxEnvelopes(mat));
    }
}
