package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {
    HashMap<Integer, List<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        map=new HashMap<>();
        random=new Random();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer>temp=map.get(nums[i]);
                temp.add(i);
                map.put(nums[i],new ArrayList<>(temp));
            }else {
                List<Integer>temp=new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }
        }
    }
    public int pick(int target) {
        if(map.containsKey(target)){
            List<Integer>temp=map.get(target);
            int ran=random.nextInt(temp.size());
            return temp.get(ran);
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[]nums=new int[]{1,2,3,3,3};
        Solution solution=new Solution(nums);
        System.out.println(solution.pick(3));
    }
}
