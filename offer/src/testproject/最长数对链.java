package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        for(int[]ii:pairs){
            System.out.println(Arrays.toString(ii));
        }
        int n=pairs.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        System.out.println(Arrays.toString(dp));
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        System.out.println(findLongestChain(nums));
    }
}
