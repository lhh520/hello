package 热题100;

import java.util.HashMap;
import java.util.Map;

public class 最长的斐波那契子序列的长度 {
    public int lenLongestFibSubseq(int[] arr){
        int len=arr.length;
        int[][]dp=new int[len][len];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(arr[i],i);
        }
        int res=0;
        for(int i=1;i<arr.length;i++){//长度为i 并且以j结尾的
            for(int j=0;j<i;j++){
                int temp=arr[i]-arr[j];
                if(map.containsKey(temp)&&map.get(temp)<j){//存在更小的数字
                    dp[i][j]=dp[j][map.get(temp)]+1;
                    res=Math.max(res,dp[i][j]);
                }else {
                    dp[i][j]=2;
                }
            }
        }
        return res;
    }
}
