package backtrace;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static boolean check(int[]nums,int target){
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.isEmpty()&&map.containsKey(target-nums[i])){
                return true;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
    public static boolean check1(int[]nums,int target){
        for(int i=0;i<nums.length;i++){
            if(bina(nums,target-nums[i],i)){
                return true;
            }
        }
        return false;
    }
    public static boolean bina(int[]nums,int target,int index){
        int left=index+1,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[]nums=new int[]{1,2,2,3,4,5,6};
        System.out.println(check(nums,4));
        System.out.println(check1(nums,7));
    }
}
