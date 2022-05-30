package testproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 总持续时间可被60整除的歌曲 {
    public int numPairsDivisibleBy60(int[] time) {
        int count=0;
        int[]seconds=new int[60];
        //将所有的余数进行更新
        for(int i=0;i<time.length;i++){
            int temp=time[i]%60;
            seconds[temp]++;
        }
        count+=combination(seconds[30],2);
        count+=combination(seconds[0],2);
        int i=1, j=59;
        while (i<j){
            count+=seconds[i]*seconds[j];
            i++;
            j--;
        }
        return count;
    }
    public int combination(int  n,int k){
        long res=1;
        for(int i=1;i<=k;i++){
            res=res*(n-i+1)/i;
        }
        return (int)res;
    }
}
