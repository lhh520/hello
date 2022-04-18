package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans=0;
        Map<Integer,Integer>dp=new HashMap<Integer,Integer>();
        for(int v:arr)
        {
            dp.put(v,dp.getOrDefault(v-difference,0)+1);
            ans=Math.max(ans,dp.get(v));
        }
        return ans;
    }
}
