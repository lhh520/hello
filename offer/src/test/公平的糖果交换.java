package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 公平的糖果交换 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int target=0;
        target=(sum(aliceSizes)-sum(bobSizes))/2;
        Set<Integer> set=new HashSet<>();
        for(int i:bobSizes){
            set.add(i);
        }
        //
        for(int i=0;i< aliceSizes.length;i++){
            if(set.contains(aliceSizes[i]-target)){
                return new int[]{aliceSizes[i],aliceSizes[i]-target};
            }
        }
        return new int[]{};
    }
    public int sum(int[] aliceSizes){
        int summ=0;
        for(int i=0;i<aliceSizes.length;i++){
            summ+=aliceSizes[i];
        }
        return summ;
    }
    @Test
    public void test(){
        int[]nums1=new int[]{1,1};
        int[]nums2=new int[]{2,2};
        int[]ans=fairCandySwap(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
}
