package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 找到最接近0的数字 {
    public int findClosestNumber(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1=Math.abs(o1);
                int num2=Math.abs(o2);
                if(num1==num2){
                    return o2-o1;
                }
                return num1-num2;
            }
        });
        return list.get(0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));
    }
}
