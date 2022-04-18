package Hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                //list.add(nums1[i]+nums2[j]);
                int temp=nums1[i]+nums2[j];
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        int count=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int temp=nums3[i]+nums4[j];
                if(map.containsKey(-temp)){
                    count=count+map.get(-temp);
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums1 = new int[]{1,2};
        int[]nums2 =new int[]{-2,-1};
        int[]nums3 =new int[]{-1,2};
        int[]nums4=new int[]{0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
