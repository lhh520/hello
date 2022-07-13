package 代码随想录;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 大餐计数 {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal=0;
        for(int val:deliciousness){
            maxVal=Math.max(maxVal,val);
        }
        int maxSum=maxVal*2;
        int pairs=0;
        Map<Integer,Integer>map=new HashMap<>();
        int n=deliciousness.length;
        for(int i=0;i<n;i++){
            int val=deliciousness[i];
            for(int sum=1;sum<maxSum;sum<<=1){
                int count=map.getOrDefault(sum-val,0);
                pairs=(pairs+count)%MOD;
            }
            map.put(val,map.getOrDefault(val,0)+1);
        }
        return pairs;
    }

}
