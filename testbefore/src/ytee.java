import org.junit.Test;

import java.util.*;
public class ytee {
    public  int AmountOfCombination(int[] nums, int target) {
        //请在这里实现算法并返回结果
        int amount = 0;

        List<List<Integer>>ret=new ArrayList<>();
        int num=0;
        if(nums==null||nums.length<4){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                 break;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>0&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j+1]+nums[j+2]+nums[j+3]>target){
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target){
                    continue;
                }
                int left=j+1,right=nums.length-1;
                while (left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        num++;
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum<target){
                        left++;
                    }else {
                        right--;
                    }

                }
            }
        }
        return num;

    }
    @Test
    public void test(){
        //1,0,-1,0,-2,2
        //0
        int[]nums=new int[]{1,0,-1,0,-2,2};
        System.out.println(AmountOfCombination(nums,0));
    }
}
