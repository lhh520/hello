package hot100;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ret=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i< nums.length-2;i++){
            int l=i+1,r=nums.length-1;
            while (l<r){
                if(nums[i]+nums[r]+nums[l]<0){
                    l++;
                }else if(nums[i]+nums[r]+nums[l]>0){
                    r--;
                }else {
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(set.add(new ArrayList<>(list)))
                    ret.add(new ArrayList<>(list));
                    l++;
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>ret=threeSum(nums);
        for(List<Integer>kk:ret){
            System.out.println(kk.toString());
        }
    }
}
