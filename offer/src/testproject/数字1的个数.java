package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class 数字1的个数 {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=arr.clone();
        Arrays.sort(nums);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(!map.containsKey(nums[i]))
            map.put(nums[i],i);
        }
        //System.out.println(1);
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            arr[i]=map.get(temp)+1;
        }
        return arr;
    }
    @Test
    public void test(){
        int[]arr=new int[]{100,100,100};
        int[]ans=arrayRankTransform(arr);
        System.out.println(Arrays.toString(ans));
    }
}
