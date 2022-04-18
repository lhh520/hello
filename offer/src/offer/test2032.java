package offer;

import java.util.*;

public class test2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {   if(set.add(nums1[i]))
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        set.clear();
        for(int i=0;i<nums2.length;i++)
        {   if(set.add(nums2[i]))
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        set.clear();
        for(int i=0;i<nums3.length;i++)
        {    if(set.add(nums3[i]))
            map.put(nums3[i],map.getOrDefault(nums3[i],0)+1);
        }
        List<Integer>list=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry: map.entrySet())
        {
            if(entry.getValue()>=2)
                list.add(entry.getKey());
        }

        return list;
    }
}
