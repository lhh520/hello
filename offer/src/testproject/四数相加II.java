package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<Integer>list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int temp=nums1[i]+nums2[j];
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        int count=0;
        for(int i=0;i<nums2.length;i++){
            for(int j=0;j<nums3.length;j++){
                int temp=nums2[i]+nums3[j];
                count=count+map.getOrDefault(-temp,0);
            }
        }
        return count;
    }
    @Test
    public void test(){

    }
}
