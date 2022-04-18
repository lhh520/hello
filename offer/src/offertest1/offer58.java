package offertest1;

import org.junit.Test;

import java.util.HashMap;

public class offer58 {
    public int search(int[] nums, int target) {
    int left=0,right=nums.length-1;
    while (left<right){
        int mid=(right+left)/2;
        if(nums[mid]==target)
            return nums[mid];
        if(nums[mid]<target){
            left=mid+1;
        }else {
            right=mid-1;
        }
    }
    return -1;
    }
    public int search1(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        return 0;
    }
    @Test
    public void test(){
        int[]nums=new int[]{5,7,7,8,8,10};
        System.out.println(search1(nums,8));
    }
}
