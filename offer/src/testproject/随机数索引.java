package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class 随机数索引 {
    HashMap<Integer, List<Integer>>map;
    Random random;
    public 随机数索引(int[] nums) {
        map=new HashMap<>();
        random=new Random();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer>temp=map.get(nums[i]);
                temp.add(i);
                map.put(nums[i],new ArrayList<>(temp));
            }else {
                List<Integer>temp=map.get(nums[i]);
                temp.add(i);
                map.put(nums[i],new ArrayList<>(temp));
            }
        }
    }

    public int pick(int target) {
        if(map.containsKey(target)){
            List<Integer>temp=map.get(target);
            return temp.get(temp.get(random.nextInt(temp.size())));
        }else {
            return -1;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,3,3};
        随机数索引 h=new 随机数索引(nums);
        System.out.println(h.pick(3));
    }
}
