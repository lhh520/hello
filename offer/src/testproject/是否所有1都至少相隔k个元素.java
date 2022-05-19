package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 是否所有1都至少相隔k个元素 {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                list.add(i);
            }
        }
        for(int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)<k){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,0,0,0,1,0,0,1};
        System.out.println(kLengthApart(nums,2));
    }
}
