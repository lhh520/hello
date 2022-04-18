import org.junit.Test;

import java.util.*;

public class test347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int[] occ=new int[k];
        int maxtime=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            if(entry.getValue()>maxtime)
            maxtime=entry.getValue();
            //System.out.println(maxtime);
        }
        System.out.println(maxtime);
        while(k>0)
        {
            for(Map.Entry<Integer,Integer>entry:map.entrySet())
            {
               // System.out.println(entry.getValue());
                if(entry.getValue()==maxtime)
                {
                    occ[k-1]=entry.getKey();
                  k--;
                }


            }
            maxtime--;
        }
        return occ;
}
@Test
    public void test()
   {
     int[] nums=new int[]{1,1,1,2,2,3};
       System.out.println(topKFrequent(nums,2));
   }
}
