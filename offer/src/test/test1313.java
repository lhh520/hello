package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i=i+2)
        {
            int a=nums[i];
            int b=nums[i];
            for(int j=0;j<b;j++)
                list.add(a);
        }
        int[]nu=new int[list.size()];
        for (int i = 0; i <list.size(); i++) {
            nu[i]=list.get(i);
        }
        return nu;
    }
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int a=0;
        for (int i = 0; i <s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            a=map.get(s.charAt(i));
        }

        for(Map.Entry<Character,Integer>entry: map.entrySet())
        {
            int b=entry.getValue();
            if(b!=a)
                return false;
        }
        return true;
    }
}
