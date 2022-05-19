package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 最长斐波那契数列 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int[][]dp=new int[arr.length][arr.length];
        int res=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i]-arr[j];
                if(map.containsKey(temp)&&map.get(temp)<j){
                    dp[i][j]=dp[j][map.get(temp)]+1;
                    res=Math.max(res,dp[i][j]);
                }else {
                    dp[i][j]=2;
                }
            }
        }
        return res;
    }
    public int lenLongestFibSubseq1(int[] arr) {
        int[][]dp=new int[arr.length][arr.length];
        //dp[i][j] 表示以i结尾，最后一个位置是j的个数
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i]-arr[j];
                if(map.containsKey(temp)&&map.get(temp)<j){
                    dp[i][j]=dp[j][map.get(temp)]+1;
                    res=Math.max(res,dp[i][j]);
                }else {
                    dp[i][j]=2;
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
