package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 数对和 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])&&map.containsKey(target-nums[i])){//如果包含
                if(nums[i]+nums[i]==target){
                    int count=map.get(nums[i]);
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[i]);
                    for(int j=0;j<count/2;j++){
                        lists.add(new ArrayList<>(list));
                    }
                    map.put(nums[i], count-2*(count/2));
                }else {
                    int count=Math.min(map.get(nums[i]),map.get(target-nums[i]));
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(target-nums[i]);
                    for(int j=0;j<count;j++){
                        lists.add(new ArrayList<>(list));
                    }
                    map.put(nums[i],map.get(nums[i])-count);
                    map.put(target-nums[i],map.get(target-nums[i])-count);
                    if(map.get(nums[i])-count==0){
                        map.remove(nums[i]);
                    }
                    if(map.get(target-nums[i])-count==0){
                        map.remove(target-nums[i]);
                    }
                }
            }
        }
        return lists;
    }
}
