package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
       List<Integer> list1=new ArrayList<>();
       List<Integer> list2=new ArrayList<>();
       int count=0;
       for(int i=0;i<nums.length;i++){
          if(nums[i]>0)
              list1.add(nums[i]);
          if(nums[i]<0)
              list2.add(nums[i]);
          if(nums[i]==0)
              count++;
       }
        Collections.sort(list1);
        Collections.sort(list2);
        int i=0,j=0;
        while(k>0&&j<list2.size()&&list2.size()>0){
            list2.set(j,-list2.get(j));
            k--;
            j++;
        }
        System.out.println(list2.toString());
        if(k!=0&&count>0)
            k=0;
        if(k!=0&&list1.size()>0&&k%2!=0){
            if(list1.get(0)>list2.get(list2.size()-1))
            list2.set(list2.size()-1,-list2.get(list2.size()-1));
            else
                list1.set(0,-list1.get(0));
        }
        int sum=0;
        for(int ii=0;ii<list1.size();ii++){
            sum=sum+list1.get(ii);
        }
        for(int ii=0;ii<list2.size();ii++){
            sum=sum+list2.get(ii);
        }
        return sum;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-8,3,-5,-3,-5,-2};
        System.out.println(largestSumAfterKNegations(nums,6));
    }
}
